package EducationalCF156;
import java.util.*;

// Summary

/*

Sabse pehle hume n , n-1 , n-2 .... lengths ki string di hogi
Ab hume kuch pos di hogi .... to aur uss pos pe element ko print karna hein
To uss pos ke paas pahuchne ke liye sabse pehle mai consecutive string ko neglect karta
rahunga and then ek string bachege jisme mere pos < str.length true hoga

 Ab mujhe pata hein mera pos element isse string me hein to usko nikalne ke liye
 let's say mai consider karta hu ek kuch part string ka sorted hoga and then unsorted
 so sorted part ka last element compare karunga unosrted ke first say and agar sorted[last] > unsorted[first]
 to mai sorted[last] ko nikaulnga and then at last pos de deunga

 */

public class decreasingStringC {

    static String s;
    static String str = "";
    static ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(1000005, true));
    static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            int pos = scanner.nextInt();
            int n = s.length();
            int l = 0, r = n;
            int rem = 0;
            int sm1 = 0;

            while (r >= l) {
                int mid = (r + l) / 2;
                long sm = (long) mid * (long) (2 * n - mid + 1) / 2;

                if (sm < pos) {
                    rem = mid;
                    sm1 = (int) sm;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            for (int i = 0; i < n; i++) {
                visited.set(i, true);
            }

            int ch = (n - rem);
            int i = 0, j = 1;
            boolean check = false;
            pos -= sm1;
            j = 0;

            while (rem-- > 0) {
                while (j < n) {
                    if (str.length() == 0) {
                        str += s.charAt(j);
                        j++;
                        continue;
                    }

                    if (str.charAt(str.length() - 1) <= s.charAt(j)) {
                        str += s.charAt(j);
                        j++;
                        continue;
                    } else {
                        break;
                    }
                }
                str = str.substring(0, str.length() - 1);
            }

            while (j < n) {
                str += s.charAt(j);
                j++;
            }

            System.out.print(str.charAt(pos - 1));
        }
        scanner.close();
    }
}





