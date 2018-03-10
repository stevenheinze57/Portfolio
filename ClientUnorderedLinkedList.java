import java.util.*;
public class ClientUnorderedLinkedList {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    UnorderedLinkedList<Integer> intList = new UnorderedLinkedList<Integer>();
    UnorderedLinkedList<Integer> tempList;
    int num;
    boolean done = false;
    System.out.println("Enter integers (999 to stop)");
    while (!done)
    {
      try
      {
        num = input.nextInt();//valid??
        while (num != 999) {
          intList.insertLast((Integer) num);
          num = input.nextInt();//valid??
        }
        done = true;
      } catch (InputMismatchException e)
      {
        System.out.print("Incorrect try again: ");
        input.next();
      }
    }
    
    
     System.out.print("Testing linearSearch. Enter the number to search for/list:");
    num = input.nextInt(); //valid??
    if (intList.linearSearch(num))
      System.out.println(num + " found in this list by linearSearch.");
    else
      System.out.println(num + " is not in this list by linearSearch."); 
    tempList = intList.clone();
    System.out.println("Testing bubbleSort. Sorted list is: ");
    intList.bubbleSort();
    intList.print();  
    System.out.println();
    System.out.println("Testing selectionSort. tempList is: ");
    tempList.print();
    System.out.println();
    System.out.println("Sorted tempList is: ");
    tempList.selectionSort();
    tempList.print();
    System.out.println();
    if (intList.binarySearch(num))
      System.out.println(num + " found in this list by binarySearch.");
    else
      System.out.println(num + " is not in this list by binarySearch.");
//Optional: add more testing here*/
  } // add methods for input validation
}
