/*Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].

Return an array of integers denoting the [floor, ceil]. Return -1 for floor or ceiling if the floor or ceiling is not present.

Examples:

Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
Output: 6, 8
Explanation: Floor of 7 is 6 and ceil of 7 is 8.*/

import java.util.*;
public class CeilTheFloor {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = -1;

        for (int num : arr) { 
            if (num <= x) {
                floor = Math.max(floor, num);
            }
            if (num >= x) {
                if (ceil == -1) {
                    ceil = num;  // First valid ceil found
                } else {
                    ceil = Math.min(ceil, num); // Keeping the smallest ceil
                }
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        CeilTheFloor solution = new CeilTheFloor();
        
        // Test cases
        int[] arr1 = {1, 2, 8, 10, 10, 12, 19};
        int x1 = 5;
        System.out.println("Floor and Ceil of " + x1 + ": " + Arrays.toString(solution.getFloorAndCeil(x1, arr1))); // Output: [2, 8]

        int[] arr2 = {1, 2, 8, 10, 10, 12, 19};
        int x2 = 20;
        System.out.println("Floor and Ceil of " + x2 + ": " + Arrays.toString(solution.getFloorAndCeil(x2, arr2))); // Output: [19, -1]

        int[] arr3 = {1, 2, 8, 10, 10, 12, 19};
        int x3 = 0;
        System.out.println("Floor and Ceil of " + x3 + ": " + Arrays.toString(solution.getFloorAndCeil(x3, arr3))); // Output: [-1, 1]
    }
}
