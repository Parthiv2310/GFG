//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        
        int startRows = 0;
        int startCols = 0;
        int endRows = matrix.length - 1;
        int endCols = matrix[0].length - 1;
        
        while (startRows <= endRows && startCols <= endCols) {

            for (int j = startCols; j <= endCols; j++) {
                result.add(matrix[startRows][j]);
            }
            startRows++;

            for (int i = startRows; i <= endRows; i++) {
                result.add(matrix[i][endCols]);
            }
            endCols--;

            if (startRows <= endRows) {
                for (int j = endCols; j >= startCols; j--) {
                    result.add(matrix[endRows][j]);
                }
                endRows--;
            }

            if (startCols <= endCols) {
                for (int i = endRows; i >= startRows; i--) {
                    result.add(matrix[i][startCols]);
                }
                startCols++;
            }
        }
        return result;
    }
}
