import java.util.*;
public abstract class LinkedListClass<T extends Comparable<T>> implements LinkedListADT<T> 
{
  protected T info;
  protected LinkedListClass<T> link;
  protected LinkedListClass<T> first, last;
  protected int count;
  
  public LinkedListClass()
  {
    info = null;
    link = null;
    count = 0;
    first = null;
    last = null;
  }
  
  public LinkedListClass(T pinfo, LinkedListClass<T> plink)
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
    LinkedListClass<T> next;
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
  
  public T front()
  {
    return first.info;
  }
  
  public T back()
  {
    return last.info;
  }
}