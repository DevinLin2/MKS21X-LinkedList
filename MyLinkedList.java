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
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
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
    MyLinkedList list = new MyLinkedList();
    list.add(value);
    list.add(value2);
    System.out.println(list.size());
    System.out.println(list);
  }
  public MyLinkedList(){
    start = new Node(null,null,null);
    end = start;
    length = 0;
  }
  public boolean add(Integer value){
    if (length == 0){
      start.setData(value);
      length++;
      return true;
    }
    if (length == 1){
      end.setData(value);
      start.setNext(end);
      end.setPrev(start);
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
    while(current.next != null){
      ans += current.getData();
      current = current.next;
    }
    return ans;
  }
}
