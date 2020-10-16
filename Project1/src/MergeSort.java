
	import java.io.IOException;
	import java.util.Random;
	import java.util.Scanner;


	public class MergeSort
	{
	     public static int[] merge(int[] left, int[] right) 
	    {
	            int n = left.length + right.length;
	            int[] newArray = new int[n];
	            int i = 0, j = 0, k = 0;
	            while (i < left.length || j < right.length)
	            {
			if (i < left.length && j < right.length) 
			{
				// if left is less than or equal to right then add the left value in the array
	                        if (left[i] <= right[j]) 
	                        {
	                            newArray[k] = left[i];
	                            i++;
	                            k++;
	                        } 
				// else add the right value
	                        else 
	                        {
	                            newArray[k] = right[j];
	                            j++;
	                            k++;
	                        }
			} 
			//if the right side array is over and only left remains then add all its elements in the array
			else if (i < left.length) 
			{
	                        newArray[k] = left[i];
	                        i++;
	                        k++;
			} 
			// if the left array is over and only right remains then add all its elements in the array
			else if (j < right.length) 
			{
	                        newArray[k] = right[j];
	                        j++;
	                        k++;
			}
	            }
		return newArray;
	          }

	    public static int[] partition(int[] A)
	    {
	        //long startTime = System.currentTimeMillis();
	        int mid;
	        if (A.length <= 1) 
	        {
	    	return A;
	        }
		// partition the array in two halves
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

		// add the first half array in left array
	        for (int i = 0; i < mid; i++) 
	        {
		left[i] = A[i];
	        }
		// add the second half in the right array
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
