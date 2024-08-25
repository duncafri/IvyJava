import java.util.Scanner;

public class IdenticalArrays {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first 3x3 array
        System.out.print("Enter list1: ");
        int[][] list1 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list1[i][j] = input.nextInt();
            }
        }

        // Prompt the user to enter the second 3x3 array
        System.out.print("Enter list2: ");
        int[][] list2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list2[i][j] = input.nextInt();
            }
        }

        // Check if the two arrays are identical
        if (equals(list1, list2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    /** Returns true if m1 and m2 are identical */
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
