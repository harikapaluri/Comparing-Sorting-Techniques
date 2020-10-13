import java.io.*;
import java.util.*;

public class InPlaceQuickSort
{
    static int[] inputsize= {1000, 2000, 3000, 5000, 10000,20000,30000,40000, 50000};
            
    public static void main(String[] args) throws IOException 
    {
            Scanner sc=new Scanner(System.in);
            int[] arr = new int[0];
            for(int i=0;i<inputsize.length;i++)
            {
	int n=inputsize[i];
	arr=createArray(n);
	Integer[] arr2=createArray2(n);
                 long elt=inPlaceQuickSort(arr, 0, arr.length-1);
            }
           
             for(int i=0;i<inputsize.length;i++)
            {
                System.out.println();
                System.out.println();
                System.out.println("For input size:" +inputsize[i]);
                 for(int j=0;j<arr.length;j++) 
                {
                    System.out.print(arr[j]+" ");
                }
            }
     }
        
    public static int[] createArray(int n) 
    {
        int max=n;
        Random rand=new Random();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) 
        {
            arr[i]=rand.nextInt(max);
        }
        return arr;
    }
	
    public static Integer[] createArray2(int n) 
    {
        // TODO Auto-generated method stub
        int max=100;
        Random rand=new Random();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++) 
        {
	arr[i]=rand.nextInt(max);
        }
        return arr;
    }
    
    public static long inPlaceQuickSort(int[] arr, int l, int r) 
    {
        long startTime = System.currentTimeMillis();
        //int rnd = new Random().nextInt(arr.length-1);
        int rnd = (l+r)/2;
        int leftChk = l;
        int rightChk = r;
        int pivot = arr[rnd];
        int left = arr[0];
        int right = arr[arr.length-1];
    
        while(l<=r)
        {
            while(arr[l]<pivot)
                  l++;
            while(arr[r]>pivot)
                r--;
            if(l<=r)
            {
               int temp = arr[l];
               arr[l] = arr[r];
               arr[r] = temp;
                l++;
                r--;
            }
        }  
          if(leftChk<r)
              inPlaceQuickSort(arr, leftChk, r);
          if(l<rightChk)
               inPlaceQuickSort(arr, l, rightChk);
            
            
            /*if(arr[l]>pivot && arr[r]<pivot)
            {
                long[] swappedEle = swap(arr[l],arr[r]);
                arr[l]=swappedEle[0];
                arr[r] = swappedEle[1];
                l++;
                r++;
            }
            else
            {
                l++;
                r--;
            }
        }
        if(l<pivot)
        {
            long[] swappedEle = swap(l,pivot);
                l=swappedEle[0];
                r = swappedEle[1];
        }
        }*/
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        
        return elapsedTime;
    }
}
    

