//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
         ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                negative.add(arr.get(i));
            } else {
                positive.add(arr.get(i));
            }
        }
        
        arr.clear();
        int p = 0;
        int q = 0;
        
        while (p < positive.size() && q < negative.size()) {
            arr.add(positive.get(p++));
            arr.add(negative.get(q++));
        }
        
        while (p < positive.size()) {
            arr.add(positive.get(p++));
        }
        
        while (q < negative.size()) {
            arr.add(negative.get(q++));
        }
        
    }
}