import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Main {

	public static void main(String[] args) throws IOException {
		InsertionSort insort=new InsertionSort();
		HeapSort hsort=new HeapSort();
		Scanner sc=new Scanner(System.in);
		
        System.out.println("Enter input size ");
        int n=sc.nextInt();
        //Creating a random Integer Array
        int[] arr=createArray(n);
        Integer[] arr2=createArray2(n);
                
        FileWriter csvWriter = new FileWriter("sortingData.csv");
        csvWriter.append("Sorting");
        csvWriter.append(",");
        csvWriter.append("Input Size");
        csvWriter.append(",");
        csvWriter.append("Time");
        csvWriter.append("\n");

       //************************************Insertion Sort***************************************//
        	long elt=insort.insertionSort(arr);
        	
        	//************************************Heap Sort***************************************//
        	
        	Vector<Integer> vector = new Vector<Integer>(Arrays.asList(arr2));
        	long startTime = System.currentTimeMillis();
            hsort.buildHeap(vector,n);
            //hsort.printHeap(vector,n);
           Vector<Integer> sorted =hsort.heapSort(vector,n);
           long stopTime = System.currentTimeMillis();
 	      long elapsedTime = stopTime - startTime;
           //hsort.printHeap(sorted,n);
        
 	   //**********************************************************************//
 	      /* Writing Execution times to a file */
 	     List<List<String>> rows = Arrays.asList(
         	    Arrays.asList("Insertion Sort",Integer.toString(n),Long.toString(elt)),
         	    Arrays.asList("Heap Sort",Integer.toString(n),Long.toString(elapsedTime))
         	);
     	for (List<String> rowData : rows) {
         	//Rows
             
             csvWriter.append(String.join(",", rowData));
             csvWriter.append("\n");
         } 
        	
      //Close csv operations
     	csvWriter.flush();
     	csvWriter.close();
	}
	public static int[] createArray(int n) {
		// TODO Auto-generated method stub
		int max=100;
		Random rand=new Random();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=rand.nextInt(max);
			//System.out.print(arr[i]+" ");
		}
		return arr;
	}
	public static Integer[] createArray2(int n) {
		// TODO Auto-generated method stub
		int max=100;
		Random rand=new Random();
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=rand.nextInt(max);
			//System.out.print(arr[i]+" ");
		}
		return arr;
	}
}
