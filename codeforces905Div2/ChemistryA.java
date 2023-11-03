package codeforces905Div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChemistryA {

    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- >= 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();

            Map<Character, Integer> hs = new HashMap<>();

            for(char ch: s.toCharArray()){
                hs.put(ch, hs.getOrDefault(ch, 0) + 1);
            }

            long even = 0, odd = 0;
            for(long el: hs.values()){
                even += (el %2 ==0) ? 1:0;
                odd += (el%2 != 0) ? 1:0;
            }

            if(k < odd-1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }

    }
    public static void main(String[] args) {
            solve();
    }
}
