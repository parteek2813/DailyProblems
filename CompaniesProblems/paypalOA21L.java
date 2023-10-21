package CompaniesProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class paypalOA21L {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();


        List<Long> b = new ArrayList<>();
        long ans = 0;


        for(long i=1; i<=n; i++){
            long y = sc.nextLong();

            if(y%2 == 0){
                if(y>=0){
                    ans +=y;
                }else{
                    b.add(y); // it means num is even but negative
                }
            }
        }


        Collections.sort(b);
        int g = b.size();
        long answer = ans;
        int i = g-1;

        while (i >= 0){
            if(i-1 >= 0){
                ans = ans + b.get(i) + b.get(i-1);
                answer = Math.max(answer,ans);
            }

            i=i-2; // decrement in pairs
        }
        System.out.println(answer);
    }
}
