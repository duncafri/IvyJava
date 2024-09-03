/* 
 Author: Ricky Duncan
SDEV140-11
06/21/2024
Assignment: Module 2 Programming Assignment 3
*/

// Define the BinaryFormatException class
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

// Implement the bin2Dec method
public class Exercise12_09 {

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the string is a valid binary string
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException("Not a binary number: " + binaryString);
            }
        }

        // Convert binary string to decimal
        int decimalValue = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(i);
            decimalValue = decimalValue * 2 + (bit - '0');
        }
        return decimalValue;
    }

    // Test program
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        // Prompt the user to enter a binary number
        System.out.print("Enter a binary number: ");
        String binaryString = input.nextLine();

        try {
            // Convert binary string to decimal and display result
            int decimalValue = bin2Dec(binaryString);
            System.out.println("The decimal value of " + binaryString + " is " + decimalValue);
        } catch (BinaryFormatException ex) {
            // Display error message if input is not a binary string
            System.out.println(ex.getMessage());
        }
    }
}