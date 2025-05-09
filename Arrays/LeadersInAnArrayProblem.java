import java.util.*;
class LeadersInAnArrayProblem {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> leaderList = new ArrayList<>();
        int max = Integer.MIN_VALUE; // Track the max element from the right
        int n = arr.length;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {  // If current element is >= max, it's a leader
                leaderList.add(arr[i]);
                max = arr[i];  // Update max
            }
        }

        // Reverse the list to maintain the correct order
        Collections.reverse(leaderList);
        
        return leaderList; // Return the list of leaders
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        
        // Input array elements
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Call the leaders function and get the result
        ArrayList<Integer> result = leaders(arr);
        
        // Print the result
        System.out.println("Leaders in the array: " + result);
        
        sc.close(); // Close the scanner
    }
}
