package com.pluralsight;

class Cash extends Asset {
    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    @Override
    public double getValue() {
        return getOriginalCost();
    }
}
