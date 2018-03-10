public class UnorderedLinkedListInt extends LinkedListIntClass {
  
  public UnorderedLinkedListInt()
  {
    super();
  }
  
  public UnorderedLinkedListInt(int pitem, LinkedListIntClass plink)
  {
    super(pitem, plink);
  }
  
  public int findSum()
  {
    LinkedListIntClass current;
    current = first;
    int sum = 0;
    while (current != null)
    {
      sum = sum + current.info;
      current = current.link;
    }
    return sum;
  }
  
  public int findMin()
  {
    LinkedListIntClass current;
    current = first;
    int min = first.info;
    while (current != null)
    {
      if (current.info < min)
        min = current.info;
      current = current.link;
    }
    return min;
  }
  
  public void withBracketsAndCommas()
  {
    LinkedListIntClass current;
    current = first;
    System.out.print("[ ");
    while (current != null)
    {
      System.out.print(current.info + ", ");
      current = current.link;
    }
    System.out.println("]");
  }
  
  public boolean search(int searchItem)
  {
    LinkedListIntClass current;
    current = first;
    while(current != null)
    {
      if (current.info == searchItem)
        return true;
      current = current.link;
    }
    return false;
  }
  
  public void insertFirst(int newItem)
  {
    UnorderedLinkedListInt newNode;
    newNode = new UnorderedLinkedListInt(newItem, first);
    first = newNode;
    if (last == null)
      last = newNode;
    count++;
  }
  
  public void insertLast(int newItem)
  {
    LinkedListIntClass newNode;
    newNode = new UnorderedLinkedListInt(newItem, null);
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
  
  public void deleteNode(int deleteItem)
  {
    LinkedListIntClass current;
    LinkedListIntClass beforeCurrent;
    boolean found = false;
    if (first == null)
      System.err.println("Cannot delete from an empty list.");
    else
    {
      if (first.info == deleteItem)
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
          if (current.info == deleteItem)
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
          if (last == current)
            last = beforeCurrent;
        }
        else
          System.out.println("Item Not Found");
      }
    }
  } //End of deleteNode
} 