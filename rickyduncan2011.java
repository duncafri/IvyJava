/* 
 Author: Ricky Duncan
SDEV200-11
09/13/2024
Assignment: Module 4 Programming Assignment (1)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class MatchGroupingSymbols {
    public static void main(String[] args) {
        // check if file name is provided
        if (args.length != 1) {
            System.out.println("Usage: java MatchGroupingSymbols <source-code file>");
            System.exit(1);
        }

        // create a stack to track opening symbols
        Stack<Character> stack = new Stack<>();

        // attempt to open the file
        try (Scanner input = new Scanner(new File(args[0]))) {
            int lineNumber = 0; // Track the line number for error reporting
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                lineNumber++;

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // push opening symbols onto the stack
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    }

                    // for closing symbols, check the top of the stack
                    else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Error: Unmatched closing symbol '" + ch + "' at line " + lineNumber);
                            System.exit(1);
                        }
                        
                        char top = stack.pop();
                        if (!isMatchingPair(top, ch)) {
                            System.out.println("Error: Mismatched symbols '" + top + "' and '" + ch + "' at line " + lineNumber);
                            System.exit(1);
                        }
                    }
                }
            }

            // If the stack is not empty, we have unmatched opening symbols
            if (!stack.isEmpty()) {
                System.out.println("Error: Unmatched opening symbols at the end of the file.");
            } else {
                System.out.println("The file has correct grouping symbols.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        }
    }

    //method to check if two symbols are matching pairs
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}