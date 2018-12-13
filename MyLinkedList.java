class MyLinkedList{
 private int size;
 private Node start, end;
 public MyLinkedList(){
 }
 public int size(){
   return this.size;
 }
 public boolean add(int value){
   Node add = new node(value, end, null);
 }
 public String toString(){
   String ans = start.data;
   for(int i = 0; i < this.size; i++){
     ans += start.next.data;
   }
 }
}

class Node{
 private int data;
 private Node next, prev;
 public Node(int element, Node prevNode, Node nextNode){
      this.data = element;
      this.prev = prevNode;
      this.next = nextNode;
    }
}
