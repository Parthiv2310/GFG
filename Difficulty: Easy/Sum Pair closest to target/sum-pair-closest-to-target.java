//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr.length < 2) return result; // Edge case: insufficient elements

        Arrays.sort(arr); // Sort the array
        
        int left = 0, right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int maxAbsDiff = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // Check if this pair is closer to the target
            if (Math.abs(sum - target) < Math.abs(closestSum - target) || 
                (Math.abs(sum - target) == Math.abs(closestSum - target) && (arr[right] - arr[left] > maxAbsDiff))) {
                closestSum = sum;
                result = Arrays.asList(arr[left], arr[right]);
                maxAbsDiff = arr[right] - arr[left];
            }

            // Adjust pointers based on sum
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}