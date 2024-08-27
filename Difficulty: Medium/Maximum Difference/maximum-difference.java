//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
         int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find the nearest left smaller element for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        stack.clear();

        // Find the nearest right smaller element for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftSmaller[i] - rightSmaller[i]));
        }

        return maxDiff;
        
    }
}