import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class GrowArray {
    private	int capacity; // the size of the block of memory
    private int size;     // how many are used
    private int[] p;       // pointer to the block
    private boolean checkGrow() { // double in size!!!
        boolean IfDouble = Boolean.FALSE;

        while(capacity < size+1) {
            if (capacity == 0){capacity = 1;}
            capacity *= 2;
            IfDouble = Boolean.TRUE;
            }
        return IfDouble;
    }

    public GrowArray() {
        p = null; // new int[len]
        capacity = 0;
        size = 0;
    }
    public void InitialGrowArray(int initialSize) {
        capacity = initialSize+1;
        size = initialSize;
        p = new int[capacity];
        System.out.println("capacity"+ capacity);
        System.out.println("size"+ size);
    }

    public void insertEnd(int v) { //O(1)
        if(checkGrow()){
            int[] old = p;
            p = new int[capacity];
            for( int i = 0; i< size; i++){
                p[i] = old[i];
            }
            size++;
        }else{
        p[size] = v;
        size++;
        }
        System.out.println("capacity"+ capacity);
        System.out.println("size"+ size);
    }
    public void insertStart(int v) { //O(???)
        if(checkGrow()){
            int[] old = p;
            p = new int[capacity];
            for( int i= size; i>0; i--){
                p[i] = old[i-1];
                p[0] = v;
            }
            size++;
        }else{
        for(int i = size; i>0; i--){
            p[i] = p[i-1];

        }
        p[0] = v;
        size++;
        }
        System.out.println("capacity"+ capacity);
        System.out.println("size"+ size);
    }
    public void insert(int pos, int v) {
        if(checkGrow()){
            int[] old =p;
            p = new int[capacity];
            for( int i = size; i > pos; i--){
                p[i] = old[i-1];
            }
            p[pos] = v;
            for( int i =0; i< pos; i++){
                p[i] = old[i];
            }
            size++;
        } else{
        for(int i = size; i > pos; i--){
            p[i] = p[i-1];
            p[pos] = v;
            size++;
        }
        }
    }
    public void removeStart() {
        for(int i = 0; i < size-1; i++) {
            p[i] = p[i + 1];
        }
        p[size-1] = 0;
        size--;
    }

    public void removeEnd() {
        p[size] = 0;
        size--;
    }

    public  String PtoString() {
        int avgSizePerElement = 5;
        StringBuilder b = new StringBuilder( avgSizePerElement * size );
        for(int i = 0; i< size; i++){
            b.append(p[i]);
            b.append(' ');
        }
        return b.toString();
    }
    public static void main(String[] args) {
        GrowArray b = new GrowArray();
        b.InitialGrowArray(10);
        System.out.println(b.PtoString());

        System.out.println("-----------Start insert End-------------");
        for (int i = 0; i < 10; i++)
            b.insertEnd(i);
        System.out.println(b.PtoString());

        System.out.println("-----------Start insert Start-------------");
        for (int i = 0; i < 10; i++)
            b.insertStart(i);
        System.out.println(b.PtoString());

        System.out.println("-----------Start remove Start-------------");
        for (int i = 0; i < 10; i++)
            b.removeStart();
        System.out.println(b.PtoString());

        System.out.println("-----------Start remove end-------------");
        b.removeEnd();
        System.out.println(b.PtoString());

    }
}
