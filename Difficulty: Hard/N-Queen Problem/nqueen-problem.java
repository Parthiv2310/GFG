//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> colPlacement = new ArrayList<>();
        solveNQueens(n, 0, colPlacement, result);
        return result;
    }

    static void solveNQueens(int n, int row, ArrayList<Integer> colPlacement, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int col = 1; col <= n; col++) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                    solveNQueens(n, row + 1, colPlacement, result);
                }
                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }

    static boolean isValid(ArrayList<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> solutions = nQueen(n);
        for (ArrayList<Integer> solution : solutions) {
            System.out.print("[");
            for (int col : solution) {
                System.out.print(col + " ");
            }
            System.out.print("] ");
        }
    }
}