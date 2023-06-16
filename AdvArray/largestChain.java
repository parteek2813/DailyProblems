package AdvArray;


//Question :
//Given a list of N numbers which is unordered , find out the longest chain consecutive elements
// we can build
//
// For ex - Numbers given ===> 21,3,5,7,4 ,  1,2    9,10,12,11,13,20
// Chain 1 - 1->2->3->4->5->6->7
// Chain 2 - 9->10->11->12->13
// Chain 3 - 20->21



import java.util.HashSet;

public class largestChain {

    static int LargestNum(int[] arr){
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0; i<arr.length; i++){
            hs.add(arr[i]);
        }

        int len =0;
        int largest =0;

        for(int i =0; i<arr.length; i++){
            if(hs.contains(arr[i]-1) == false){
                len=1;
                int no = i+1;
                while (hs.contains(no)==true){
                    len++;
                    no=no+1;

                }


            }
            largest = Math.max(largest, len);
        }
        return largest;
    }

    public static void main(String[] args) {

        int[] arr = {21,3,5,6,7,4,1,2,9,10,12,11,13,20};
        int res =  LargestNum(arr);
        System.out.println(res);

    }
}
