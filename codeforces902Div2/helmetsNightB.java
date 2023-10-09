package codeforces902Div2;

import java.util.*;

// The question is that One person h that has announcement jo sbko pahuchani hein
// he can share directly with cost of p or can shared by people who he shared with diff cost.
// We have to minimize the cost and also it is mentioned that each person can share with
// Limited number of people.


class Pair {
    int first;
    int second;

    public Pair(int first , int second){
        this.first =first;
        this.second =second;
    }
}
public class helmetsNightB {


    public static void solveforHelmets(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dc = sc.nextInt();

        // Initial array input
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        List<Integer> b = new ArrayList<>();
        List<Pair> v = new ArrayList<>();

        for(int i =0; i<n; i++){
            b.add(sc.nextInt());;
            v.add(new Pair(Math.min(b.get(i), dc), a.get(i)));
        }


        Collections.sort(v, Comparator.comparingInt(o -> o.first));
        int ans = dc; // min cost .... first wale ki add to krdo pehle
        int csu = n - 1; //  left over after including 1 from n
        for (int i = 0; i < n - 1; i++) {
            ans += Math.min(v.get(i).second, csu) * v.get(i).first;
            csu -= Math.min(csu, v.get(i).second);
        }

        System.out.println(ans);


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            solveforHelmets();

        }
    }


}
