class MyLinkedList{
  private class Node{
    private Integer data;
    private Node next,prev;
    public Node(Integer element, Node prevNode, Node nextNode){
      this.data = element;
      this.prev = prevNode;
      this.next = nextNode;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      this.next = other;
    }
    public void setPrev(Node other){
      this.prev = other;
    }
    public Integer getData(){
      return data;
    }
    public Integer setData(Integer value){
      Integer oldData = data;
      data = value;
      return oldData;
    }
    public String toString(){
      return data + "";
    }
  }
  private int length;
  private Node start,end;
  public static void main(String[] args){
    Integer value = 5;
    Integer value2 = 6;
    Integer value3 = 9;
    Integer replacement = 2;
    Integer replacement2 = 8;
    Integer replacement3 = 7;
    MyLinkedList list = new MyLinkedList();
    list.add(value);
    list.add(value2);
    list.add(value3);
    System.out.println(list); // 5, 6, 9
    System.out.println("size: " + list.size()); // 3
    list.add(0,replacement);
    System.out.println(list); // 2, 5, 6, 9
    System.out.println("size: " + list.size()); // 4
    list.add(2,replacement2);
    System.out.println(list); // 2, 5, 8, 6, 9
    System.out.println("size: " + list.size()); // 5
    list.add(5,replacement3);
    System.out.println(list); // 2, 5, 8, 6, 9, 7
    System.out.println("size: " + list.size()); // 6
    list.add(4,replacement2);
    System.out.println(list); // 2, 5, 8, 6, 8, 9, 7
    System.out.println("size: " + list.size()); // 7
    list.remove(0);
    System.out.println(list); // 5, 8, 6, 8, 9, 7
    System.out.println("size: " + list.size()); // 6
    list.remove(5);
    System.out.println(list); // 5, 8, 6, 8, 9
    System.out.println("size: " + list.size()); // 5
    list.remove(3);
    System.out.println(list); // 5, 8, 6, 9
    System.out.println("size: " + list.size()); // 4
    list.remove(1);
    System.out.println(list); // 5, 6, 9
    System.out.println("size: " + list.size()); // 3
    list.remove(value);
    System.out.println(list); // 6, 9
    System.out.println("size: " + list.size()); // 2
    list.remove(value2);
    System.out.println(list); // 9
    System.out.println("size: " + list.size()); // 1
    list.remove(value3);
    System.out.println(list);  // empty
    System.out.println("size: " + list.size()); // 0
  }
  public MyLinkedList(){
    start = new Node(null,null,null);
    end = new Node(null,null,null);
    length = 0;
  }
  public boolean add(Integer value){
    if (length == 0){
      start.setData(value);
      end.setPrev(start);
      length++;
      return true;
    }
    if (length == 1){
      end.setData(value);
      start.setNext(end);
      length++;
      return true;
    }
    Node addToEnd = new Node(value,null,null);
    end.setNext(addToEnd);
    addToEnd.setPrev(end);
    end = addToEnd;
    length++;
    return true;
  }
  public int size(){
    return length;
  }
  public String toString(){
    Node current = start;
    String ans = "";
    while (current != null){
      ans += current.getData();
      if (current.next() != null){
        ans += ", ";
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return ans;
      }
    }
    return ans;
  }
  private Node getNthNode(int index){
    int i = index;
    Node NthNode = start;
    while (i > 0){
      NthNode = NthNode.next();
      i--;
    }
    return NthNode;
  }
  public Integer get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    return getNthNode(index).getData();
  }
  public Integer set(int index, Integer value){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    return getNthNode(index).setData(value);
  }
  public boolean contains(Integer value){
    Node current = start;
    while (current != null){
      if (current.getData().equals(value)){
        return true;
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return false;
      }
    }
    return false; // should never run
  }
  public int indexOf(Integer value){
    int index = 0;
    Node current = start;
    if (!(this.contains(value))){
      return -1;
    }
    while (current != null){
      if (current.getData().equals(value)){
        return index;
      }
      if (current.next() != null){
        current = current.next();
        index++;
      }
    }
    return -1;
  }
  public void add(int index, Integer value){
    if (index < 0 || index > size()){
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    Node toAdd = new Node(value,null,null);
    if (index != 0 && index != length){ // ask about why the order of this matters.
      Node nodeAtIndex = getNthNode(index);
      toAdd.setPrev(nodeAtIndex.prev);
      toAdd.setNext(nodeAtIndex);
      nodeAtIndex.prev.setNext(toAdd);
      nodeAtIndex.setPrev(toAdd);
    }
    if (index == 0){
      toAdd.setNext(start);
      start.setPrev(toAdd);
      start = toAdd;
    }
    if (index == length){
      toAdd.setPrev(end);
      end.setNext(toAdd);
      end = toAdd;
    }
    length++;
  }
  public Integer remove(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    Node toRemove = getNthNode(index);
    Integer data = toRemove.getData();
    if (length == 1){
      start = null;
      end = null;
      length--;
      return data;
    }
    if (index != 0 && index != length-1){
      toRemove.prev().setNext(toRemove.next());
      toRemove.next().setPrev(toRemove.prev());
    }
    if (index == 0){
      start = start.next();
      start.prev.setNext(null);
      start.setPrev(null);
    }
    if (index == length-1){
      end = end.prev();
      end.next.setPrev(null);
      end.setNext(null);
    }
    length--;
    return data;
  }
  public boolean remove(Integer value){
    Node current = start;
    if (length == 1){
      if (current.getData().equals(value)){
        start = null;
        end = null;
        length--;
        return true;
      } else {
        return false;
      }
    }
    while (current != null){
      if (current.getData().equals(value)){
        if (current != start && current != end){
          current.prev().setNext(current.next());
          current.next().setPrev(current.prev());
        }
        if (current == start){
          start = start.next();
          start.prev.setNext(null);
          start.setPrev(null);
        }
        if (current == end){
          end = end.prev();
          end.next.setPrev(null);
          end.setNext(null);
        }
        length--;
        return true;
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return false;
      }
    }
    return false;
  }
}
