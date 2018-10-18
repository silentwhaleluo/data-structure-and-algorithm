public class linkedlist2 {
    private class Node{
        private int val;
        private Node next;
        public Node(int v, Node next){
            val = v;
            this.next = next;
        }
    }
    private Node head,tail;
    public linkedlist2(){
        head = tail = null;
    }
    void addStart(int v){
        if(head == null){
            head = tail = new Node(v,null);
        }
        else{
            head = new Node(v,head);
        }
    }

    void addEnd(int v){
        if(tail == null){
            head = tail = new Node(v,null);
        }
        else{
            tail.next = new Node(v,null);
            tail = tail.next;
        }
    }

    void removeStart(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    void removeEnd(){
        if(head == null){
            return;
        }
        Node p;
        for(p = head; p.next != tail; p = p.next);
        p.next = null;
        tail = p;

    }
    String LtoString(){
        if(head == null)
            return " ";
        StringBuilder s = new StringBuilder();
        for(Node p = head; p != null; p = p.next){
            s.append(p.val);
            s.append(" ");
        }
        return s.toString();

    }

    public static void main(String[] args){
        linkedlist2 list = new linkedlist2();
        list.addEnd(0);
        list.addEnd(1);
        list.addEnd(2);
        //list.removeStart();
        list.removeEnd();
        System.out.println(list.head.val);
        System.out.println(list.tail.val);
        System.out.println(list.LtoString());
    }
}
