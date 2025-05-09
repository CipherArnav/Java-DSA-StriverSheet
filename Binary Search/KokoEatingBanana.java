/* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone 
and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats
k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23 */

import java.util.*;
public class KokoEatingBanana{
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMax(piles);

        while (low <= high) { 
            int mid = (low + high) / 2; 
            int totalHours = calculateHours(piles, mid);
            
            if (totalHours <= h) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        return low;
    }
    // Function to calculate total hours needed at speed k
    private int calculateHours(int[] piles, int k) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
           int pile = piles[i];  // Extract element at index i
           totalHours += (int)Math.ceil((double)pile/k);
        }
        return totalHours;
    }
    // Function to find the maximum pile size using a for loop
    private int getMax(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] piles = {3,5,7,11,14,19,22};
        KokoEatingBanana obj = new KokoEatingBanana();
        int h = 10;
        System.out.println("Minimum integer such that Koko can eat all the bananas within h hours is: "+obj.minEatingSpeed(piles,h));
    }  
}