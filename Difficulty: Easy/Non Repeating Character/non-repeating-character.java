//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        int[] ind = new int[26];
        Arrays.fill(ind, Integer.MAX_VALUE);
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(ind[index] == Integer.MAX_VALUE) {
                ind[index] = i; 
            } else {
                ind[index] = Integer.MAX_VALUE - 1;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            min = Math.min(min, ind[i]);
        }
        
        return (min >= Integer.MAX_VALUE - 1) ? '$' : s.charAt(min);
    }
}