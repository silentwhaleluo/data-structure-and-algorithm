public class doublelinkedlist2 {
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int v,Node prev,Node next){
            val = v;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head,tail;
    public doublelinkedlist2(){
        head = tail = null;
    }
    void addStart(int v){
        if(head == null){
            head = tail = new Node(v,null,null);
        }
        else{
            head = new Node(v,null,head);
            head.next.prev = head;
        }
    }

    void addEnd(int v){
        if(head == null){
            head = tail = new Node(v,null,null);
        }
        else{
            tail = new Node(v,tail,null);
            tail.prev.next = tail;
        }
    }
    void removeStart(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
    }
    void removeEnd(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
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
        doublelinkedlist2 list = new doublelinkedlist2();
        list.addEnd(0);
        list.addEnd(1);
        list.addStart(2);
        list.addStart(3);
        list.removeStart();
        list.removeStart();
        list.removeStart();
        //list.removeStart();
        System.out.println(list.LtoString());
        list.removeEnd();
        //System.out.println(list.head.val);

        System.out.println(list.LtoString());
    }
}
