import java.util.*;
public class ClientUnorderedLinkedListInt {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
    UnorderedLinkedListInt tempList;
    int num = 0;
    
    boolean correct = false;
    System.out.println("Enter integers (999 to stop)");
    while(!correct)
    {
      try
      {
        num = input.nextInt();//valid??
        while (num != 999) {
          intList.insertLast((Integer) num);
          num = input.nextInt();//valid??
        }
        correct = true;
      } catch (InputMismatchException e)
      {
        System.out.print("Incorrect");
        input.next();
      }
    }
    correct = false;
    System.out.print("\nTesting .insertLast and .print. The original list is:");
    intList.print();
    System.out.println("\nTesting .length. The length of the list is: " + intList.length());
    if (!intList.isEmptyList()) {
      System.out.println("Testing .front. First element/list: " + intList.front());
      System.out.println("Testing .back. Last element/list: " + intList.back());
    }
    System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
    System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());
    System.out.print("Testing .search. Enter the number to search for/list: ");
    while(!correct)
    {
      try
      {
        num = input.nextInt();//valid??
        correct = true;
      } catch (InputMismatchException e)
      {
        System.out.print("Incorrect");
        input.next();
      }
    }
    correct = false;
    if (intList.search(num))
      System.out.println(num + " found in this list.");
    else
      System.out.println(num + " is not in this list.");
    System.out.print("Testing .remove. Enter the number to be deleted from list:");
    while(!correct)
    {
      try
      {
        num = input.nextInt();//valid??
        while (intList.search(num) == false)
        {
          System.out.print("Number Not Found");
          num = input.nextInt();
        }
        correct = true;
      } catch (InputMismatchException e)
      {
        System.out.print("Incorrect");
        input.next();
      }
    }
    intList.deleteNode(num);
    System.out.print("Testing .toString. After deleting " + num + ", the listis: ");
    intList.print();
    System.out.println("\nThe length of the list after delete is: " + intList.length());
    System.out.println("Testing findSum. Sum of the list is: " + intList.findSum());
    System.out.println("Testing findMin. Minimum value on the list is: " + intList.findMin());
    System.out.print("Testing withBracketsAndCommas. ... ");
    intList.withBracketsAndCommas();
    System.out.println();
  } // add methods for input validation
}