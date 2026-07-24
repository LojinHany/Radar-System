package service;

import model.CarDetails;
import model.Fine;
import model.Violation;
import rules.ViolationRule;

import java.util.ArrayList;
import java.util.List;

public class Radar {
    private List<ViolationRule> rules;
    private FineManager fineManager;

    public Radar(FineManager fineManager) {
        rules = new ArrayList<>();
        this.fineManager = fineManager;
    }

    public void addRule(ViolationRule rule) {
        rules.add(rule);
    }

    public void process(CarDetails car) {
        List<Violation> violations = new ArrayList<>();

        for (ViolationRule rule : rules) {
            Violation violation = rule.checkRule(car);
            if (violation != null) {
                violations.add(violation);
            }
        }

        if (!violations.isEmpty()) {
            Fine fine = new Fine(car.getPlateNum(), car.getDate(), violations);
            fineManager.addFine(fine);
            fine.printFine();
        }
    }
}
