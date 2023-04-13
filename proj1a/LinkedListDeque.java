public class LinkedListDeque<T>{
    private Node sentinel;
    private Node last;
    private int size;
    public class Node{
        public Node(T item, Node next, Node previous) {
            this.item = item;
            this.next= next;
            this.previous = previous;
        }

        T item;
        Node next;

        Node previous;
    }
    public LinkedListDeque(){


        sentinel=new Node(null,null,null);
        last=new Node(null,null,sentinel);
        sentinel.next=last;
        size=0;
    }

    public void addFirst(T item){
        size+=1;
        Node node=new Node(item,null,null);
        node.next=sentinel.next;
        node.previous=sentinel;
        sentinel.next.previous=node;
        sentinel.next=node;
    }
    public void addLast(T item){
        size+=1;
        Node node=new Node(item,last,null);
        node.previous=last.previous;
        last.previous.next=node;
        last.previous=node;
    }
    public void isEmpty(){
        return size==0;
    }
    public void printDeque(){
        Node iter=sentinel;
        while(iter.next!=last){
            iter=iter.next;
            System.out.println(iter.item);
        }
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        Node node=sentinel.next;
        node.next.previous=sentinel;
        sentinel.next=node.next;
        return node.item;
    }
    public T removeLast(){
        if(size==0) return null;
        Node node=last.previous;
        node.previous.next=last;
        last.previous=node.previous;
        return node.item;
    }
    public T get(int index){
        if(index>=size-1){
            return null;
        }
        Node iter=sentinel;
        for(int _=0;_<index;_++){
            iter=iter.next;
        }
        return iter.item;
    }
    private T Recursive(Node head,int index){
        if(head==last){
            return null;
        }
        if(index==0){
            return head.item;
        }
        return Recursive(head.next,index-1);

    }

    public T getRecursive(int index){
        return  Recursive(sentinel.next,index);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }


}