package codeForces901Div3;

import java.util.Scanner;

public class daytanaCostA {

    public static String findIfExist(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean check = false;
        int[] arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();


            if(k == arr[i]){
                check = true;
            }
        }

        if(!check){
            return "NO";
        }else{
            return "YES";
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            String result = findIfExist();
            System.out.println(result);
        }
    }
}
