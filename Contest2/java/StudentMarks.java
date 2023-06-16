//package Contest2.java;
//
//
////Question
//// you are given an array of strings A representing Students name & score in combined form. For Eg."harsh95" represents
//// harsh has 95 marks. You have to return another array of strings containing  name & score sorted on basis of their marks (highest to lowest)
//// If 2 students have same marks, keep the first one from input array in first position. [Note-Marks don't exceed 100]
//
//
//import java.util.Arrays;
//
//public class StudentMarks {
//
//    static String[] StuMarks(String[] arr){
//        String[] res = new String[]{};
//        int n= arr.length;
//        int newarr =
//
//        int[] visited = new int[n];
//        Arrays.fill(visited,0);
//
//        for (int i =0; i<n; i++){
//            for (i=0; i<n; i++){
//                int max =-1;
//                int ind =-1;
//
//                if(visited[i] ==1){
//                    continue;
//
//                    for(int j=0; j<arr[i].length(); j++){
//                        if(arr[i][j] >= '0' && arr[i][j] <= '9'){
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        String[] arr = new String[]{"harsh90", "Soham100", "emma95", "john95"};
//        String[] res = StuMarks(arr);
//        System.out.println(res); //return resultant String
//    }
//}
