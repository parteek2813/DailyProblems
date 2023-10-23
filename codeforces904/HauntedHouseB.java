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


                // start iterating from the last and then add into the value
                // the main point is that we have to find the difference between the itertor and if the
                // st set is empty , then just print -1 and continue until the loop stops.

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
