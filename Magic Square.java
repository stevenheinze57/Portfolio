import java.util.*;

public class Heinze_HW_01_02
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    boolean doneLoop1 = false;
    boolean doneLoop2 = false;
    String doneOrNot = "";
    int size = 0;
    boolean correct = false;
    
    
    while (doneLoop1 == false)
    {
      while (correct == false)
      {
        System.out.print("Enter the size of the magic square (positive and odd): ");
        try
        {
          size = input.nextInt();
          
          while (!(size%2 > 0) || (size < 0))
          {
            System.out.println("Invalid size! Try again.");
            System.out.print("Enter the size of the magix square (positive and odd): ");
            size = input.nextInt();
          }
          correct = true;
        } catch (InputMismatchException e)
        {
          System.out.println("Invalid size! Try again.");
          input.next();
        }
      }
      
      int[][] magicSquare = new int[size][size];
      create(size, magicSquare);
      print(magicSquare);
      
      
      
      doneLoop2 = false;
      while (doneLoop2 == false)
      {
        System.out.print("Do you want to continue (Y/N): ");
        doneOrNot = input.next();
        if (doneOrNot.equals("Y"))
        {
          correct = false;
          doneLoop2 = true;
        }
        else if (doneOrNot.equals("y"))
        {
          correct = false;
          doneLoop2 = true;
        }
        else if (doneOrNot.equals("N") || doneOrNot.equals("n"))
        {
          System.out.println("Goodbye.");
          doneLoop1 = true;
          break;
        }
        else
          System.out.println("Incorrect option. Try again.");
      }
    }
    
  } //End of main
  
  public static void create(int size, int square[][])
  {
    int first = ((size - 1) / 2) + 1;
    boolean done = false;
    int k = 1;
    int count = 0;
    
    for (int y = 0; y < size - 1; y++)
    {
      for (int x = 0; x < size - 1; x++)
      {
        square[y][x] = 0;
      }
    }
    
    int y = 0;
    int x = first - 1;
    square[y][x] = k;
    count++;
    
    while(done == false)
    {
      if ((y - 1 < 0) || (x + 1 > size - 1) || (square[y - 1][x + 1] != 0))
      {
        if ((y - 1 < 0) && (x + 1 > size - 1))
        {
          y = y + 1;
          square[y][x] = k + 1;
          k++;
          count++;
        }
        else if (y - 1 < 0)
        {
          y = size - 1;
          x = x + 1;
          square[y][x] = k + 1;
          k++;
          count++;
        } 
        else if (x + 1 > size - 1)
        {
          y = y - 1;
          x = 0;
          square[y][x] = k + 1;
          k++;
          count++;
        }
        else 
        {
          y = y + 1;
          square[y][x] = k + 1;
          k++;
          count++;
        }
      }
      else 
        {
          y = y - 1;
          x = x + 1;
          square[y][x] = k + 1;
          k++;
          count++;
        }
      if (count == (size * size))
        done = true;
    }
  } //End of create
  
  public static void print(int square[][])
  {
    int size = square.length;
    int sum = 0;
    System.out.println("The magic square with size = " + size + " is: ");
    for (int y = 0; y < size; y++)
    {
      System.out.println();
      sum = sum + square[y][0];
      for (int x = 0; x < size; x++)
      {
        System.out.printf("%5d", square[y][x]);
      }
    }
    System.out.println();
    System.out.println("The " + size + "x" + size + " magic square adds up to " + sum);
  } //End of print
  
} //End of class