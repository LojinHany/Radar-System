package rules;

import model.CarDetails;
import model.Violation;
import model.CarType;


public class TruckSpeedRule implements ViolationRule {
    private static final float MAXSPEED = 60;
    private static final double FEES = 400;

    @Override
    public Violation checkRule(CarDetails car) {
        if (car.getType() == CarType.TRUCK && car.getSpeed() > MAXSPEED) {
            return new Violation("Truck Speed Limit", "Speed of " + (int) car.getSpeed() + " exceeded max allowed " + (int) MAXSPEED + " : ", FEES);
        }
        return null;
    }

}
