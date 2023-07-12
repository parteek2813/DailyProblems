package AdvStack;

public class largestRectArea {
    static int getMin(int[] arr, int s , int e ){
        int min = arr[s];
        for(int i = s+1; i<= e; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    static int bruteArea(int[] arr){
        int n = arr.length;
        int maxArea =0;
        for(int i =0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int width = j-i +1;
                int height = getMin(arr,i,j);
                int area = width * height;
                if(area>maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {1,6,4,12,3,8};
        int res = bruteArea(arr);
        System.out.println(res);
    }
}
