package rules;

import model.CarDetails;
import model.Violation;

public interface ViolationRule {
    Violation checkRule(CarDetails car);
}
