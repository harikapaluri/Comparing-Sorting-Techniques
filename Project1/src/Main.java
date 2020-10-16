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
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Main {

	public static void main(String[] args) throws IOException {
		MergeSort    mersort=new MergeSort();
		InsertionSort insort=new InsertionSort();
		HeapSort hsort=new HeapSort();
		InPlaceQuickSort qsort=new InPlaceQuickSort();
		ModQuickSort mqsort=new ModQuickSort();
		RunAllAlgos runAllAlgos=new RunAllAlgos();
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose your option 1.Run All cases all sorting algorthms with special cases 2.Choose each input size and algorithm");
		int choice=sc.nextInt();
		switch(choice) {
		
		case 1:{
			runAllAlgos.runAll();
			break;
		}
		case 2:{
			System.out.println("Choose Algo 1.Insertion 2.Heap 3.Quick Sort 4.Merge 5.Mod quick sort");
			int algoch=sc.nextInt();
			System.out.println("Enter size");
			int size=sc.nextInt();
			switch(algoch){
				case 1:{
					int[] arr=createArray(size);
					System.out.println("Insertion Sort");
					System.out.println("Input Array n = "+size);
                    print(arr);
                    System.out.println();
					long insortRandTime=insort.insertionSort(arr);
					System.out.println("Sorted");
					print(arr);
					System.out.println();
					System.out.println("Time for sorting = "+insortRandTime);
					
					
					long insortSortedTime=insort.insertionSort(arr);
					System.out.println("Time when input array is sorted = "+insortSortedTime);
					arr=reverse(arr);
					
					
					long insortReverseTime=insort.insertionSort(arr);
					System.out.println("Time when input array is reverse="+insortReverseTime);				
										//File related
			 	     List<List<String>> rows = Arrays.asList(
			 	    	    Arrays.asList("Randomn Insertion Sort",Integer.toString(size),Long.toString(insortRandTime)),
			 	    	    Arrays.asList("Sorted Insertion Sort",Integer.toString(size),Long.toString(insortSortedTime)),
			 	    	    Arrays.asList("Reverse Insertion Sort", Integer.toString(size),Long.toString(insortReverseTime))
			 	    	 
			 	    		 );
			 	    File file=new File("OneByOneExecution.csv");
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
			 	    break;
				}
case 2:{

	 Integer[] arr2=createArrayForVector(size);		
	 Vector<Integer> vector = new Vector<Integer>(Arrays.asList(arr2));
	 
	 System.out.println("Heap Sort");
		System.out.println("Input Array n = "+size);
		System.out.print("Input Array ");
		hsort.printHeap(vector, size);
	 //******Randomn Array **********//
	
 	long startTime = System.currentTimeMillis();
 	 
    vector=hsort.buildHeap(vector,size);
     System.out.print("Max Heap after building");
     hsort.printHeap(vector,size);
    Vector<Integer> randomn =hsort.heapSort(vector,size);
    //
    long stopTime = System.currentTimeMillis();
    long hsortRandTime = stopTime - startTime;
    System.out.print("Sorted Array ");
	hsort.printHeap(randomn, size);
    System.out.println("Time for sorting = "+hsortRandTime);
    //******Sorted Array **********//
			Arrays.sort(arr2);
			Vector<Integer> vector1 = new Vector<Integer>(Arrays.asList(arr2));
			
			long start2 = System.currentTimeMillis();
		     vector1=hsort.buildHeap(vector1,size);
		    
		    Vector<Integer> sorted =hsort.heapSort(vector1,size);
		    long stop2 = System.currentTimeMillis();
		    long hsortSortTime = stop2 - start2;
		    System.out.println("Time when input array is sorted = "+hsortSortTime);
		  //******Reverse Array **********//
			Arrays.sort(arr2,Collections.reverseOrder());
			Vector<Integer> vector3 = new Vector<Integer>(Arrays.asList(arr2));
			
			long start3 = System.currentTimeMillis();
			vector3=hsort.buildHeap(vector3,size);
		    
		    Vector<Integer> reverse =hsort.heapSort(vector3,size);
		    long stop3 = System.currentTimeMillis();
		    long hsortReverseTime = stop3 - start3;
		    System.out.println("Time when input array is  reverse = "+hsortReverseTime);
			
			//File related
List<List<String>> rows = Arrays.asList(
 Arrays.asList("Randomn Heap Sort",Integer.toString(size),Long.toString(hsortRandTime)),
 Arrays.asList("Sorted Heap Sort",Integer.toString(size),Long.toString(hsortSortTime)),
 Arrays.asList("Reverse Heap Sort", Integer.toString(size),Long.toString(hsortReverseTime))

	 );
File file=new File("OneByOneExecution.csv");
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
break;
}
case 3:{
	System.out.println("In_Place Quick Sort");
	System.out.println("Input Array n = "+size);
	System.out.println("Input Array ");
	int[] arr=createArray(size);
	print(arr);
	System.out.println();
	long qsortRandTime=qsort.inPlaceQuickSort(arr, 0, size-1);
	System.out.print("Sorted ");
	print(arr);
	System.out.println();
	System.out.println("Time for sorting = "+qsortRandTime);
	
	long qsortSortTime=qsort.inPlaceQuickSort(arr, 0, size-1);
	System.out.println("Time when input array is sorted = "+qsortSortTime);
	arr=reverse(arr);
	long qsortReverseTime=qsort.inPlaceQuickSort(arr, 0, size-1);
	System.out.println("Time when input array is reverse = "+qsortReverseTime);
					
						//File related
	     List<List<String>> rows = Arrays.asList(
	    	    Arrays.asList("Randomn Quick Sort",Integer.toString(size),Long.toString(qsortRandTime)),
	    	    Arrays.asList("Sorted Quick Sort",Integer.toString(size),Long.toString(qsortSortTime)),
	    	    Arrays.asList("Reverse Quick Sort", Integer.toString(size),Long.toString(qsortReverseTime))
	    	 
	    		 );
	     File file=new File("OneByOneExecution.csv");
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
	    break;
}
case 4:{
	System.out.println("Merge Sort");
	System.out.println("Input Array n = "+size);
	System.out.println("Input Array ");
	 int[] arr=createArray(size);
	 print(arr);
	 System.out.println(" ");
	 int[] arr1=Arrays.copyOf(arr,size);
	
	 	 int[] arr2=Arrays.copyOf(arr,size);
	 	 
	 //******Randomn Array **********//
	 long startTime = System.currentTimeMillis();
	 arr=mersort.partition(arr);
	
	
   long stopTime = System.currentTimeMillis();
   long mersortRandTime = stopTime - startTime;
   System.out.println("Sorted ");
   print(arr);
   System.out.println(" ");
   System.out.println("Time for sorting = "+mersortRandTime);
   //******Sorted Array **********//
			Arrays.sort(arr1);
			
			long start2 = System.currentTimeMillis();
			 arr1=mersort.partition(arr1);
		   
		  
		    long stop2 = System.currentTimeMillis();
		    long mersortSortTime = stop2 - start2;
		    System.out.println("Time when input array is sorted = "+mersortSortTime);
		  //******Reverse Array **********//
		    Arrays.sort(arr2);
			arr2=reverse(arr2);
			long start3 = System.currentTimeMillis();
			 arr2=mersort.partition(arr2);
		    long stop3 = System.currentTimeMillis();
		    long mersortReverseTime = stop3 - start3;
		    System.out.println("Time when input array is reverse = "+mersortReverseTime);
			
			//File related
List<List<String>> rows = Arrays.asList(
Arrays.asList("Randomn Merge Sort",Integer.toString(size),Long.toString(mersortRandTime)),
Arrays.asList("Sorted Merge Sort",Integer.toString(size),Long.toString(mersortSortTime)),
Arrays.asList("Reverse Merge Sort", Integer.toString(size),Long.toString(mersortReverseTime))

	 );
File file=new File("OneByOneExecution.csv");
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
break;
	
	
	
}
case 5:{
	int[] arr=createArray(size);
	System.out.println("Modified Quick Sort");
	System.out.println("Input Array n = "+size);
	System.out.println("Input Array  = ");
    print(arr);
    System.out.println("");
	if(size<=15) {
		long elt=insort.insertionSort(arr);
		System.out.println("Sorted array  = ");
		print(arr);
		System.out.println("");
		System.out.println("Since input size is less than 15 performed insertion sort in  "+elt+" ms");
	}
	else{
		long mqsortRandTime=mqsort.modQuickSort(arr);
		System.out.println("Sorted array  = ");
		print(arr);
		System.out.println("");
		 System.out.println("Time for sorting = "+mqsortRandTime);
	Arrays.sort(arr);
	long mqsortSortTime=mqsort.modQuickSort(arr);
	 System.out.println("Time when input array is  sorted = "+mqsortSortTime);
	arr=reverse(arr);
	long mqsortReverseTime=mqsort.modQuickSort(arr);
	System.out.println("Time when input array is  reverse = "+mqsortReverseTime);
	
	//File related
    List<List<String>> rows = Arrays.asList(
   	    Arrays.asList("Randomn Modified Quick Sort",Integer.toString(size),Long.toString(mqsortRandTime)),
   	    Arrays.asList("Sorted Modified Quick Sort",Integer.toString(size),Long.toString(mqsortSortTime)),
   	    Arrays.asList("Reverse Modified Quick Sort", Integer.toString(size),Long.toString(mqsortReverseTime))
   	 
   		 );
    File file=new File("OneByOneExecution.csv");
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
					
		
	 break;
}
			}
		
			System.out.println("Please view OneByOneExecution.csv in your file folder for all the run times");
		break;
		}
		}
		}
       
	
	public static int[] createArray(int n) {
		//Creating an array of integer with random values
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
		
		int max=n;
		Random rand=new Random();
		Integer[] arr=new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=rand.nextInt(max);
			//System.out.print(arr[i]+" ");
		}
		return arr;
	}
	//To reverse an array
	public static int[] reverse(int[] input) {
		int last = input.length - 1; 
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
			int temp = input[i]; input[i] = input[last - i];
			input[last - i] = temp; }
	return input;	
	}

	public static void print(int[] input) {
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
	}
	
}
