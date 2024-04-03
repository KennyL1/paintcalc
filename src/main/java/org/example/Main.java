package org.example;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        double surfaceTotalArea = 0;
        double totalNoPaintArea = 0;
        double totalPaintArea = 0;
        double priceTotal = 0;
        int tinTotal = 0;
        double[] priceAndTins = new double[2];

        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the amount of surfaces you will be painting for this job:");
        double surfaceAmount = Double.parseDouble(reader.next());

        // Runs for-loop for every surface to paint
        for (int i = 0; i < surfaceAmount; i++){


            System.out.println("Please enter the shape of surface " + (i + 1) + " (Square/Triangle):");
            String surfaceShape = reader.next();
            System.out.println("Please enter the height of surface " + (i + 1) + " in mm");
            double surfaceHeight = Double.parseDouble(reader.next());
            System.out.println("Please enter the width of surface " + (i + 1) + " in mm");
            double surfaceWidth = Double.parseDouble(reader.next());


            System.out.println("For surface " + (i + 1) + " how many surfaces are there that will not be painted (e.g. windows)?");
            int  windowAmount = Integer.parseInt(reader.next());

            surfaceTotalArea = calculateArea(surfaceHeight, surfaceWidth, surfaceShape);
            // if there is at least one section not to paint
            if (windowAmount > 0) {
                totalNoPaintArea = calculateNoPaintArea(windowAmount);
            }
            totalPaintArea = surfaceTotalArea - totalNoPaintArea;

            // calculate price for each surface and amount of tins and add onto total
            priceAndTins = calculatePrice(totalPaintArea);
            priceTotal += priceAndTins[0];
            tinTotal += (int)priceAndTins[1];

        }

        System.out.println("The total cost for the entire job is £" + priceTotal + " and will require " + tinTotal + " tins.");

    }

    private static double calculateArea(double height, double width, String shape) {

        double totalArea = 0;
        if (shape.equals("Square")) {
            totalArea = height * width;
        } else if (shape.equals("Triangle")) {
            totalArea = (height * width)/2;
        }

        return totalArea;
    }

    private static double[] calculatePrice(double totalArea) {

        double totalPrice = 0;
        double totalTins;

        double[] totalBoth = new double[2];
        Scanner reader = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("Which of the following paint colours would you like to use for this surface? (Please enter the corresponding number)");
        System.out.println("1: Absolute White (£31.26/2.5L)");
        System.out.println("2: Atlantic Blue (£44.69/2.5L)");
        System.out.println("3: Salsa Red (£44.69/2.5L)");
        int chosenColour = Integer.parseInt(reader.next());

        // calculate minimum number of tins needed
        totalTins = (int)Math.ceil(totalArea / 32500000); // total number of mm2 covered per 2.5L tin
        totalBoth[1] = totalTins;

        if (chosenColour == 1) {
            totalPrice = totalTins * 31.26;
            System.out.println("You will need to use at least " + (int)totalTins + " tins of paint which will cost £" + totalPrice);
            totalBoth[0] = totalPrice;
        } else if (chosenColour == 2) {
            totalPrice = totalTins * 44.69;
            System.out.println("You will need to use at least " + (int)totalTins + " tins of paint which will cost £" + totalPrice);
            totalBoth[0] = totalPrice;
        } else if (chosenColour == 3) {
            totalPrice = totalTins * 44.69;
            System.out.println("You will need to use at least " + (int)totalTins + " tins of paint which will cost £" + totalPrice);
            totalBoth[0] = totalPrice;
        }

        return totalBoth;
    }

    private static double calculateNoPaintArea (int surfaceAmount)
    {
        Scanner reader = new Scanner(System.in);
        double totalNoPaintArea = 0;

        for (int i = 0; i < surfaceAmount; i++) {
            System.out.println("Please enter the shape of surface " + (i + 1) + " (Square/Triangle)");
            String surfaceShape = reader.next();
            System.out.println("Please enter the height of surface " + (i + 1) + " in mm ");
            double surfaceHeight = Double.parseDouble(reader.next());
            System.out.println("Please enter the width of surface " + (i + 1) + " in mm");
            double surfaceWidth = Double.parseDouble(reader.next());

            totalNoPaintArea += calculateArea(surfaceHeight, surfaceWidth, surfaceShape);
        }

        return totalNoPaintArea;
    }
}