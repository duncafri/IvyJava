/* 
 Author: Ricky Duncan
SDEV200-11
09/13/2024
Assignment: Module 4 Programming Assignment (2)
*/

import java.util.*;
import java.io.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords <source-file>");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("The number of keywords in " + args[0] + " is " + countKeywords(file));
        } else {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", 
            "char", "class", "const", "continue", "default", "do", "double", 
            "else", "enum", "extends", "for", "final", "finally", "float", "goto", 
            "if", "implements", "import", "instanceof", "int", "interface", 
            "long", "native", "new", "package", "private", "protected", "public", 
            "return", "short", "static", "strictfp", "super", "switch", 
            "synchronized", "this", "throw", "throws", "transient", "try", 
            "void", "volatile", "while", "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        // Read the file line by line
        try (Scanner input = new Scanner(file)) {
            boolean inBlockComment = false; // Tracks if we are in a block comment
            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = line.trim(); // Remove leading and trailing whitespace

                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // Handle block comments
                if (inBlockComment) {
                    int endComment = line.indexOf("*/");
                    if (endComment != -1) {
                        line = line.substring(endComment + 2);
                        inBlockComment = false;
                    } else {
                        continue; // Still in block comment, skip the line
                    }
                }

                // Handle line comments (//)
                int lineCommentIndex = line.indexOf("//");
                if (lineCommentIndex != -1) {
                    line = line.substring(0, lineCommentIndex);
                }

                // Handle block comments (/* ... */)
                int blockCommentStart = line.indexOf("/*");
                while (blockCommentStart != -1) {
                    int blockCommentEnd = line.indexOf("*/", blockCommentStart + 2);
                    if (blockCommentEnd != -1) {
                        line = line.substring(0, blockCommentStart) + line.substring(blockCommentEnd + 2);
                        blockCommentStart = line.indexOf("/*");
                    } else {
                        line = line.substring(0, blockCommentStart);
                        inBlockComment = true;
                        break;
                    }
                }

                // Handle strings (ignore anything inside double quotes)
                StringBuilder cleanLine = new StringBuilder();
                boolean inString = false;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == '"') {
                        inString = !inString;
                    } else if (!inString) {
                        cleanLine.append(ch);
                    }
                }

                // Count keywords in the cleaned line (no comments or strings)
                String[] words = cleanLine.toString().split("\\s+");
                for (String word : words) {
                    if (keywordSet.contains(word)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}