class MyLinkedList{
  private class Node{
    private Integer data;
    private Node next,prev;
    public Node(Integer element, Node prevNode, Node nextNode){
      data = element;
      prev = prevNode;
      next = nextNode;
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
      data = value;
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
    MyLinkedList.add(value);
    MyLinkedList.add(value2);
    System.out.println(list.size());
    System.out.println(list);
  }
  public MyLinkedList(){
    Node start = new Node(null,null,null);
    Node end = new Node(null,null,null);
    start.setNext(end);
    end.setPrev(start);
    length = 0;
  }
  public boolean add(Integer value){
    if (length == 0){
      start.setData(value);
      length++;
      return true;
    } else {
      Node addToEnd = new Node(value,end,null);
      end.setNext(addToEnd);
      end = addToEnd;
      length++;
      return true;
    }
  }
  public int size(){
    return length;
  }
  public String toString(){
    current = start;
    String ans = "";
    while(current.next != null){
      and += current.getData();
      current = current.next;
    }
  }
}
