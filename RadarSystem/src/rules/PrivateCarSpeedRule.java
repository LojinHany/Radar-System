package rules;

import model.CarDetails;
import model.Violation;
import model.CarType;

public class PrivateCarSpeedRule implements ViolationRule {
    private static final float MAXSPEED = 80;
    private static final double FEES = 300;

    @Override
    public Violation checkRule(CarDetails car) {
        if (car.getType() == CarType.PRIVATE && car.getSpeed() > MAXSPEED) {
            return new Violation("Private Speed Limit", "Speed of " + (int) car.getSpeed() + " exceeded max allowed " + (int) MAXSPEED + " : ", FEES);
        }

        return null;
    }


}
