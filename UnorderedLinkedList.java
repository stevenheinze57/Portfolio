public class UnorderedLinkedList<T extends Comparable<T>> extends LinkedListClass<T>
{
  public UnorderedLinkedList()
  {
    super();
  }
  
  public UnorderedLinkedList(T pitem, LinkedListClass<T> plink)
  {
    super(pitem, plink);
  }
  
  public void withBracketsAndCommas()
  {
    LinkedListClass<T> current;
    current = first;
    System.out.print("[ ");
    while (current != null)
    {
      System.out.print(current.info + ", ");
      current = current.link;
    }
    System.out.println("]");
  }
  
  public boolean search(T searchItem)
  {
    LinkedListClass<T> current;
    current = first;
    while(current != null)
    {
      if (current.info.compareTo(searchItem) == 0)
        return true;
      current = current.link;
    }
    return false;
  }
  
  public void insertFirst(T newItem)
  {
    UnorderedLinkedList<T> newNode;
    newNode = new UnorderedLinkedList<T>(newItem, first);
    first = newNode;
    if (last == null)
      last = newNode;
    count++;
  }
  
  public void insertLast(T newItem)
  {
    LinkedListClass<T> newNode;
    newNode = new UnorderedLinkedList<T>(newItem, null);
    if (first == null)
    {
      first = newNode;
      last = newNode;
    }
    else
    {
      last.link = newNode;
      last = newNode;
    }
    count++;
  }
  
  public void deleteNode(T deleteItem)
  {
    LinkedListClass<T> current;
    LinkedListClass<T> beforeCurrent;
    boolean found = false;
    if (first == null)
      System.err.println("Cannot delete from an empty list.");
    else
    {
      if (first.info.compareTo(deleteItem) == 0)
      {
        first = first.link;
        if (first == null)
          last = null;
        count--;
      }
      else
      {
        beforeCurrent = first;
        current = first.link;
        while (current != null && found == false)
        {
          if (current.info.compareTo(deleteItem) == 0)
            found = true;
          else
          {
            beforeCurrent = current;
            current = current.link;
          }
        }
        if (found)
        {
          count--;
          beforeCurrent.link = current.link;
          if (last == (current) )
            last = beforeCurrent;
        }
        else
          System.out.println("Item Not Found");
      }
    }
  } //End of deleteNode
  
  
  public UnorderedLinkedList<T> clone()
  {
    UnorderedLinkedList<T> copy = new UnorderedLinkedList<T>();
    LinkedListClass<T> current = first;
    for(int i = 0; i < length(); i++)
    {
      copy.insertLast(current.info);
      current = current.link;
    }
    return copy;
  }
  
  
  public boolean linearSearch(T item)
  {
    boolean found = false;
    LinkedListClass<T> current = first;
    while(!found)
    {
      if (current.info.compareTo(item) == 0)
        return true;
      else
        current = current.link;
      if (current == last)
        break;
    }
    return false;
  }
  
  public void bubbleSort()
  {
    boolean done = false;
    LinkedListClass<T> current = first;
    UnorderedLinkedList<T> temp = new UnorderedLinkedList<T>();
    for (int x = 0; x < length() - 1; x++)
    {
      current = first;
      for (int i = 0; i < length() - 1 - x; i++)
      {
        if ((current.info).compareTo(current.link.info) == 1)
        {
          temp.info = current.info;
          current.info = current.link.info;
          current.link.info = temp.info;
        }
        current = current.link;
      }
    }
  }
  
  
  public void selectionSort()
  {
    boolean swap = false;
    LinkedListClass<T> traversal = first;
    LinkedListClass<T> start = first;
    UnorderedLinkedList<T> minVal = new UnorderedLinkedList<T>();
    for(start = first; (start != null && start.link != null); start = start.link)
    {
      minVal.info = start.info;
      for (traversal = minVal.link; traversal != null; traversal = traversal.link)
      {
        if (traversal.info.compareTo(minVal.info) == -1)
          minVal.info = traversal.info;
      }
      if (minVal.info != start.info)
      {
        UnorderedLinkedList<T> temp = new UnorderedLinkedList<T>();
        temp.info = start.info;
        start = minVal;
        minVal = temp;
      }
    }
  } 
  
  public boolean binarySearch(T num)
  {
    LinkedListClass<T> x = first;
    LinkedListClass<T> middle = first;
    int lastPoint = length();
    int midPoint = lastPoint / 2;
    
    while(first.info.compareTo(last.info) <= 0)
    {
      middle = first;
      for (int i = 0; i < midPoint; i++)
      {
        if (middle.link != null)
          middle = middle.link;
      }
      if (middle.info.compareTo(num) == 0)
        return true;
      else 
      {
        if (middle.info.compareTo(num) > 0)
        {
          lastPoint = midPoint;
          last = middle;
          midPoint = lastPoint/2;
        }
        else
        {
          first = middle.link;
          midPoint = lastPoint - midPoint / 2;
        }
      }
      
    }
    return false;
  }
  
}