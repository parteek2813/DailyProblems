package codeforces904;

import java.util.Scanner;
import java.util.TreeSet;

public class HauntedHouseB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();


            TreeSet<Integer> st = new TreeSet<>();

            for(int i =0; i<n; i++){
                if(s.charAt(i) == '0'){
                    st.add(i);
                }
            }


            int val =0;
            for(int i=n-1; i >= 0; i--){
                if(st.isEmpty()){
                    System.out.println("-1");
                    continue;
                }


                int it = st.last();
                val += (i-it);
                st.remove(it);

                System.out.println(val + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
