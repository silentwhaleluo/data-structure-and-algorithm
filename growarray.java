import java.util.Arrays;

public class growarray {
    private int[] p;
    private int capacity;
    private int size;
    public void growarray(){
        p = null;
        capacity = 0;
        size = 0;
    }

    public boolean cheacGrow(){
        if(capacity < size +2){
            capacity = 2*capacity+1;
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    public void addStart(int v){
        if(cheacGrow()){
            int[] old = p;
            p = new int[capacity];
            for(int i = 0; i <size; i++){

                p[i+1] = old[i];

            }
        }
        else {
            for(int i=size; i>0; i--){
                p[i] = p[i-1];
            }
        }
        p[0] = v;
        size++;
    }

    public void addFront(int start,int step, int end){
        for(int i = start; i<=end; i = i+step){
            addStart(i);
        }

    }

    public void addEnd(int v){
        p[size] = v;
        size++;
    }
    public void addBack(int start,int step, int end){
        for(int i = start; i<=end; i = i+step){
            if(cheacGrow()){
                int[] old = p;
                p = new int[capacity];
                for(int j=0; j<size; j++){
                    p[j] =old[j];
                }
            }
            addEnd(i);
        }

    }
    public void add(int pos,int v){
        if(cheacGrow()){
            int[] old = p;
            p = new int[capacity];
            for(int i =0; i<pos; i++){
                p[i] = old[i];
            }
            for(int i = size; i>pos; i--){
                p[i] = old[i-1];
            }
            p[pos] = v;
            size++;
            System.out.println("che");
        }
        else {
            for(int i = size; i>pos; i--){
                p[i] = p[i-1];

            }
            p[pos] = v;
            size++;
        }

    }

    public void removeEnd(){
        p[size-1] = 0;
        size--;
    }
    public void removeEnd(int n){
        for(int i =0; i< n;i++){
            p[size-1] = 0;
            size--;
        }
    }
    public void removeStart(){
        for(int i =0; i<size-1;i++){
            p[i] = p[i+1];
        }
        size--;
        p[size] =0;
    }
    public void removeStart(int n){
        for(int i=0;i<size-n;i++){
            p[i] = p[i+n];
        }
        for(int i=size-1;i>size-1-n;i--){
            p[i] = 0;
        }
        size = size-n;
    }
    public void PtoString(){
        StringBuilder s = new StringBuilder();
        for(int i =0; i<size;i++){
            s.append(p[i]);
            s.append(' ');
        }
        s.append("\n");
        System.out.println(s.toString());
    }
    public static void main(String[] args){
        growarray list = new growarray();
        list.addFront(1,2,10);

        list.addBack(5,5,25);


        list.removeStart(2);

        list.removeEnd(2);

        list.PtoString();

        list.add(1,100);

        list.PtoString();
    }
}
