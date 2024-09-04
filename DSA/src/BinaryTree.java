import java.util.Scanner;

public class BinaryTree {
    static Node root = null;
    public static void main(String[] args) {
        System.out.println("enter element to insert : ");
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();
        insert(ele);
        System.out.println("inserted");
    }
    static void insert(int ele){
        Node newNode = new Node(ele);
        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = null;
        Node current = root;
        while (current != null) {
            parent = current;
            if (ele > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (ele < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}