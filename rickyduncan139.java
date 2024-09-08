/* 
 Author: Ricky Duncan
SDEV200-11
06/21/2024
Assignment: Module 2 Programming Assignment 3
*/
import java.util.Scanner;

public class DecimalToFraction {
    public static void main(String[] args) {
        // Prompt the user for a decimal number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimalStr = input.nextLine();
        
        // Check if the number is negative
        boolean isNegative = decimalStr.startsWith("-");
        
        // Remove the negative sign if present for easier processing
        if (isNegative) {
            decimalStr = decimalStr.substring(1);
        }
        
        // Split the number into integer and fractional parts
        String[] parts = decimalStr.split("\\.");
        
        long integerPart = Long.parseLong(parts[0]);
        long fractionalPart = Long.parseLong(parts[1]);
        int fractionLength = parts[1].length(); // Number of digits in the fractional part
        
        // The denominator will be 10^fractionLength
        long denominator = (long) Math.pow(10, fractionLength);
        long numerator = (integerPart * denominator) + fractionalPart;
        
        // If there is a negative sign, adjust the numerator accordingly
        if (isNegative) {
            numerator = -numerator;
        }
        
        // Create the Rational number
        Rational rational = new Rational(numerator, denominator);
        
        // Display the result
        System.out.println("The fraction number is " + rational);
    }
}