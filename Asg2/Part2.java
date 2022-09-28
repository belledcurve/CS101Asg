package Asg2;
/*
name: Samuel Lee
date: 9/27/2022
info: Asg2 - part 2 - digits conversion program
notes: (input) -> decimal -> (output) system.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {

    static int fromElse (String input, int base) {

        // arrays to save digits individually
        // array for input digits
        int[] digits = new int[input.length()];
        // array for digits after calculation
        int[] preaddition = new int[digits.length];

        // splitting digits
        for (int i = 0; i < input.length(); i++) {
            // for all non=hexadecimal inputs.
            if (Character.getType(input.charAt(i)) == 9)
                digits[i] = Integer.parseInt(String.valueOf(input.charAt(i)));

                //for hexadecimal inputs
            else if (Character.getType(input.charAt(i)) == 1 || Character.getType(input.charAt(i)) == 2 ) {

                // enhanced switch statement
                switch (Character.toUpperCase(input.charAt(i))) {
                    case 'A' -> digits[i] = 10;
                    case 'B' -> digits[i] = 11;
                    case 'C' -> digits[i] = 12;
                    case 'D' -> digits[i] = 13;
                    case 'E' -> digits[i] = 14;
                    case 'F' -> digits[i] = 15;
                }
            }
        }

        // calculating input digits into decimal
        for (int i = 0; i < input.length(); i++)
            preaddition[i] = digits[input.length() - 1 - i] * (int) Math.pow(base, i);

        // summing digits to complete decimal value
        int sum = 0;
        for (int j : preaddition) sum += j;

        // complete decimal value
        return sum;
    }

    static void toElse (int input, int base) {
        // first two values of remainder and quotient, because we need an int value
        // instead of a fixed value when running the loop.
        int remainder, quotient;
        quotient = input / base;
        remainder = input % base;

        // Arraylist because we don't know the length of decimal input
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(remainder);

        // conversion rule using MSB and LSB
        while (quotient != 0) {
            remainder = quotient % base;
            quotient /= base;
            digits.add(remainder);
        }

        // reverting order because former arraylist is reversed
        int ii = 0;
        int[] correctdigits = new int[digits.size()];
        for (int i = digits.size(); i >= 1; i--) {
            correctdigits[ii] = digits.get(i - 1);
            ii++;
        }

        // for-each loop
        for (int k : correctdigits)
            System.out.print(k);

        // subscript for each base systems, inserted other base subscripts for future
        switch (base) {
            case 1 -> System.out.println('\u2081');
            case 2 -> System.out.println('\u2082');
            case 3 -> System.out.println('\u2083');
            case 4 -> System.out.println('\u2084');
            case 5 -> System.out.println('\u2085');
            case 6 -> System.out.println('\u2086');
            case 7 -> System.out.println('\u2087');
            case 8 -> System.out.println('\u2088');
            case 9 -> System.out.println('\u2089');
            case 10 -> System.out.println();
            case 16 -> System.out.println("\u2081" + "\u2086");
            default -> System.out.println(" base " + base);
        }
    }

    // same logic to method toElse, but with char because I forgot hex used A - F when writing code for method toElse.
    static void toHex(int input){
        int remainder;
        String tohex = "";
        // revolving hex values by 16
        char[] hexchars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (input != 0)
        {
            remainder = input % 16;
            tohex = hexchars[remainder] + tohex;
            input /= 16;
        }

        System.out.print(tohex);

        System.out.println("\u2081" + "\u2086");

    }

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("available input type:  ");
        System.out.println("bin, dec, oct, hex");
        System.out.print("input type: ");
        String input = scanner.nextLine();

        System.out.print("input #: ");
        String inputno = scanner.nextLine();

        System.out.print("available conversion type:  ");
        System.out.println("bin, dec, oct, hex");
        System.out.print("conversion type: ");
        String export = scanner.nextLine();

        scanner.close();

        System.out.print("converted #: ");

        // initializing variable decimal as int.
        int decimal = 0;

        // control structure for input
        switch (input) {
            case "oct" -> decimal = fromElse(inputno, 8);
            case "bin" -> decimal = fromElse(inputno, 2);
            case "dec" -> decimal = Integer.parseInt(inputno);
            case "hex" -> decimal = fromElse(inputno, 16);
            default -> System.out.println("wrong input");
        }

        // for requirement #1
        if (decimal > 15 || decimal < 0) {
            System.out.println("does not satisfy assignment requirement");
            System.exit(2);
        }

        // control structure for export
        switch (export) {
            case "oct" -> toElse(decimal, 8);
            case "bin" -> toElse(decimal, 2);
            case "dec" -> System.out.println(decimal);
            case "hex" -> toHex(decimal);
            default -> System.out.println("wrong input");
        }

    }
}









/*

//scaffolding


class Test {
    static int fromDec (long num) {
        int decimalNumber = 0, i = 0;
        long remainder;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }

        return decimalNumber;
    }
    public static void main(String[] args) {
        Test test = new Test();

        String one = "123";
        String two = "456";


        int a = test.fromDec(1000);

        one.concat(two);

        System.out.println(test.fromDec(1000));

        int x = 10;
        x = 17;
        System.out.println(2 / 2);

        char subscript = '\u2080';
        System.out.println(subscript);

    }
}




class TestTest {

    public static void toOut (int input, int base) {

        int remainder, quotient;
        quotient = input / base;
        remainder = input % base;

        ArrayList<Integer> digits = new ArrayList<Integer>();
        digits.add(remainder);

        while (quotient != 0) {
            remainder = quotient % base;

            quotient /= base;

            digits.add(remainder);

            //for hexadecimal conversion
            if (base == 16) {
                char hexchar[] = {'0', '1', '2', '3', '4','5','6','7','8','9','A','B','C','D','E','F'};
                //remainder = hexchars[remainder] + remainder;
            }
        }

        int ii = 0;
        int[] correctdigits = new int[digits.size()];
        for (int i = digits.size(); i >= 1; i--) {
            correctdigits[ii] = digits.get(i - 1);
            ii++;
        }

        for (int k : correctdigits)
            System.out.print(k);

        switch (base) {
            case 1: System.out.println('\u2081'); break;
            case 2: System.out.println('\u2082'); break;
            case 3: System.out.println('\u2083'); break;
            case 4: System.out.println('\u2084'); break;
            case 5: System.out.println('\u2085'); break;
            case 6: System.out.println('\u2086'); break;
            case 7: System.out.println('\u2087'); break;
            case 8: System.out.println('\u2088'); break;
            case 9: System.out.println('\u2089'); break;
            case 10: System.out.println(); break;
            case 16: System.out.println("\u2081" + "\u2086"); break;
            default: System.out.println(" base " + base);
        }
    }
    public static void main(String[] args) {

        TestTest out = new TestTest();

        for (int i = 0; i < 100; i++) {
            System.out.print(i + "\t");
            out.toOut(i, 15);
        }


    }
}

class DecimalToHexExample2{
    public static void toHex(int decimal){
        int remainder;
        String hex = "";
        char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal != 0)
        {
            remainder = decimal % 16;
            hex = hexchars[remainder] + hex;
            decimal /= 16;
        }

        System.out.print(hex);

        System.out.println("\u2081" + "\u2086");

    }
    public static void main(String args[]){
        toHex(10);
        toHex(15);
        toHex(289);
    }}


class ElsetoDecimal {
    static int fromElse (String input, int base) {

        int[] digits = new int[input.length()];
        int[] preaddition = new int[digits.length];



        for (int i = 0; i < input.length(); i++) {

            if (Character.getType(input.charAt(i)) == 9)
                digits[i] = Integer.parseInt(String.valueOf(input.charAt(i)));

            //for hexadecimal inputs
            else if(Character.getType(input.charAt(i)) == 1 || Character.getType(input.charAt(i)) == 2 ) {

                switch (Character.toUpperCase(input.charAt(i))) {
                    case 'A':
                        digits[i] = 10;
                        break;
                    case 'B':
                        digits[i] = 11;
                        break;
                    case 'C':
                        digits[i] = 12;
                        break;
                    case 'D':
                        digits[i] = 13;
                        break;
                    case 'E':
                        digits[i] = 14;
                        break;
                    case 'F':
                        digits[i] = 15;
                        break;
                }
            }
        }

        // scaffolding for scaffolding
        for (int l : digits) {
            System.out.print(l);}

        System.out.println();

        for (int i = 0; i < input.length(); i++)
            preaddition[i] = digits[input.length() - 1 - i] * (int) Math.pow(base, i);

        int sum = 0;
        for (int i = 0; i < preaddition.length; i++)
            sum += preaddition[i];

        return sum;
    }

    public static void main (String[] args) {

        ElsetoDecimal test = new ElsetoDecimal();

        System.out.println(test.fromElse("10", 16));

    }
}

class Unicode {
    public static void main (String[] args) {

        System.out.println(
        Character.getType('z'));
    }
}
}

 */
