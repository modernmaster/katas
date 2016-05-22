package uk.co.mcguigan.fizzbuzz;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTests {

    private Substitute fizzBuzzSubstitute;
    private Substitute fizzSubstitute;
    private Substitute buzzSubstitute;
    private Substitute luckySubstitute;
    private SubstituteImpl fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzzSubstitute = new FizzBuzzSubstitute();
        fizzSubstitute = new FizzSubstitute();
        buzzSubstitute = new BuzzSubstitute();
        luckySubstitute = new LuckySubstitute();
        fizzBuzz = new SubstituteImpl();
    }

    @Test
    public void testGeneratedOutputForFizzBuzzIsCorrect() {
        final int minimumValue = 1;
        final int maximumValue = 20;
        final String expectedOutput = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz \r\n";
        fizzBuzz.addSubstitute(fizzBuzzSubstitute);
        fizzBuzz.addSubstitute(fizzSubstitute);
        fizzBuzz.addSubstitute(buzzSubstitute);

        final String actualOutput = fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testOutputExceptionWithMinimumValueOfZero() {
        final int minimumValue = 0;
        final int maximumValue = 20;

        fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testOutputExceptionWithNegativeNumbers() {
        final int minimumValue = -1;
        final int maximumValue = 20;

        fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testOutputExceptionWithMinimumValueGreaterThanMaximum() {
        final int minimumValue = 20;
        final int maximumValue = 1;

        fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testOutputWithNumbersGreaterThanDefinedMaximum() {
        final int minimumValue = 1;
        final int maximumValue = 101;

        fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);
    }

    @Test
    public void testGeneratedOutputForFizzBuzzWithLuckyIsCorrect() {
        final int minimumValue = 1;
        final int maximumValue = 20;
        final String expectedOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz \r\n";
        fizzBuzz.addSubstitute(fizzBuzzSubstitute);
        fizzBuzz.addSubstitute(fizzSubstitute);
        fizzBuzz.addSubstitute(buzzSubstitute);
        fizzBuzz.addSubstitute(luckySubstitute);

        String generatedSequence = fizzBuzz.generateSubstitutedSequence(minimumValue, maximumValue);

        Assert.assertEquals(expectedOutput, generatedSequence);
    }

    @Test
    public void testOutputACorrectRepresentationOfReport(){
        final int minimumValue = 1;
        final int maximumValue = 20;
        final String expectedOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz \r\n"
                + "fizz: 4\r\n"
                + "buzz: 3\r\n"
                + "fizzbuzz: 1\r\n"
                + "lucky: 2\r\n"
                + "integer: 10\r\n";
        fizzBuzz.addSubstitute(luckySubstitute);
        fizzBuzz.addSubstitute(fizzBuzzSubstitute);
        fizzBuzz.addSubstitute(fizzSubstitute);
        fizzBuzz.addSubstitute(buzzSubstitute);

        String report = fizzBuzz.generateReport(minimumValue, maximumValue);
        Assert.assertEquals(expectedOutput, report);
    }

}
