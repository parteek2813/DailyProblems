package AdvSorting;

//question

//You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
//There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker.
// The working time of a worker is the sum of the time it takes to complete all jobs assigned to them.
// Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
//Return the minimum possible maximum working time of any assignment.
public class workerTask {

    static boolean canDoTask(int[] jobs, int mid, int k){
        int n = jobs.length;
        int cnt =1;
        int currentTime = 0;
        for( int i =0; i<n; i++){
            if(currentTime + jobs[i] <= mid){
                currentTime += jobs[i];
            }else{
                currentTime = jobs[i];
                cnt++;
                if(cnt>k) return false;
            }
        }
        return true;
    }

    static int findMin(int[] jobs, int n , int k){
        int s =0;
        int e =0;
        for( int i =0; i<n ; i++){
            e += jobs[i];
        }

        int ans =0;
        while(s<=e){
            int mid = (s+e)/2;

            if(canDoTask(jobs, mid, k )){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] jobs = {1, 2, 4, 7, 8};
        int k =2;
        int n = jobs.length;
        int res = findMin(jobs, n, k);
        System.out.println(res);

    }
}
