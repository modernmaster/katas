package uk.co.mcguigan.fizzbuzz;

public interface SubstituteGenerator {
    void addSubstitute(Substitute substitute);

    String generateSubstitutedSequence(int minimumValue, int maximumValue);

    String generateReport(int minimumValue, int maximumValue);
}
