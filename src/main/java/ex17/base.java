/*
 *  UCF COP3330 Summer 2021 Assignment 17 Solution
 *  Copyright 2021 Julian Espinoza
 *
 *  Exercise 17 - Blood Alcohol Calculator
 *  Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink.
 *  Calculate your blood alcohol content (BAC) using this formula
 *
 *  Constraint:
 *  Prevent the user from entering non-numeric values.
 *
 */

package ex17;
import java.util.Scanner;

public class base {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Variable initialization
        base myBase = new base();
        double bac, alcohol, weight;
        int hours, gender;

        // Generation of variable values
       gender = myBase.getGender();
       alcohol = myBase.getAlcohol();
       weight = myBase.getWeight();
       hours = myBase.getHours();
       bac = myBase.BAC(gender, weight, alcohol, hours);
       myBase.legality(bac);
    }

    // Function returns alcohol drank in ounces
    public double getAlcohol()
    {
        // User Input Step
        System.out.printf("How many ounces of alcohol did you have? ");
        String alc = userInput.nextLine();
        double alcParse;

        // While statement ensures that numeric values are only entered
        while(Double.parseDouble(alc) < 0 || alc == null || alc.equals(""))
        {
            System.out.printf("This is not a valid number, please enter another. ");
            alc = userInput.nextLine();
        }

        // Parse alcohol and return
        alcParse = Double.parseDouble(alc);
        return alcParse;
    }

    // Function returns weight in ounces
    public double getWeight()
    {
        // User Input Step
        System.out.printf("What is your weight, in pounds? ");
        String weight = userInput.nextLine();
        double weightParse;

        // While statement ensures that numeric values are only entered
        while(Double.parseDouble(weight) < 0 || weight == null || weight.equals(""))
        {
            System.out.printf("This is not a valid number, please enter another. ");
            weight = userInput.nextLine();
        }

        // Parse weight and return
        weightParse = Double.parseDouble(weight);
        return weightParse;
    }

    // Function returns hours since last drink
    public int getHours()
    {
        // User Input Step
        System.out.printf("How many hours has it been since your last drink? ");
        String hour = userInput.nextLine();
        int hourParse;

        // While statement ensures that numeric values are only entered
        while(Integer.parseInt(hour) < 0 || hour == null || hour.equals(""))
        {
            System.out.printf("This is not a valid number, please enter another. ");
            hour = userInput.nextLine();
        }

        // Parse hour and return
        hourParse = Integer.parseInt(hour);
        return hourParse;
    }

    // Function returns gender
    public int getGender()
    {
        // User Input Step
        System.out.printf("Enter a 1 if you are male or a 2 if you are female: ");
        String gender = userInput.nextLine();
        int genParse;

        // While statement ensures that numeric values are only entered
        while((Integer.parseInt(gender) < 1 || Integer.parseInt(gender) > 2) || gender == null || gender.equals(""))
        {
            System.out.printf("This is not a valid number, please enter another. ");
            gender = userInput.nextLine();
        }

        // Parse gender and return
        genParse = Integer.parseInt(gender);
        return genParse;
    }

    // Function returns blood alcohol level
    public double BAC(int gender, double weight, double alcohol, int hours)
    {
        // adr determined by gender value
        double adr;
        if(gender == 1)
        {
            adr = 0.73;
        }
        else
        {
            adr = 0.66;
        }

        // Calculation + return of blood alcohol level
        return (alcohol * 5.14 / weight * adr) - .015 * hours;
    }

    // Function determines legality to drive
    public void legality(double bac)
    {
        System.out.printf("Your BAC is %f%n", bac);

        // If statement determines legality
        if(bac >= 0.08)
        {
            System.out.printf("It is not legal for you to drive.");
        }
        else
        {
            System.out.printf("It is legal for you to drive.");
        }
    }
}
