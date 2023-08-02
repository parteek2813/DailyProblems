package AdvBacktracking;

public class permuteChar {


    public static void permute(char[] arr, int i){
        // base case
        if(i== arr.length-1){
            System.out.println(arr);
            return;
        }

        // rec case
        for(int j =i; j<arr.length ; j++){
           char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            permute(arr, i+1);
            // swap again
            // Important step to swap back again for backtracking
             temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
    public static void main(String[] args) {
        char[] arr = {'A','B','C'};
        permute(arr, 0);


    }
}
