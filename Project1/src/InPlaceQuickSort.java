import java.io.*;
import java.util.*;

public class InPlaceQuickSort
{
	public static long inPlaceQuickSort(int[] arr, int l, int r) 
    {
	 Random rand= new Random(); 
        long startTime = System.currentTimeMillis();
        int rnd =rand.nextInt(r-l)+l; 
        //int rnd = (l+r)/2;
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
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        
        return elapsedTime;
    }
 public static void print(int[] arr) {
	 for(int i=0;i<arr.length;i++) {
		 System.out.print(" "+arr[i]);
	 }
 }
}
    

