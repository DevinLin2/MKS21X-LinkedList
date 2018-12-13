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
  public MyLinkedList(){
    Node startNode = new Node(null,null,null);
    Node endNode = new Node(null,null,null);
  }
  public int size(){
    return this.length;
  }
  public boolean add(int value){
    Node add = new node(value, end, null);
  }
  public String toString(){
    String ans = start.data;
    for(int i = 0; i < this.length; i++){
      ans += start.next.data;
    }
  }
}
