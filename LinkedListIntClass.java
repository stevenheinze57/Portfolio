import java.util.*;
public abstract class LinkedListIntClass implements LinkedListIntADT {
  protected int info;
  protected LinkedListIntClass link;
  protected LinkedListIntClass first, last;
  protected int count;
  
  public LinkedListIntClass()
  {
    info = 0;
    link = null;
    count = 0;
    first = null;
    last = null;
  }
  
  public LinkedListIntClass(int pinfo, LinkedListIntClass plink)
  {
    info = pinfo;
    link = plink;
    count = 0;
    first = null;
    last = null;
  }
  
  public boolean isEmptyList()
  {
    return (first == null);
  }
  
  public void initializeList()
  {
    first = null;
    last = null;
  }
  
  public void print()
  {
    LinkedListIntClass next;
    next = first;
    while(next != null)
    {
      System.out.printf("%5d", next.info);
      next = next.link;
    }
  }
  
  public int length()
  {
    return count;
  }
  
  public int front()
  {
    return first.info;
  }
  
  public int back()
  {
    return last.info;
  }
  
  
} 