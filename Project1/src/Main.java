import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		//To run sorting algorithms on different input sizes
		int[] inputsize= {1000, 2000, 3000, 5000, 10000,20000,30000,40000, 50000};
      
		//1.on random Inputs
		for(int i=0;i<inputsize.length;i++) {
			 //Creating a random Integer Array
			int n=inputsize[i];
	        int[] arr=createArray(n);
	        Integer[] arr2=createArrayForVector(n);
	        
	       //************************************Insertion Sort***************************************//
	        	long insortTime=insort.insertionSort(arr);
	        	
	        	//************************************Heap Sort***************************************//
	        	
	        	Vector<Integer> vector = new Vector<Integer>(Arrays.asList(arr2));
	        	long startTime = System.currentTimeMillis();
	            hsort.buildHeap(vector,n);
	            //hsort.printHeap(vector,n);
	           Vector<Integer> sorted =hsort.heapSort(vector,n);
	           long stopTime = System.currentTimeMillis();
	 	      long hsortTime = stopTime - startTime;
	           //hsort.printHeap(sorted,n);
	        
	 	   //**********************************************************************//
	 	 //File related
	 	     List<List<String>> rows = Arrays.asList(
	 	    	    Arrays.asList("Randomn Insertion Sort",Integer.toString(n),Long.toString(insortTime)),
	 	    	    Arrays.asList("Randomn Heap Sort",Integer.toString(n),Long.toString(hsortTime)),
	 	    	    Arrays.asList("Randomn Merge Sort", "editor", "Node.js")
	 	    	);
	 	     File file=new File("ExecutionTimes.csv");
	 	    FileWriter csvWriter;
	 	    if(file.exists()) {
	 	    	csvWriter = new FileWriter(file,true);
	 	    	for (List<String> rowData : rows) {
	 	 	       csvWriter.append(String.join(",", rowData));
	 	 	       csvWriter.append("\n");
	 	 	   }
	 	    }else {
	 	    	 file.createNewFile();
	 	    	csvWriter = new FileWriter(file);
	 	   BufferedReader csvReader = new BufferedReader(new FileReader("ExecutionTimes.csv"));
	 	   csvWriter.append("Sorting");
	 	   csvWriter.append(",");
	 	   csvWriter.append("Input Size");
	 	   csvWriter.append(",");
	 	   csvWriter.append("Time in ms");
	 	   csvWriter.append("\n");

	 	   for (List<String> rowData : rows) {
	 	       csvWriter.append(String.join(",", rowData));
	 	       csvWriter.append("\n");
	 	   }

	 	 }
	 	   csvWriter.flush();
	 	   csvWriter.close();
		}
		}
       
	/*** End of Main Class ***/
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
	public static Integer[] createArrayForVector(int n) {
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
