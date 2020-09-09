package uk.co.mcguigan.fizzbuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public final class SubstituteImpl implements SubstituteGenerator {

    private static final String INTEGERS_MESSAGE = "integer: %s%n";
    private static final int MIN_VALUE = 1;
    private static final String MIN_VALUE_EXCEPTION_MESSAGE = "Minimum value %s in range is less than %s";
    private static final String MAX_VALUE_EXCEPTION_MESSAGE = "Maximum value %s in range is greater than %s";
    private static final String MIN_VALUE_GREATER_THAN_MAN_EXCEPTION_MESSAGE = "Minimum value is greater than maximum %s > %s";
    private static final int MAX_VALUE = 100;
    private static final String REPLACEMENT_MESSAGE = "%s: %s%n";
    private final List<Substitute> substitutes;

    public SubstituteImpl() {
        substitutes = new ArrayList<Substitute>();
    }

    public void addSubstitute(final Substitute substitute) {
        substitutes.add(substitute);
    }

    public String generateSubstitutedSequence(final int minimumValue, final int maximumValue) throws IllegalArgumentException {
        checkInput(minimumValue, maximumValue);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = minimumValue; i <= maximumValue; i++) {
            stringBuilder.append(getTransformation(i)).append(StringUtils.SPACE);
        }
        stringBuilder.append(StringUtils.CR);
        stringBuilder.append(StringUtils.LF);
        return stringBuilder.toString();
    }

    public String generateReport(final int minimumValue, final int maximumValue) throws IllegalArgumentException {
        checkInput(minimumValue, maximumValue);

        final StringBuilder stringBuilder = new StringBuilder();
        int substituteCount = 0;
        final int offsetValue = 1;

        stringBuilder.append(generateSubstitutedSequence(minimumValue, maximumValue));

        Collections.sort(substitutes, new Comparator<Substitute>() {
            public int compare(final Substitute o1, final Substitute o2) {
                return o1.getDisplayOrder() - o2.getDisplayOrder();
            }
        });

        for (Substitute substitute : substitutes) {
            substituteCount += substitute.getUsage();
            stringBuilder.append(String.format(REPLACEMENT_MESSAGE, substitute, substitute.getUsage()));
        }

        stringBuilder.append(String.format(INTEGERS_MESSAGE, maximumValue - minimumValue - substituteCount + offsetValue));
        return stringBuilder.toString();
    }

    protected String getTransformation(final int input) {
        final StringBuilder stringBuilder = new StringBuilder();
        Boolean hasTransformed = false;

        Collections.sort(substitutes, new Comparator<Substitute>() {
            public int compare(final Substitute o1, final Substitute o2) {
                return o1.getProcessOrder() - o2.getProcessOrder();
            }
        });

        for (Substitute substitute : substitutes) {
            if (substitute.condition(input)) {
                stringBuilder.append(substitute.getSubstitute());
                substitute.incrementUsage();
                hasTransformed = true;
                break;
            }
        }
        if (!hasTransformed) {
            return String.valueOf(input);
        }
        return stringBuilder.toString();
    }

    private void checkInput(final int minimumValue, final int maximumValue) throws IllegalArgumentException {
        if (minimumValue < MIN_VALUE) {
            throw new IllegalArgumentException(String.format(MIN_VALUE_EXCEPTION_MESSAGE, minimumValue, MIN_VALUE));
        }
        if (maximumValue > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(MAX_VALUE_EXCEPTION_MESSAGE, maximumValue, MAX_VALUE));
        }
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException(String.format(MIN_VALUE_GREATER_THAN_MAN_EXCEPTION_MESSAGE, minimumValue, maximumValue));
        }
    }
}
