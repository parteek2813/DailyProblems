package AdvRecursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Activity {
    int startTime;
    int endTime;

    Activity (int start, int end){
        this.startTime = start;
        this.endTime = end;
    }

    // put a method that returns a key for sorting
    int getEndTime (){
        return endTime;
    }

    void print(){
        System.out.println("Start " + startTime + " endT " + endTime );
    }
}
public class ActivityCount {
    public static void main(String[] args) {
        Scanner  sc= new Scanner(System.in);
        System.out.println("Enter number of activities");
        int n = sc.nextInt();

        //create an array of objects;
        Activity list[] = new Activity[n];


        // read the objects (each activity)
        for( int i =0; i<n; i++){
            int s , e;
            s = sc.nextInt();
            e = sc.nextInt();
            list[i] = new Activity(s, e);

        }

        // Algorithm (JAVA 8 and above) [KeyExtractor]
        Arrays.sort(list, Comparator.comparing(Activity::getEndTime));

//       for( int i=0; i<n ; i++){
//           list[i].print();
//       }

       // Count
        int cnt =1;
       int endTime = list[0].endTime;

       for( int i =1; i<= n-1; i++){

           if(list[i].startTime >= endTime) {
               list[i].print();
               cnt++;
               endTime = list[i].endTime;
           }
       }
        System.out.println("count is " + cnt);

    }
}
