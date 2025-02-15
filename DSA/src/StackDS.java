import java.util.Scanner;

public class StackDS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial capacity of stack : ");
        int size = sc.nextInt();
        int[] stack = new int[size];
        int top = -1;

        while (true) {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Traverse");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                if (top == size - 1) {
                    size *= 2;
                    int[] arr = new int[size];
                    for (int i = 0; i <= top; i++) {
                        arr[i] = stack[i];
                    }
                    stack = arr;
                }
                System.out.println("Enter the element: ");
                int ele = sc.nextInt();
                top++;
                stack[top] = ele;
                System.out.println("Element pushed.");
            } 
            else if (ch == 2) {
                if (top == -1) {
                    System.out.println("Stack is Underflow.");
                } else {
                    System.out.println("Popped : " + stack[top]);
                    top--;
                }
            } 
            else if (ch == 3) {
                if (top == -1) {
                    System.out.println("Stack is empty.");
                } else {
                    System.out.println("Element at the top : " + stack[top]);
                }
            } 
            else if (ch == 4) {
                System.out.println("Traverse : ");
                for (int i = top; i >= 0; i--) {
                    System.out.println(stack[i]);
                }
            } 
            else if (ch == 5) {
                System.out.println("End of the Program");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}