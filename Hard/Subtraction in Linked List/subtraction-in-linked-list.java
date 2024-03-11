//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
     static Node rev(Node head){
        Node curr=head,prev=null,nxt=null;
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static int len(Node head){
        int temp = 0;
        while(head!=null){
            temp++;
            head=head.next;
        }
        return temp;
    }
    static int help(Node head1,Node head2){
        if(head1==null && head2==null)return 0;
        if(head1.data>head2.data)return 1;
        if(head1.data<head2.data)return 2;
        return help(head1.next,head2.next);
    }
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        Node ans=new Node(0);
        while(head1!=null && head1.data==0)head1=head1.next;
        while(head2!=null && head2.data==0)head2=head2.next;
        if(head1==null && head2==null)return ans;
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node greater=head1,less=head2;
        int len1 = len(head1);
        int len2 = len(head2);
        if(len2>len1){
            greater=head2;
            less=head1;
        }
        else if(len2==len1){
            if(help(head1,head2)==2){
                greater=head2;
                less=head1;
            }
            else if(help(head1,head2)==0){
                return ans;
            }
        }
        Node temp=ans;
        greater = rev(greater);
        less = rev(less);
        while(less!=null){
            if(greater.data>=less.data){
                temp.next=new Node(greater.data-less.data);
            }
            else{
                temp.next=new Node(greater.data+10-less.data);
                Node nxt = greater.next;
                if(nxt.data!=0)nxt.data=nxt.data-1;
                else{
                    while(nxt.data==0){
                        nxt.data=9;
                        nxt=nxt.next;
                    }
                    nxt.data=nxt.data-1;
                }
            }
            greater=greater.next;
            less=less.next;
            temp=temp.next;
        }
        while(greater!=null){
            temp.next=new Node(greater.data);
            greater=greater.next;
            temp=temp.next;
        }
        ans=rev(ans.next);
        while(ans!=null && ans.data==0)ans=ans.next;
        return ans;
    }
}
        
