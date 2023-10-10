package EducationalCF156;
import java.util.*;


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





