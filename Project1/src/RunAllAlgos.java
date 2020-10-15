import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class RunAllAlgos {
	
	public static void runAll() throws IOException {
		InsertionSort insort=new InsertionSort();
		HeapSort hsort=new HeapSort();
		InPlaceQuickSort qsort=new InPlaceQuickSort();
		ModQuickSort mqsort=new ModQuickSort();
		MergeSort    mersort=new MergeSort();
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
			        
			 	   //****************************IN-PLACE QUick Sort*************************************//
			 	     long qsortTime=qsort.inPlaceQuickSort(arr, 0, arr.length-1);
			 	    //****************************Mod  Quick Sort*************************************//
			 	        
		                long mqsortTime=mqsort.modQuickSort(arr);
		            
		                
		                //***************Merge Sort**********************//
		                long start = System.currentTimeMillis();
		                arr=mersort.partition(arr);
		                long stop = System.currentTimeMillis();
				 	      long mersortTime = stop - start;
		                
		                //*******************************************************************//
			 	     //File related
			 	     List<List<String>> rows = Arrays.asList(
			 	    	    Arrays.asList("Randomn Insertion Sort",Integer.toString(n),Long.toString(insortTime)),
			 	    	    Arrays.asList("Randomn Heap Sort",Integer.toString(n),Long.toString(hsortTime)),
			 	    	    Arrays.asList("Randomn Quick Sort", Integer.toString(n),Long.toString(qsortTime)),
			 	    	   Arrays.asList("Randomn Modified Quick Sort", Integer.toString(n),Long.toString(mqsortTime)),
			 	    	  Arrays.asList("Random Merge Sort", Integer.toString(n),Long.toString(mersortTime))
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
				
				
				
						
						//2.On Sorted Array
						
						for(int i=0;i<inputsize.length;i++) {
							 //Creating a random Integer Array
							int n=inputsize[i];
					        int[] arr=createArray(n);
					        Arrays.sort(arr);
					        Integer[] arr2=createArrayForVector(n);
					        Arrays.sort(arr2);
					        
					        
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
					        
					 	   //****************************IN-PLACE QUick Sort*************************************//
					 	     long qsortTime=qsort.inPlaceQuickSort(arr, 0, arr.length-1);
					 	    //****************************Mod  Quick Sort*************************************//
					 	   
				                long mqsortTime=mqsort.modQuickSort(arr);
				           
				                //*******************Merge Sort ********************************//
					 	    
				               
				               
				                long start = System.currentTimeMillis();
				                arr=mersort.partition(arr);
				                long stop = System.currentTimeMillis();
						 	      long mersortTime = stop - start;
						 	     //*********************************************************//
				                //File related
					 	     List<List<String>> rows = Arrays.asList(
					 	    	    Arrays.asList("Sorted Insertion Sort",Integer.toString(n),Long.toString(insortTime)),
					 	    	    Arrays.asList("Sorted Heap Sort",Integer.toString(n),Long.toString(hsortTime)),
					 	    	    Arrays.asList("Sorted Quick Sort", Integer.toString(n),Long.toString(qsortTime)),
					 	    	   Arrays.asList("Sorted Modified Quick Sort", Integer.toString(n),Long.toString(mqsortTime)),
					 	    	  Arrays.asList("Sorted Merge Sort", Integer.toString(n),Long.toString(mersortTime))
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
						//3.On Reverse sorted Array
						
						for(int i=0;i<inputsize.length;i++) {
							 //Creating a random Integer Array
							int n=inputsize[i];
					        int[] arr=createArray(n);
					        Arrays.sort(arr);
					        arr=reverse(arr);
					        Integer[] arr2=createArrayForVector(n);
					        Arrays.sort(arr2,Collections.reverseOrder());
					        
					        
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
					        
					 	   //****************************IN-PLACE QUick Sort*************************************//
					 	     long qsortTime=qsort.inPlaceQuickSort(arr, 0, arr.length-1);
					 	    //****************************Mod  Quick Sort*************************************//
					 	   
				            
				                long mqsortTime=mqsort.modQuickSort(arr);
				             
				                //********************Merge Sort*********************************//
				               
				                long start = System.currentTimeMillis();
				                arr=mersort.partition(arr);
				                long stop = System.currentTimeMillis();
						 	      long mersortTime = stop - start;
				                //*******************************************************************//
				                
				                //File related
					 	     List<List<String>> rows = Arrays.asList(
					 	    	    Arrays.asList("Reverse Insertion Sort",Integer.toString(n),Long.toString(insortTime)),
					 	    	    Arrays.asList("Reverse Heap Sort",Integer.toString(n),Long.toString(hsortTime)),
					 	    	    Arrays.asList("Reverse Quick Sort", Integer.toString(n),Long.toString(qsortTime)),
					 	    	   Arrays.asList("Reverse Modified Quick Sort", Integer.toString(n),Long.toString(mqsortTime)),
					 	    	  Arrays.asList("Reverse Merge Sort", Integer.toString(n),Long.toString(mersortTime))	
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
	public static int[] createArray(int n) {
		// TODO Auto-generated method stub
		int max=n;
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
		int max=n;
		Random rand=new Random();
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=rand.nextInt(max);
			//System.out.print(arr[i]+" ");
		}
		return arr;
	}
	public static int[] reverse(int[] input) {
		int last = input.length - 1; 
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
			int temp = input[i]; input[i] = input[last - i];
			input[last - i] = temp; }
	return input;	
	}
}
