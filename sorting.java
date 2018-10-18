import java.util.Arrays;
import java.util.Random;


public class sorting {
    private static void swap(int[] x,int a,int b){
        int temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
    public static void bubblesort(int[] x){ //0(n^2)
        boolean ifchange;
        for(int j = x.length-1;j>0;j--){
            ifchange = Boolean.FALSE;
            for( int i =0; i<j;i++){
                if(x[i] > x[i+1]){
                    swap(x,i,i+1);
                    ifchange = Boolean.TRUE;

                }
            }
            if(ifchange == Boolean.FALSE){
                return;
            }
        }

    }

    public static void selectionSort(int[] x){ //0(n^2)
        int maxpos;
        for(int j = x.length-1;j>0;j--){
            maxpos = 0;
            for(int i =0; i<j; i++){
                if(x[i]>x[maxpos]){
                    maxpos = i;
                }
            }
            swap(x,j,maxpos);
        }
    }

    public static void insertionSort( int x[] ){
        int n = x.length;
        boolean reachfisrt;
        for (int i =1; i < n; i++){
            if( x[i] < x[i-1]){
                int temp = x[i];
                reachfisrt = Boolean.TRUE;
                for(int j = i-1; j >= 0; j--){
                    if( x[j] > temp){ x[j+1] = x[j]; }
                    else{
                        x[j+1] = temp;
                        reachfisrt = Boolean.FALSE;
                        break;}
                }
                if(reachfisrt){
                    x[0] = temp;
                }
            }

        }
    }

    public static void QuickSort(int x[],int left, int right){
        if(right <= left ){return;}
        double pivot = ((double)(x[left] +  x[right]))/2;
        int i = left;
        int j = right;
        while(i<j){
            while (x[i]< pivot){
                i++;
            }
            while (x[j]>=pivot){
                j--;
            }
            if(i<j){
                swap(x,i,j);
            }
        }
        QuickSort(x,0,i-1);
        QuickSort(x,i,right);
    }
    
    public static void HeapSort(int[] x){
        int n = x.length-1;
        for( int i = n/2; i >= 0; i-- ){ //MakeHeap
            MakeHeap(x,i,n);
        }
        for( int j = n; j>0; j--){
            swap(x,0,j);
            MakeHeap(x,0,j-1);
        }
    }
    private static void MakeHeap(int[] x,int i,int n){

        if(2*i+1>n){return;}
        int largerChild;
        if( 2*i+2 > n){
            largerChild = 2*i+1;
        }
        else if( x[2*i+1] > x[2*i+2]){
            largerChild = 2*i+1;
        }
        else{
            largerChild = 2*i+2;
        }
        if( x[largerChild] > x[i]){
            swap(x,largerChild,i);
            MakeHeap(x,largerChild,n);
        }

    }

    public static void MergeSort(int[] a, int[] b){
        int n = a.length;
        int[] c = new int[n*2];
        int i = 0; //pos for a
        int j = 0; // pos for b
        int k = 0; // pos for c
        while( i < n && j < n ) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;

            }
            k++;
            if( i == n-1){
                c[k] = a[i];
            }
            else{
                c[k] = b[j];
            }


        }
        System.out.println(Arrays.toString(c));
    }

    public static void FischerYates(int[] x){
        int r;
        for( int i= x.length-1; i >= 0; i--){
            r = (int)Math.random()*i;
           swap(x,i,r);
        }
    }
    public static int binarySearch(int[] x, int target){
        int left = 0;
        int right = x.length-1;
        int middle;
        if(x[0] == target){return 0;}
        if(x[x.length-1] == target){return x.length-1;}
        while (left < right){
            middle = ( x[left] + x[right])/2;
            if(x[middle] > target){
                right = middle-1;
            }
            else if(x[middle]< target){
                left = middle+1;
            }
            else {
                return middle;
            }
        }
        System.out.println("Not fount");
        return -1;
    }


    public static void main(String[] args){
        int[] x;
        /*
        x = new int[]{4,5,2,7,1,9,3,6,8};
        bubblesort(x);
        System.out.println(Arrays.toString(x));

        x = new int[]{4,5,2,7,1,9,3,6,8};
        selectionSort(x);
        System.out.println(Arrays.toString(x));

        x = new int[]{4,5,2,7,1,9,3,6,8};
        insertionSort(x);
        System.out.println(Arrays.toString(x));


        x = new int[]{4,5,2,7,1,9,3,6,8};
        QuickSort(x,0,x.length-1);
        System.out.println(Arrays.toString(x));

        x = new int[]{4,5,2,7,1,9,3,6,8};
        HeapSort(x);
        System.out.println(Arrays.toString(x));

        int[] a = new int[]{0,2};
        int[] b = new int[]{1,3};
        MergeSort(a,b);

        x = new int[]{1,2,3,4,5,6,7};
        FischerYates( x);
        System.out.println(Arrays.toString(x));
        */
        x = new int[]{0,1,2,3,4,5,6,7};
        System.out.println(binarySearch( x,7));
     }
}
