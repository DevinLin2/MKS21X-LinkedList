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
    MyLinkedList list = new MyLinkedList();
    list.add(value);
    list.add(value2);
    list.add(value3);
    System.out.println(list.contains(4));
    System.out.println(list.contains(5));
    System.out.println(list);
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
    return getNthNode(index).getData();
  }
  public Integer set(int index, Integer value){
    return getNthNode(index).setData(value);
  }
  public boolean contains(Integer value){
    boolean contain = false;
    Node current = start;
    while (current != null){
      if (current.getData().equals(value)){
        contain = true;
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return contain;
      }
    }
    return contain;
  }
}
