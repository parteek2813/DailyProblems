package codeForces906;

import java.util.*;

/*
The main logic of this question is that we have to add the elements in the ans array
in such a way that ans array includes all the larger element than arr1 in front and
all element lesser than arr1 elements comes at last.... in this way we maintain the l
length of longest increasing subsequence as it is of arr1 array.


For this we uses the TreeSet in java which stores the elements in ascending order naturally
and then we traverse back from last of treeset and compare it with the first element of this
array and if condition satisfies and then we add that element in the array c
 */

public class neutralTonalityD {

    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] arr1 = new int[x];
            Integer[] arr2 = new Integer[y];
            ArrayList<Integer> c = new ArrayList<>();
            TreeSet<Integer> ts = new TreeSet<>();



            for(int i =0; i<x; i++){
                arr1[i] = sc.nextInt();
            }

            for(int i =0; i<y; i++){
                arr2[i] = sc.nextInt();
                ts.add(arr2[i]);
            }

//        Arrays.sort(arr2, Collections.reverseOrder());


            int i=0;
            for( i =0; i<x; i++){
                while (!ts.isEmpty()){
                    int it = ts.last();
                    if(it < arr1[i]) break;
                    c.add(it);
                    ts.remove(it);
                }
                c.add(arr1[i]);
            }

//        for(int i =0; i<x; i++){
//            while (i<y && arr2[i] >= arr1[i]){
//                c.add(arr2[i]);
//                i++;
//            }
//            c.add(arr1[i]);
//        }

            while (!ts.isEmpty()){
                int it = ts.last();
                c.add(it);
                ts.remove(it);
            }

            for (int num : c) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

            solve();

    }
}
