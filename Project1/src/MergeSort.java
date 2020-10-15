
	import java.io.IOException;
	import java.util.Random;
	import java.util.Scanner;


	public class MergeSort
	{
	     public static int[] merge(int[] left, int[] right) 
	    {
	            int n = left.length + right.length;
	            int[] B = new int[n];
	            int i = 0, j = 0, k = 0;
	            while (i < left.length || j < right.length)
	            {
		if (i < left.length && j < right.length) 
		{
	                        if (left[i] <= right[j]) 
	                        {
	                            B[k] = left[i];
	                            i++;
	                            k++;
	                        } 
	                        else 
	                        {
	                            B[k] = right[j];
	                            j++;
	                            k++;
	                        }
		} 
		else if (i < left.length) 
		{
	                        B[k] = left[i];
	                        i++;
	                        k++;
		} 
		else if (j < right.length) 
		{
	                        B[k] = right[j];
	                        j++;
	                        k++;
		}
	            }
		return B;
	          }

	    public static int[] partition(int[] A)
	    {
	        //long startTime = System.currentTimeMillis();
	        int mid;
	        if (A.length <= 1) 
	        {
	    	return A;
	        }
	        int[] right;
	        mid = A.length / 2;
	        int[] left = new int[mid];
	        if (A.length % 2 == 0) 
	        {
		right = new int[mid];
	        }
	        else 
	        {
		right = new int[mid + 1];
	        }

	        for (int i = 0; i < mid; i++) 
	        {
		left[i] = A[i];
	        }
	        int x = 0;
	        for (int k = mid; k < A.length; k++) 
	        {
		if (x < right.length) 
		{
	                        right[x] = A[k];
	                        x++;
		}
	         }
	        left = partition(left);
	        right = partition(right);
	        int[] result = new int[A.length];
	        result = merge(left, right);
	        return result;
	        }
}
