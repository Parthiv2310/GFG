//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        // Arrays to store previous and next smaller elements
        int[] left = new int[n];  // Previous smaller
        int[] right = new int[n]; // Next smaller

        Stack<Integer> stack = new Stack<>();

        // Finding previous smaller element for each index
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for the next computation
        stack.clear();

        // Finding next smaller element for each index
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Auxiliary array to store max of min for each window size
        int[] maxMins = new int[n + 1];
        Arrays.fill(maxMins, Integer.MIN_VALUE);

        // Compute the window size where arr[i] is the minimum
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            maxMins[windowSize] = Math.max(maxMins[windowSize], arr[i]);
        }

        // Fill missing values by propagating maximum values
        for (int i = n - 1; i >= 1; i--) {
            maxMins[i] = Math.max(maxMins[i], maxMins[i + 1]);
        }

        // Populate result array
        for (int i = 1; i <= n; i++) {
            result.set(i - 1, maxMins[i]);
        }

        return result;
    }
}
