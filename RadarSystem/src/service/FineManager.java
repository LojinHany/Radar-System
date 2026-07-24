package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Fine;
import model.Violation;

public class FineManager {
    private List<Fine> fines;

    public FineManager() {
        fines = new ArrayList<>();
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public void printAllFines() {
        System.out.println("\t\t\t\t\t\tAll Fines");

        for (Fine fine : fines) {
            System.out.println(fine.getPlateNum() + " : " + fine.getTotalFees());
        }
        System.out.println();
    }

    public void printTotalFinesPerCar() {
        System.out.println("\t\t\t\t\t\tTotal Fines Per Car");

        Map<String, Double> totalsByPlate = new LinkedHashMap<>();

        for (Fine fine : fines) {
            String plateNum = fine.getPlateNum();
            double updatedTotal = totalsByPlate.getOrDefault(plateNum, 0.0)
                    + fine.getTotalFees();
            totalsByPlate.put(plateNum, updatedTotal);
        }

        for (Map.Entry<String, Double> entry : totalsByPlate.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println();
    }

    public void printViolatedRules() {
        System.out.println("\t\t\t\t\t\tViolated Rules");

        Map<String, Integer> counter = new HashMap<>();
        for (Fine fine : fines) {
            for (Violation violation : fine.getViolations()) {

                String rule = violation.getRuleName();
                counter.put(rule, counter.getOrDefault(rule, 0) + 1);
            }
        }

        for (String rule : counter.keySet()) {
            System.out.println(rule + ": " + counter.get(rule));
        }
    }
}
