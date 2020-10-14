package project1_algos;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class MergeSort
{
    static int[] inputsize= {1000, 2000, 3000, 5000, 10000,20000,30000,40000, 50000};
     //static int arr[] = {45,55,55,67,78,89,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,9,9,3,4,45,67,77,77,45,78,22,34,34};
    public static void main(String[] args) throws IOException 
    {
            Scanner sc=new Scanner(System.in);
           
            int[] arr = new int[0];
            for(int i=0;i<inputsize.length;i++)
            {
	int n=inputsize[i];
	arr=createArray(n);
	//Integer[] arr2=createArray2(n);
                  
                      arr=partition(arr);
                  
           }
           
            //printing the sorted array for each input size
             for(int i=0;i<inputsize.length;i++)
            {
                System.out.println();
                System.out.println();
                System.out.println("For input size:" +inputsize[i]);
            //arr=partition(arr);
                 for(int j=0;j<arr.length-1;j++) 
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
