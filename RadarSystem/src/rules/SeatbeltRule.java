package rules;

import model.CarDetails;
import model.Violation;

public class SeatbeltRule implements ViolationRule {
    private static final float FEES = 100;

    @Override
    public Violation checkRule(CarDetails car) {
        if (!car.getSeatbeltStatus()) {
            return new Violation("Seatbelt Rule", "Seatbelt not fastened : ", FEES);
        }
        return null;
    }
}
