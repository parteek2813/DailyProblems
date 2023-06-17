package AdvBitManipulation;

// Question

// GIven an array of positive integers , calculate the number of pairs(i,j) such that
// (arr[i] + arr[j] ) %M = 0 and given that i != j

import java.util.HashMap;

// Bruteforce - Two loops- Time->O(n2) and Space-> O(1);
public class modulo1 {

    static int CalPairsWithHashmap(int[] arr, int m ){

        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int ans=0;


        //store the freq of numbers % m in hashmap
        for(int i =0; i<n; i++){
            int rem = arr[i] %m;
            hm.put(rem, hm.getOrDefault(rem,0)+1);
        }


        // store the first frequency
        int f=0;
        int fr = hm.getOrDefault(f,0);



        for(int j=0; j<(m+1)/2; j++){
            if(j==0 || j == m-j){
                ans += (hm.getOrDefault(j, 0) * (hm.getOrDefault(j, 0) - 2)) / 2;
            }else{
                ans = ans + hm.getOrDefault(j,0) + hm.getOrDefault(m-j,0);
            }
        }


        return ans;
    }

    static int CalPairs(int[] arr , int m){

        int n = arr.length;
        int count =0;

        for(int i=0; i<n ; i++){
            for(int j=i+1; j<n; j++){
                if((arr[i] + arr[j]) % m == 0){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

//        int[] arr = {4,7,6,5,8,3};
//        int m =3;

//        int res = CalPairs(arr,m);
//        System.out.println(res);

        int[] arr = {4,7,6,5,8,3,10,15,25,45,85};
        int m =5;


        int res = CalPairsWithHashmap(arr,m);
        System.out.println(res);
    }
}
