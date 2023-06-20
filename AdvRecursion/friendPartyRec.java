package AdvRecursion;

// Question

// N friends are going for a party. Each friend can go solo or as a couple.
// Find out the total ways in which they can go

public class friendPartyRec {

    static int findWays(int total) {
        // base case
        if(total == 1){
            return 1;
        }
        if(total == 2){
            return 2;
        }

        // rec case

        int FinalWays = 1 * findWays(total - 1) + (total - 1) * (findWays(total - 2));
        return FinalWays;
    }
    public static void main(String[] args) {

        int total = 4;
        int res = findWays(total);
        System.out.println(res);
    }
}
