public class doublelinkedlist {
    private class Node{
        private int val;
        private Node prev;
        private Node next;
        public Node(int v, Node prev, Node next){
            val = v;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;

    public doublelinkedlist(){
        head = null;
    }
    void addStart(int v){
        if(head == null){
            head = new Node(v,null,null);
        }
        else{
            head = new Node(v,null,head);
        }
    }

    void addEnd(int v){
        if(head == null){
            head = new Node(v,null,null);
        }
        else{
            Node p;
            for(p = head; p.next!= null;p = p.next);
            p.next = new Node(v,p,null);
        }
    }
    void removeStart(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    void removeEnd(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node p,q;
        for(p = head,q = p.next; q.next != null; p = q,q=q.next);
        p.next = null;


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
        doublelinkedlist list = new doublelinkedlist();
        list.addEnd(0);
        list.addEnd(1);
        list.addStart(2);
        list.addStart(3);
        list.removeStart();
        list.removeStart();
        //list.removeStart();
        //list.removeStart();
        System.out.println(list.LtoString());
        //list.removeEnd();
        System.out.println(list.head.val);

        System.out.println(list.LtoString());
    }
}
