package AdvRecursion;

import java.util.HashSet;
import java.util.Vector;


// Question

// Given a array of numbers , we have to find the unqiue prime factor of the products
// of the array element and return the count of unique number
public class uniquePrimeFactor {

    static int CountPrime(Vector<Integer> a){
        HashSet<Integer> hm = new HashSet<>();

        for (int i =0; i< a.size(); i++){
            int sq = (int)Math.sqrt(a.get(i));


            // From 2 to sq root of number , run a loop

            for(int j=2; j<= sq; j++){
                if(a.get(i) % j == 0){
                    // if j = one of factor, store it in hm
                    hm.add(j);

                    while (a.get(i) % j == 0){
                        a.set(i, a.get(i)/j);
                    }
                }
            }

            if(a.get(i) > 1){
                hm.add(a.get(i));
            }
        }

        // number of unqiue factors = size of set [ONLY UNIQUE]
        return hm.size();
    }
    public static void main(String[] args) {
        Vector<Integer> a = new Vector<>();
        a.add(2);
        a.add(4);
        a.add(3);
        a.add(7);
        a.add(10);
        a.add(6);
        System.out.println(CountPrime(a));
    }
}
