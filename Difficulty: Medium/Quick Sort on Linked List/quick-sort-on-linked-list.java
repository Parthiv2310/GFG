//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    public static Node quickSort(Node node) {
        // Your code here
        Node tail = getTail(node);
        
        // Call the helper function to sort the list
        quickSortHelper(node, tail);
        return node;
    }
    static void quickSortHelper(Node head, Node tail) {
      
        // Base case: if the list is empty or consists of a single node
        if (head == null || head == tail) {
            return;
        }
        
        // Call partition to find the pivot node
        Node pivot = partition(head, tail);
        
        // Recursive call for the left part of 
          // the list (before the pivot)
        quickSortHelper(head, pivot);
        
        // Recursive call for the right part of 
          // the list (after the pivot)
        quickSortHelper(pivot.next, tail);
    }
    
    static Node partition(Node head, Node tail) {
        
        // Select the first node as the pivot node
        Node pivot = head;
        
        // 'pre' and 'curr' are used to shift all 
        // smaller nodes' data to the left side of the pivot node
        Node pre = head;
        Node curr = head;

        // Traverse the list until you reach the node after the tail
        while (curr != tail.next) {
            
            // If current node's data is less than the pivot's data
            if (curr.data < pivot.data) {
                
                int temp = curr.data;
                curr.data = pre.next.data;
                pre.next.data = temp;
                
                // Move 'pre' to the next node
                pre = pre.next;
            }
            
            // Move 'curr' to the next node
            curr = curr.next;
        }
        
        // Swap the pivot's data with 'pre' data
        int currData = pivot.data;
        pivot.data = pre.data;
        pre.data = currData;
        
        // Return 'pre' as the new pivot
        return pre;
}
static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Returns the last node of the list
    static Node getTail(Node cur) {
        while (cur != null && cur.next != null)
            cur = cur.next;
        return cur;
    }
    
}