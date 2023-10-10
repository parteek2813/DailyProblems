package EducationalCF156;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;

public class fearOfDarkB {

    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int px = sc.nextInt();
        int py = sc.nextInt();

        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();

        // Case when we consider a sinlge circle covers both the point P and O by
        // only one of the lanterns A or B

        int ap=(ax-px)*(ax-px) + (ay-py)*(ay-py);
        int bp=(bx-px)*(bx-px) + (by-py)*(by-py);
        int ao=(ax)*(ax) + (ay)*(ay);
        int bo=(bx)*(bx) + (by)*(by);


//      // storing ans from considering one circle as the Minimum of both max
        int ans = Math.min(Math.max(ap,ao), Math.max(bp,ao));

        int ab=(ax-bx)*(ax-bx) + (ay-by)*(ay-by);

        double an1 = ans;
        double an3 = ans;

        int val1 = Math.max(bp, ao);
        double dis1 = Math.sqrt(val1); // direct distance from one of them points taken one at a time


        double dis = (Math.sqrt(ab))/2.0; // distance between two lanterns but we have to take half because we need radius
        an1 = Math.max(dis,dis1);

        int val2 = Math.max(bo, ap);
        double dis3 = Math.sqrt(val2);
        an3 = Math.max(dis,dis3);


        // for getting the actual distance from first part we forget to take sq. root at that time
        double an2 = Math.sqrt(ans);


        an2 = Math.min(an2, an1);
        an2 = Math.min(an2, an3);

//      DecimalFormat df = new DecimalFormat("#.############"); // 12 decimal places
//      String formattedNumber = df.format(an2);
//      System.out.println(formattedNumber);


        Formatter fm = new Formatter();

        // to get the decimal places upto 10 after dot(.)
        fm.format("%.10f", an2);
        System.out.println(fm);
        fm.close();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            solve();
        }
    }
}
