import java.util.Random;

public class sort {
    public static void main(String[] args) {
        int[] OriginalList = new int[] {1,2,7,3,6,5,4,8,11,13,9};
        for( int element: OriginalList){System.out.print(element + " ");}
        System.out.println();

        int n = OriginalList.length -1 ;
        //Heapsort(OriginalList,n);
        //MakeHeap(OriginalList,n/2);
        System.out.print( FindeTheK(n));

        System.out.println();
        for( int element: OriginalList){System.out.print(element+ " ");}
        System.out.println();
        };
    public static int FindeTheK(int n){
        int i =0;
        int SumPower = 0;
        while( SumPower < n){
            SumPower += Math.pow(2,i);
            i++;
        }
        return (int)(SumPower -Math.pow(2,i-1));
    }
    public static  void swap(int x[], int i,int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
    public static  void Heapsort(int x[],int n){
        if( n < 0 ){return;}

        for( int i = n/2; i >=0; i--){
            MakeHeap(x,i);} //create the heap
        swap(x,0,n);
        Heapsort(x,n-1);
    }

    public static  void  MakeHeap(int x[], int i){
        int n = x.length -1 ;
        if( 2*i+1 > n){return;}
        else if(2*i+2 > n){
            swap(x,i,2*i+1);
        } else{
            int LargeChild;
            if (x[2*i+1] > x[ 2*i+2]){ LargeChild = 2*i+1; }
            else{LargeChild = 2*i+2;}
            if (x[LargeChild] > x[i]){swap(x,i,LargeChild); }
            MakeHeap(x,LargeChild);
        }
    }




    public static  void QuickSort(int x[], int left, int right){
        if(left >= right){ ;
            return;}
        double pivot = (x[left] + x[right])/2;
        int i = left;
        int j = right;

        while ( i < j){
            while ( x[i] <= pivot){ i++;}
            while ( x[j] > pivot){ j--;}
            if(i<j){
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        } // when while loop finished, i == j
        QuickSort( x, left, i-1);
        QuickSort( x, i, right);



    }
    public static void InsertionSort( int x[] ){
        int n = x.length;
        for (int i =1; i < n; i++){
            if( x[i] < x[i-1]){
            int temp = x[i];
            for(int j = i-1; j >= 0; j--){
                if( x[j] > temp){ x[j+1] = x[j]; }
                else{ x[j+1] = temp;
                break;}
            }
            }
        }
    }


    public static void SelectionSort( int x[]){
        int n = x.length;
        for( int j = n-1; j >= 0; j--){
            int MaxPos = 0;
            int MaxNumber = 0;
            for(int i = 0; i <= j; i++){
                //System.out.println("I,J " + j + " " + i);
                if(x[i] > MaxNumber){
                    MaxPos = i;
                    MaxNumber = x[i] ;
                }
            }
            if( j != MaxPos){
                int temp;
                temp = x[j];
                x[j] = x[MaxPos];
                x[MaxPos] = temp;
            }

        }
    }
    public static void ImprovedBubble( int x[]){
        int n = x.length;
        boolean sorted;
        for(int i = 0; i < n-1; i++){
            sorted = Boolean.TRUE;
            for( int j =0; j< n-1; j++){
                int temp;
                if( x[j] > x[j+1]){
                    temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                    sorted = Boolean.FALSE;
                };
            if (sorted){break;}
            }
        }
    }

    public static void BubbleSort( int x[]){
        int n = x.length;
        for(int i = 0; i < n-1; i++){
            for( int j =0; j< n-1; j++){
                int temp;
                if( x[j] > x[j+1]){
                    temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }
    }

}
