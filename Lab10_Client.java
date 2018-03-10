import java.util.*;

public class Lab10_Client
{
  public static void main(String[] args)
  {
    //Main section
    Scanner input = new Scanner(System.in);
    boolean done = false;
    int x = 0;
    int count = 0;
    int delete = 0;
    LinkedStackClass<Integer> s = new LinkedStackClass<Integer>();
    
    System.out.print("Enter integers (999 to stop): ");
    while (!done)
    {
      try 
      {
        while (x != 999)
        {
          x = input.nextInt();
          s.push(x);
        }
        done = true;
      } catch (InputMismatchException e)
      {
        System.out.println("Not an Integer!");
        input.next();
      }
    }
    done = false;
    
    //Output
    System.out.println("Here is the stack in reverse order (top to bottom): ");
    printBackStack(s);
    System.out.println("Here is the stack in the original order (bottom to top): ");
    printStack(s);
    System.out.print("The second value is " + getSecond(s));
    System.out.println();
    count = countItems(s);
    System.out.print("Number of items in this stack: " + count);
    System.out.println();
    printStack(s);
    System.out.print("Enter a number to be removed: ");
    while(!done)
    {
      try
      {
        delete = input.nextInt();
        done = true;
      } catch (InputMismatchException e)
      {
        System.out.print("Incorrect! Not an Integer! try again");
        input.next();
      }
    }
    done = false;
    
    System.out.println("The stack after removing every occurance of " + delete + " is ");
    removeItem(s, delete);
    printStack(s);
    System.out.println();
    System.out.println("The stack after being reversed by a queue");
    reverseStack(s);
    printStack(s);
    System.out.println();
    System.out.println();
    
    System.out.println("Creating a new queue called mainQ");
    QueueClass<Integer> mainQ = new QueueClass<Integer>();
    mainQ.enqueue(1);
    mainQ.enqueue(2);
    mainQ.enqueue(3);
    mainQ.enqueue(4);
    mainQ.enqueue(5);
    System.out.println("The queue in its original order: ");
    printQueue(mainQ);
    System.out.println();
    System.out.println("The queue in its reversed order: ");
    reverseQueue(mainQ);
    printQueue(mainQ);
  }
  
  
  
  
//Lab methods to test 
  public static void printBackStack(LinkedStackClass<Integer> intStack)
  {
    LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
    while(!intStack.isEmptyStack())
    {
      System.out.print(" " + intStack.peek());
      temp.push(intStack.peek());
      intStack.pop();
    }
    while(!temp.isEmptyStack())
    {
      intStack.push(temp.peek());
      temp.pop();
    }
    System.out.println();
  }
  
  public static void printStack(LinkedStackClass<Integer> intStack) 
  {
    LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
    while(!intStack.isEmptyStack())
    {
      temp.push(intStack.peek());
      intStack.pop();
    }
    while(!temp.isEmptyStack())
    {
      System.out.print(" " + temp.peek());
      intStack.push(temp.peek());
      temp.pop();
    }
    System.out.println();
  }
  
  
  public static Integer getSecond(LinkedStackClass<Integer> intStack) 
  {
    int tempVal;
    tempVal = intStack.peek();
    intStack.pop();
    int retVal = intStack.peek();
    intStack.push(tempVal);
    return retVal;
  }
  
  
  public static int countItems(LinkedStackClass<Integer> intStack) 
  {
    LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
    int count = 0;
    while(!intStack.isEmptyStack())
    {
      temp.push(intStack.peek());
      intStack.pop();
      count++;
    }
    while(!temp.isEmptyStack())
    {
      intStack.push(temp.peek());
      temp.pop();
    }
    return count;
  }
  
  
  public static void removeItem(LinkedStackClass<Integer> intStack, Integer n) 
  {
    LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
    boolean done = false;
    while(!intStack.isEmptyStack())
    {
      if (intStack.peek() == n)
        intStack.pop(); 
      else
      {
        temp.push(intStack.peek());
        intStack.pop();
      }
    }
    while(!temp.isEmptyStack())
    {
      intStack.push(temp.peek());
      temp.pop();
    }
  }
  
  public static void reverseStack(LinkedStackClass<Integer> intStack) 
  {
    QueueClass<Integer> q = new QueueClass<Integer>();
    while(!intStack.isEmptyStack())
    {
      q.enqueue(intStack.peek());
      intStack.pop();
    }
    while(!q.isEmptyQueue())
    {
      intStack.push(q.front());
      q.dequeue();
    }
  }
  
  
  public static void reverseQueue(QueueClass<Integer> q)
  {
    LinkedStackClass<Integer> s = new LinkedStackClass<Integer>();
    while(!q.isEmptyQueue())
    {
      s.push(q.front());
      q.dequeue();
    }
    while(!s.isEmptyStack())
    {
      q.enqueue(s.peek());
      s.pop();
    }
  }
  
  public static void printQueue(QueueClass<Integer> q) 
  {
    QueueClass<Integer> temp = new QueueClass<Integer>();
    while(!q.isEmptyQueue())
    {
      temp.enqueue(q.front());
      q.dequeue();
    }
    while(!temp.isEmptyQueue())
    {
      System.out.print(" " + temp.front());
      q.enqueue(temp.front());
      temp.dequeue();
    }
  }
  
} //End of class