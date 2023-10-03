package CompaniesProblems;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// Question
// REVIEW THIS QUESTION
/*
*
* We are given two strings a and b ; you are allowed to do operations on string a.

-> Output yes if string a can be converted to string b
-> Output No if string a cannot be converted to string b

-> Before doing any operation; you have to fix the k ; k>=2.

Operations:-> You can swap any a[i],a[i+1] for  0<=i<=n-2

*
* */

public class atlassianStrings {

    private static boolean check(Map<Character, Integer> v1, Map<Character, Integer> v5, int k) {
        char c = 'a';

        while (c <= 'z') {
            int g1 = v1.getOrDefault(c, 0);
            int g5 = v5.getOrDefault(c, 0);

            if (g1 >= g5) {
                int v = (g1 - g5);
                if (v == 0 || v % k == 0) {
                    char u = (char) (c + 1);
                    v1.put(u, v1.getOrDefault(u, 0) + v);
                } else {
                    return false;
                }
            } else {
                return false;
            }
            c++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            Map<Character, Integer> v1 = new HashMap<>();
            Map<Character, Integer> v5 = new HashMap<>();

            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                v1.put(ch, v1.getOrDefault(ch, 0) + 1);
            }

            for (int i = 0; i < b.length(); i++) {
                char ch = b.charAt(i);
                v5.put(ch, v5.getOrDefault(ch, 0) + 1);
            }

            int v = Math.min(a.length(), b.length());
            int count = 0;
            int k = 0;

            for (int i = 2; i <= v; i++) {
                k = i;
                if (check(v1, v5, k)) {
                    count = 1;
                    break;
                }
            }

            if (count == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
