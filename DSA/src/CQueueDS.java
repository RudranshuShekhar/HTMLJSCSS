import java.util.Scanner;
class CQueueDS {
    static int cq[];
    static int front=-1, rear=-1, size;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size:");
        int n= sc.nextInt();
        create(n);
        System.out.println("Queue is ready");

        while(true)
        {
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Traverse");
            System.out.println("4.Exit");

            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();
            if (ch==1){
                System.out.println("Enter Element :");
                int ele = sc.nextInt();
                insert(ele);
            }
            else if(ch==2)
            {
                delete();
            }
            else if(ch==3)
            {
                traverse();
            }
            else if(ch==4)
            {
                System.out.println("End");
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }

        }

    }
    static void create(int n)
    {
        cq = new int[n];
        size = n;
    }
    static void insert(int ele)
    {
        if(isFull())
        {
            System.out.println("Queue Overflow");
        }
        else
        {
            if(rear == -1)
            {
                front = rear = 0;
            }
            else if(rear == size-1)
            {
                rear = 0;
            }
            else {
                rear++;
            }
            cq[rear] = ele;
            System.out.println("Inserted");
        }
    }
    static void delete()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Underflow");
        }
        else {
            System.out.println("Deleted : " +cq[front]);
            if(front == rear)
            {
                front = rear-1;
            }
            else if(front == size-1)
            {
                front = 0;
            }
            else {
                front++;
            }
        }
    }
    static void traverse()
    {
        if(isEmpty())
        {
            System.out.println("Queue is UnderFlow");
        }
        else {
            System.out.println("Queue Elements are:");
            if(front<=rear)
            {
                for(int i=front; i<=rear; i++)
                {
                    System.out.println(cq[i]);
                }
            }
            else {
                for(int i=front; i<=size ;i++)
                {
                    System.out.println(cq[i]);
                }
                for(int i=0; i<=rear; i++)
                {
                    System.out.println(cq[i]);
                }
            }
        }
    }
    static boolean isFull()
    {
        if((front==0 && rear == size-1)||(front==rear+1))
            return true;
        else
            return false;
    }
    static boolean isEmpty()
    {
        if(rear == -1)
            return true;
        else
            return false;
    }
}