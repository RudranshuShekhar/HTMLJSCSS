import java.util.Scanner;

class QueueDS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial capacity of stack : ");
        int size = sc.nextInt();
        int[] queue = new int[size];
        final int front =0;
        int rear = 0;

        while (true) {
            System.out.println("1. Inqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Traverse");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            if (ch == 1) 
            {
                if(rear==size)
                {
                	System.out.println("Queue is Overflow");
                }
                else
                {
                	System.out.println("Enter element to insert : ");
                	int ele =sc.nextInt();
                	queue[rear++]=ele;
                	System.out.println("Element inserted");
                }
            } 
            else if (ch == 2) {
                if(rear==0)
                {
                	System.out.println("Queue is Empty");
                }
                else
                {
                	System.out.println("Dequeue : "+queue[front]);
                	for(int i=0 ; i<=rear-2 ;i++) {
                		queue[i]=queue[i+1];
                	}
                	rear--;
                }
            } 
            else if (ch == 3) {
                if(rear==0)
                {
                	System.out.println("Queue is Empty");
                }
                else
                {
                	System.out.println("peek :  "+queue[front]);
                	int ele =sc.nextInt();
                	queue[rear++]=ele;
                	System.out.println("Element inserted");
                }
            } 
            else if (ch == 4) {
                if(rear==0)
                {
                	System.out.println("Queue is Empty");
                }
                else
                {
                	System.out.println("Queue elements : ");
                	for(int i=front;i<=rear-1;i++)
                	{
                		System.out.println(queue[i]);
                	}
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