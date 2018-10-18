public class linkedlist{
    private class Node{
        private int val;
        private Node next;
        public Node(int v,Node next){
            val =v;
            this.next = next;
        }
    }

    private Node head;
    public linkedlist(){
        head = null;
    }
    private void addStart(int v){
        if(head == null){
            head = new Node(v,null);
            return;
        }
        head = new Node(v,head);
    }

    private void addEnd(int v){
        if(head == null){
            head = new Node(v,null);
            return;
        }
        Node p;
        for( p = head; p.next != null; p = p.next);
        p.next = new Node(v,null);
    }

    private void removeStart(){
        if(head == null)
            return;
        head = head.next;
    }
    private void removeEnd(){
        if(head == null)
            return;
        if(head.next == null){
            head = null;
            return;
        }
        Node p,q;
        for(p = head, q = p.next; q.next!=null; p=q,q= q.next) ;
        p.next = null;
    }
    private void listtoString(){
        if(head==null){return;}
        StringBuilder s = new StringBuilder();
        for(Node p = head; p!= null;p = p.next){
            s.append(p.val);
            s.append(" ");
        }
        s.append("\n");
        System.out.println(s);
    }
    public static void main(String[] args){
        linkedlist list= new linkedlist();
        list.addStart(0);
        list.addStart(1);
        list.addEnd(2);
        list.addEnd(3);
        list.listtoString();
        list.removeStart();
        list.listtoString();
        list.removeEnd();
        list.listtoString();
        list.removeEnd();
        list.listtoString();
        list.removeEnd();
        list.listtoString();


    }
}