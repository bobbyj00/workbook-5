package com.pluralsight;

import java.time.Year;

class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        double value;

        if (age <= 3) {
            value = getOriginalCost() * Math.pow(0.97, age);
        } else if (age <= 6) {
            value = getOriginalCost() * Math.pow(0.94, age - 3) * Math.pow(0.97, 3);
        } else if (age <= 10) {
            value = getOriginalCost() * Math.pow(0.88, age - 6) * Math.pow(0.94, 3) * Math.pow(0.97, 3);
        } else {
            value = 1000.0;
        }

        if (odometer > 100000 &&
                !(makeModel.toLowerCase().contains("honda") || makeModel.toLowerCase().contains("toyota"))) {
            value *= 0.75;  // reduce by 25%
        }

        return value;
    }
}
