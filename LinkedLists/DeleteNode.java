package LinkedLists;
import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d)
    {
        data = d;
        next = null;
    }
    public String toString()
    {
        String s = Integer.toString(data) + " ";
        Node t = next;
        while(t!=null)
        {
            s+= Integer.toString(t.data) + " ";
            t=t.next;
        }
        return s;
    }
}
public class DeleteNode {
    public static void main(String[] args)
    {
        System.out.println("Jai shree Ram");
        Node head = new Node(1);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(9);

        Solution sol = new Solution();
        Node t = sol.deleteNode(head, 2);// delete 2nd element in the list.
        System.out.println(t);
    }
}
class Solution
{
    Node deleteNode(Node head, int x)
    {
        if(head==null)
            return null;
        if(x==1)
            return head.next;
        
        head.next=deleteNode(head.next,x-1);
        
        return head;
    }
}
