/* You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is
impossible to make m bouquets return -1.

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
Example 3:

Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways. */

import java.util.*;
public class Bouquets{
    // Function to check if it's possible to make 'm' bouquets in 'day' days
    public static boolean Possible(int[] nums, int day, int m, int k)
    {
        int n = nums.length;
        int count = 0; // Count of consecutive bloomed flowers.
        int NoOfBouquets = 0; // Number of Bouquets formed.

        // Iterate through the blooming days array.
        for(int i=0; i<n; i++)
        {
            if(nums[i] <= day){
                // If the flower blooms within 'day' days, increase count
                count++;
            }else{
                // If not, check how many bouquets can be formed
                NoOfBouquets += (count/k);
                count = 0;  // Resetting count for the next sequence.
            }
        }
        NoOfBouquets += (count/k); // Final check after loop.
        return NoOfBouquets >= m; // Check if required bouquets are formed.

    }
    // Function to find the minimum number of days required
    public static int minDays(int[] nums, int m, int k)
    {
        long value = (long) m*k; // Total flowers required.
        int n = nums.length;

        if(value > n) return -1; // Impossible Case: Not enough flowers available.
        // Find the minimum and maximum blooming days
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
        }
        // Apply Binary Search to find minimum no. of days
        int low = mini, high = maxi;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(Possible(nums, mid, m, k))
            {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low; // Minimum no. of days required.
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input number of flowers
        System.out.print("Enter number of flowers: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input blooming days
        System.out.println("Enter blooming days of flowers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input m and k
        System.out.print("Enter number of bouquets (m): ");
        int m = sc.nextInt();
        System.out.print("Enter flowers per bouquet (k): ");
        int k = sc.nextInt();

        // Compute and print the result
        int result = minDays(nums, m, k);
        System.out.println("Minimum number of days required: " + result);
    }
}
// wite the python program to solve four queen problem using hill climbing algorithm
// write a recurrsive program that counts the number of times a string occurs in another string