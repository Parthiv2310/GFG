//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
         left[0] = arr[0];
         
         for(int i=1; i<n; i++)
         {
            left[i] = arr[i] * left[i-1];
         }
         
        int pro = arr[n-1];
        arr[n-1] = left[n-2];
        
        for(int i=n-2; i>0; i--)
        {
            int temp = arr[i];
            arr[i] = left[i-1] * pro;
            pro *= temp;
        }
        
        arr[0] = pro;
        
        return arr;
    }
}