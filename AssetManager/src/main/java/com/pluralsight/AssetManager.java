package com.pluralsight;

import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        // Add Houses
        assets.add(new House("My House", "2015-06-15", 300000, "123 Elm St", 1, 2000, 8000));
        assets.add(new House("Vacation Home", "2018-08-01", 250000, "456 Lake View Rd", 2, 1500, 6000));

        // Add Vehicles
        assets.add(new Vehicle("Tom's Truck", "2020-05-20", 35000, "Ford F-150", 2019, 120000));
        assets.add(new Vehicle("My Car", "2022-03-10", 28000, "Toyota Corolla", 2021, 85000));

        // Add Cash
        assets.add(new Cash("Emergency Fund", "2023-01-01", 5000));
        assets.add(new Cash("Under Mattress", "2024-02-15", 2000));

        // Display all assets
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%.2f%n", asset.getOriginalCost());
            System.out.printf("Current Value: $%.2f%n", asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year & Make/Model: " + vehicle.getYear() + " " + vehicle.getMakeModel());
            } else if (asset instanceof Cash) {
                System.out.println("Type: Cash");
            }

            System.out.println("--------------------------------------------------");
        }
    }
}
