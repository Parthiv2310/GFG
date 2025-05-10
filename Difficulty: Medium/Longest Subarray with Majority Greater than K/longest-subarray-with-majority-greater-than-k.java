//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, greaterK = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) {
                greaterK++;
            } else {
                greaterK--;
            }

            if (greaterK > 0) {
                ans = i + 1;
            } else {
                map.putIfAbsent(greaterK, i);
                if (map.containsKey(greaterK - 1)) {
                    ans = Math.max(ans, i - map.get(greaterK - 1));
                }
            }
        }
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends