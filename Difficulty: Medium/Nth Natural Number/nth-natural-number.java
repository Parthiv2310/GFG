//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long N) {
        long result = 0;
        long base = 1;

        // Convert N to base 9
        while (N > 0) {
            long digit = N % 9;
            N /= 9;

            // Replace 9 with 10
            if (digit == 9) {
                digit = 10;
            }

            result += digit * base;
            base *= 10;
        }

        return result;
    }
}