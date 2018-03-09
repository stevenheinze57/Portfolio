public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
//Double linked list node class
  
  
  public class DoubleLinkedListNode<T> {
    T info;
    DoubleLinkedListNode<T> next;
    DoubleLinkedListNode<T> back;
    int recursiveCount = 0;
    public DoubleLinkedListNode() {
      info = null;
      next = null;
      back = null;
    }
    public String toString() {
      return info.toString();
    }
  } //End of class DoubleLinkedListNode<T>
  
  
  
  protected int count; //number of nodes
  protected DoubleLinkedListNode<T> first; //reference to first node
  protected DoubleLinkedListNode<T> last; //reference to last node
  protected DoubleLinkedListNode<T> recurseNode = new DoubleLinkedListNode<T>();
  protected DoubleLinkedListNode<T> recurseNode2 = new DoubleLinkedListNode<T>();
  
  public void initializeList()
  {
    count = 0;
    first = null;
    last = null;
  }
  
  public boolean isEmptyList()
  {
    return (first == null);
  }
  
  public T front()
  {
    return first.info;
  }
  
  public T back()
  {
    return last.info;
  }
  
  public int length()
  {
    return count;
  }
  
  public void print()
  {
    DoubleLinkedListNode<T> current;
    current = first;
    for(int i = 0; i < count; i++)
    {
      System.out.print(current.info + " ");
      current = current.next;
    }
  }
  
  public void reversePrint()
  {
    DoubleLinkedListNode<T> current;
    current = last;
    for(int i = 0; i < count; i++)
    {
      System.out.print(current.info);
      current = current.back;
    }
  }
  
  public boolean search(T searchItem)
  {
    DoubleLinkedListNode<T> current;
    current = first;
    while(current.next != null)
    {
      if (current.info == searchItem)
        return true;
      current = current.next;
    }
    if (current.info == searchItem) //last item
      return true;
    return false;
  }
  
  public void insertNode(T insertItem)
  {
    DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
    newNode.info = insertItem;
    if (first == null) 
    {
      newNode.next = null;
      newNode.back = null;
      first = newNode;
      last = newNode;
      recurseNode = newNode;
    }
    else {
      last.next = newNode;
      newNode.next = null;
      newNode.back = last;
      last = newNode;
      recurseNode2 = last;
    }
    count++;
  }
  
  public void deleteNode(T deleteItem)
  {
    DoubleLinkedListNode<T> current = first;
    if (search(deleteItem) == false)
      System.out.print("Does not exist in this list.");
    else
      while(current.next != null)
    {
      if (current.info == deleteItem)
      {
        if (current.back == null) //if it's the first item
        {
          
          first = current.next;
          first.back = null;
          current = first.next;
          return;
        }
        //if its in the middle
        current.back.next = current.next;
        current.next.back = current.back;
        return;
      }
      current = current.next; //iterator
    }
    if (current.next == null) //if it's the last item
    {
      if (current.back == null) //if it's the last item and also the only item in the list
      {
        initializeList();
        return;
      }
      current.back.next = null; //if it's just the last item 
    }
  }
  
  public String toString()
  {
    String retVal = "";
    DoubleLinkedListNode<T> current;
    current = first;
    if (current == null)
      return "LIST IS EMPTY";
    while(current.next != null)
    {
      retVal = retVal + current.info + " ";
      current = current.next;
    }
    retVal = retVal + current.info;
    return "[head] " + retVal + " [tail]";
  }
  
  
  public String recursiveToString()
  {
    if (recurseNode == null)
      return "LIST IS EMPTY";
    if (recurseNode.next == null)
      return recurseNode.info + " ";
    recurseNode = recurseNode.next;
    return recurseNode.back.info + " " + recursiveToString();
  }
  
  
  public String backwardsString()
  {
    String retVal = "";
    DoubleLinkedListNode<T> current;
    current = last;
    while(current.back != null)
    {
      retVal = retVal + current.info + " ";
      current = current.back;
    }
    retVal = retVal + current.info;
    return "[tail] " + retVal + " [head]";
  }
  
  //DoubleLinkedList<T> recurse2 = new DoubleLinkedList<T>();
  /*DoubleLinkedListNode<T> recurseNode2 = last;
  public String recursiveBackwardsString()
  {
    if (recurseNode2 == last && recurseNode2.next == null)
      return "[head] " + recurseNode2.info + " [tail]";
    else if (recurseNode2 == last)
    {
      recurseNode2 = recurseNode2.back;
      return "[head] " + recurseNode2.info + recursiveToString();
    }
    else if (recurseNode2.back == null)
      return recurseNode2.info + " [tail]";
    else
    {
      recurseNode2 = recurseNode2.back;
      return recurseNode2.info + recursiveToString();
    }
  }*/
  
  
  public String recursiveBackwardsString()
  {
    if (recurseNode2 == null)
      return "LIST IS EMPTY";
    if (recurseNode2.back == null)
      return recurseNode2.info + " ";
    recurseNode2 = recurseNode2.back;
    return recurseNode2.next.info + " " + recursiveBackwardsString();
  }
  
  public boolean equals(DoubleLinkedList<T> o)
  {
    if (first == null || o.first != null)
      return false;
    DoubleLinkedList<T> cloneO = o;
    DoubleLinkedListNode<T> cloneCurrent = cloneO.first;
    DoubleLinkedListNode<T> current;
    current = first;
    while(!cloneO.isEmptyList())
    {
      if (cloneCurrent.info != current.info)
        return false;
      else
      {
        cloneCurrent = cloneCurrent.next;
        current = current.next;
      }
    }
    return true;
  }
  
  public void copy(DoubleLinkedList<T> otherList)
  {
    DoubleLinkedListNode<T> current = new DoubleLinkedListNode<T>();
    current = first;
    while(!isEmptyList())
    {
      deleteNode(current.info);
      current = current.next;
    }
    current = otherList.first;
    while(current.next != null)
    {
      insertNode(current.info);
      current = current.next;
    }
    insertNode(current.info); //last item 
  }
  
  public void reversedCopy(DoubleLinkedList<T> otherList)
  {
    DoubleLinkedListNode<T> current = new DoubleLinkedListNode<T>();
    current = first;
    while(!isEmptyList())
    {
      deleteNode(current.info);
      current = current.next;
    }
    current = otherList.last;
    while(current.back != null)
    {
      insertNode(current.info);
      current = current.back;
    }
    insertNode(current.info); //last item to be inserted (first in otherList)
    
  }
  
  
} //End of Master class 