package model;

import java.time.LocalDate;
import java.util.List;

public class Fine {
    private String plateNum;
    private LocalDate date;
    private List<Violation> violations;
    private double totalFees;

    public Fine(String plateNum, LocalDate date, List<Violation> violations) {
        this.plateNum = plateNum;
        this.date = date;
        this.violations = violations;
        this.totalFees = 0;

        for (Violation violation : violations) {
            totalFees += violation.getFees();
        }
    }

    public String getPlateNum() {
        return plateNum;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void printFine() {
        System.out.println("\nTraffic fine for car " + plateNum + " , Date : " + date);
        System.out.println("Total amount: " + (int) totalFees + " EGP");
        System.out.println("Violations:");

        for (Violation violation : violations) {
            System.out.println("- " + violation.getRuleDescription() + (int) violation.getFees() + " EGP");
        }

        System.out.println();
    }
}
