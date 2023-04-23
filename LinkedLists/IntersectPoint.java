package LinkedLists;

public class IntersectPoint {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next.next;

        System.out.println(intersectPoint(n1,n2));
    }


    static int intersectPoint(Node head1, Node head2)
	{
         // code here
        if(head1==null || head2==null) return -1;
       
           Node a = head1;
           Node b = head2;
           while(a!=b){
               a = a==null?head2:a.next;
               b = b==null?head1:b.next;
              if(a==null && b==null) return -1;
               
           }
           
           return a.data;
	}
}
