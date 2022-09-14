/*
Name: Samuel Lee
Date: 9/13/2022
Info: compares date of births and returns older, assignment 1.

*/

import java.util.Scanner;

public class AgeComparison {

    /*
    int agesplitter(int age) {
        String dobirth = Integer.toString(age);

        String year = dobirth.substring(0, 4);
        String month = dobirth.substring(4, 6);
        String date = dobirth.substring(6, 8);

        int years = Integer.parseInt(year);
        int months = Integer.parseInt(month);
        int dates = Integer.parseInt(date);
        // and here i actually read the assignment.
        return();
    }
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("who are we comparing? ");
        String name1 = scanner.nextLine();

        System.out.println("and? ");
        String name2 = scanner.nextLine();

        System.out.print("input date of birth for " + name1 + ": ");
        int dob1 = scanner.nextInt(); //input style == YYYYMMDD

        System.out.println();

        System.out.print("input date of birth for " + name2 + ": ");
        int dob2 = scanner.nextInt(); //input style == YYYYMMDD
        scanner.close();

        // splitting for person 1
        int year1 = dob1 / 10000;
        int month1 = (dob1 % 10000) / 100;
        int day1 = dob1 % 100;

        // splitting for person 2
        int year2 = dob2 / 10000;
        int month2 = (dob2 % 10000) / 100;
        int day2 = dob2 % 100;

        System.out.println();
        // print date of birth in MMDDYYYY format
        System.out.print(name1 + "'s date of birth: ");
        System.out.println(month1 + "/" + day1 + "/" + year1);

        System.out.print(name2 + "'s date of birth: ");
        System.out.println(month2 + "/" + day2 + "/" + year2);

        System.out.println();
        // calculation program
        if (year1 < year2) {
            System.out.println(name1 + " is older than " + name2);
        }
        else if (year1 > year2) {
            System.out.println(name2 + " is older than " + name1);
        }
        else if (month1 < month2) {
            System.out.println(name1 + " is older than " + name2);
        }
        else if (month1 > month2) {
            System.out.println(name2 + " is older than " + name1);
        }
        else if (day1 < day2) {
            System.out.println(name1 + " is older than " + name2);
        }
        else if (day1 > day2) {
            System.out.println(name2 + " is older than " + name1);
        }
        else {
            System.out.println(name1 + " and " + name2 + " have the same date of birth!!");
        }

    }
}
