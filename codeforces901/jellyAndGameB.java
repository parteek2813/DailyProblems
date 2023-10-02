package codeforces901;

import java.util.Arrays;
import java.util.Scanner;

public class jellyAndGameB {

    public static void findGame() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] jellyfish = new int[n];
            int[] gellyfish = new int[m];

            int sumJelly = 0;
            for (int i = 0; i < n; i++) {
                jellyfish[i] = sc.nextInt();
                sumJelly += jellyfish[i];
            }

            int sumGelly = 0;
            for (int i = 0; i < m; i++) {
                gellyfish[i] = sc.nextInt();
                sumGelly += gellyfish[i];
            }

            Arrays.sort(jellyfish);
            Arrays.sort(gellyfish);

            int maxGellyIndex = m - 1;
            int minJellyIndex = 0;

            for (int i = 0; i < k; i++) {
                if (minJellyIndex < n && maxGellyIndex >= 0 && jellyfish[minJellyIndex] < gellyfish[maxGellyIndex]) {
                    sumJelly = sumJelly - jellyfish[minJellyIndex] + gellyfish[maxGellyIndex];
                    minJellyIndex++;
                    maxGellyIndex--;
                } else {
                    break;
                }
            }

            System.out.println(sumJelly);
        }
    }

    public static void main(String[] args) {
        findGame();
    }
}
