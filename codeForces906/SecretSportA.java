package codeForces906;

import java.util.Scanner;

public class SecretSportA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // Number of plays
            String plays = scanner.next(); // Sequence of plays

            // Check the last character of the string
            char lastCharacter = plays.charAt(n - 1);

            // Determine the winner based on the last character
            if (lastCharacter == 'A') {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }
}
