import java.util.Scanner;

interface MyStack
{
    void push();
    void pop();
    void display();
}

class StackArray implements MyStack
{
    private static final int SIZE = 5;
    private int[] stack = new int[SIZE];
    private int top = -1;

    private Scanner sc;

    StackArray(Scanner sc)
    {
        this.sc = sc;
    }

    @Override
    public void push()
    {
        if (top == SIZE - 1)
        {
            System.out.println("Stack Overflow! Stack is full.");
            return;
        }

        try
        {
            System.out.print("Enter the element: ");
            int element = sc.nextInt();

            top++;
            stack[top] = element;

            System.out.println(element + " pushed into the stack.");
        }
        catch (Exception e)
        {
            System.out.println("Invalid input! Please enter an integer.");
            sc.nextLine();
        }
    }

    @Override
    public void pop()
    {
        if (top == -1)
        {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }

        int element = stack[top];
        top--;

        System.out.println("Popped element: " + element);
    }

    @Override
    public void display()
    {
        if (top == -1)
        {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }
    }
}

public class StackADT
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StackArray stack = new StackArray(sc);

        int choice = 0;

        do
        {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try
            {
                choice = sc.nextInt();

                switch (choice)
                {
                    case 1:
                        stack.push();
                        break;

                    case 2:
                        stack.pop();
                        break;

                    case 3:
                        stack.display();
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please choose 1-4.");
                }
            }
            catch (Exception e)
            {
                System.out.println(
                    "Invalid input! Please enter a number.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 4);

        sc.close();
    }
}
