package AdvDp;

// given the food items with their protein contents and protein/kg
// FRACTIONAL KNAPSACK!
// We have to pick max W kg of food item (W=70kg)
// Pick in multiple of 1kG
// Pick items to opt for Max-Protein


import java.util.Arrays;

// SOLUTION:
// 1) sort acc to Protein/kg
// 2) Pick items until to fill 70kg
public class proteinPerKg {
    static class FoodItem implements Comparable<FoodItem> {
        int quantity;
        int protein;

        public FoodItem(int quantity, int protein) {
            this.quantity = quantity;
            this.protein = protein;
        }

        @Override
        public int compareTo(FoodItem other) {
            // Sort in descending order of protein/kg
            return Double.compare((double) other.protein / other.quantity, (double) this.protein / this.quantity);
        }
    }

    static int maxProtein() {
        int[] quan = {20, 15, 50, 10, 25, 12, 5};
        int[] protein = {200, 180, 250, 150, 200, 132, 100};
        int W = 70; // Max weight in kg

        int n = quan.length;
        FoodItem[] foodItems = new FoodItem[n];

        for (int i = 0; i < n; i++) {
            foodItems[i] = new FoodItem(quan[i], protein[i]);
        }

        // Sort the food items array in descending order of protein/kg
        Arrays.sort(foodItems);

        int maxProtein = 0;
        int weightSoFar = 0;
        int idx = 0;

        // Pick items until the knapsack is filled
        while (weightSoFar < W && idx < n) {
            if (weightSoFar + foodItems[idx].quantity <= W) {
                // If the whole item can be picked, pick it
                weightSoFar += foodItems[idx].quantity;
                maxProtein += foodItems[idx].protein;
            } else {
                // Pick a fraction of the item to fill the remaining capacity of the knapsack
                int remainingWeight = W - weightSoFar;
                maxProtein += (int) (((double) remainingWeight / foodItems[idx].quantity) * foodItems[idx].protein);
                weightSoFar = W;
            }
            idx++;
        }

        return maxProtein;
    }

    public static void main(String[] args) {
        int res = maxProtein();
        System.out.println("Maximum protein that can be obtained: " + res);
    }
}
