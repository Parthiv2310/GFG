//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
         int l = 0, r = arr.length - 1, maz = 0;

    while (l < r) {
        int h = Math.min(arr[l], arr[r]);
        int w = r - l;
        int ca = h * w;

        maz = Math.max(maz, ca);

        if (arr[l] <= arr[r]) {
            l++;
        } else {
            r--;
        }
    }

    return maz;
    }
}