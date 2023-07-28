package AdvTries;

public class findXor {
    public static void main(String[] args) {
        int[] num = {3,10,5,25,4,2};

        int n = num.length;
        for (int i=0; i<n; i++){
            for(int j =i; j<n ; j++){
                System.out.println( num[i] ^ num[j]);
            }
        }
    }
}
