package model;

public class Violation {
    private String ruleName;
    private String ruleDescription;
    private double fees;

    public Violation(String ruleName, String ruleDescription, double fees) {
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.fees = fees;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public double getFees() {
        return fees;
    }
}

