package codeForces901Div3;

import java.util.Scanner;

public class IvaAndPavE {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];

            int[][] prefix = new int[n+1][32];

            // store initially
            for(int i =0; i<32; i++){
                prefix[0][i] = 0;
            }

            for(int i =1; i<=n; i++){
                arr[i] = sc.nextInt();

                for(int j=0; j<32; j++){


                    if(((1<<j)&arr[i]) != 0){
                        prefix[i][j] = 1;
                    }else{
                        prefix[i][j]=0;
                    }

                    prefix[i][j]+= prefix[i-1][j];
                }
            }

            int q = sc.nextInt();
            while (q-- > 0){
                int L = sc.nextInt();
                int k = sc.nextInt();



                int l = L;
                int r = n;
                int ans = -1;

                while (r >= l){
                    int mid = (r+l)/2;

                    int val = 0;

                    for(int i=0; i<32; i++){
                        if(prefix[mid][i] - prefix[L-1][i] == (mid - L + 1)){
                            val+=(1<<i);
                        }
                    }

                    if(val >= k){
                        ans = mid;
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }
                System.out.println(ans + " ");
            }
        }


    }
}
