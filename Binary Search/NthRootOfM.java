/* You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.
Examples :

Input: n = 2, m = 9
Output: 3
Explanation: 3 square 2 = 9

Input: n = 3, m = 9
Output: -1

Explanation: 3rd root of 9 is not integer.
Input: n = 1, m = 14
Output: 14 */

import java.util.Scanner;

public class NthRootOfM {
    public int nthRoot(int n, int m){
        int low = 1, high = m;
        while(low <=high)
        {
            int mid = (low + high) / 2;
            if(Math.pow(mid,n) == m) return mid;
            else if(Math.pow(mid,n) < m)
            {
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        NthRootOfM obj = new NthRootOfM();
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the value of 'n' ");
        int n = sc.nextInt();
        System.out.println("Enter the value of 'm' ");
        int m = sc.nextInt();
        System.out.println("Your Answer is : "+obj.nthRoot(n, m));
    }
    
}
