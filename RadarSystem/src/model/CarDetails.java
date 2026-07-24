package model;

import java.time.LocalDate;

public class CarDetails {
    private String plateNum;
    private CarType type;
    private LocalDate date;
    private float speed;
    private boolean seatbelt;

    public CarDetails(String plateNum, CarType type, LocalDate date, float speed, boolean seatbelt) {
        this.plateNum = plateNum;
        this.type = type;
        this.date = date;
        this.speed = speed;
        this.seatbelt = seatbelt;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public CarType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean getSeatbeltStatus() {
        return seatbelt;
    }


}


