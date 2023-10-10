package EducationalCF156;

import java.util.Scanner;

public class sumOfThreeA {

    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        if(n<7){
            System.out.println("NO");
        }


        int z = n-3;
        int x = 1;
        int y =2;

        // condition applied when it divided by 3 else done!
        if(z%3 == 0){
            z -=2;
            y +=2;
        }

        if(z>y){
            System.out.println("YES");
            System.out.println(x + " " + y + " " + z);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            solve();
        }
    }
}
