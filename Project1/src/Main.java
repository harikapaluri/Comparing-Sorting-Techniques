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
					long insortRandTime=insort.insertionSort(arr);
					Arrays.sort(arr);
					
					print(arr);
					long insortSortedTime=insort.insertionSort(arr);
					arr=reverse(arr);
					
					//print(arr);
					long insortReverseTime=insort.insertionSort(arr);
									
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
	 //******Randomn Array **********//
 	long startTime = System.currentTimeMillis();
     hsort.buildHeap(vector,size);
     //hsort.printHeap(vector,n);
    Vector<Integer> randomn =hsort.heapSort(vector,size);
    long stopTime = System.currentTimeMillis();
    long hsortRandTime = stopTime - startTime;
    //******Sorted Array **********//
			Arrays.sort(arr2);
			Vector<Integer> vector1 = new Vector<Integer>(Arrays.asList(arr2));
			long start2 = System.currentTimeMillis();
		     hsort.buildHeap(vector1,size);
		     //hsort.printHeap(vector,n);
		    Vector<Integer> sorted =hsort.heapSort(vector,size);
		    long stop2 = System.currentTimeMillis();
		    long hsortSortTime = start2 - stop2;
		  //******Reverse Array **********//
			Arrays.sort(arr2,Collections.reverseOrder());
			Vector<Integer> vector3 = new Vector<Integer>(Arrays.asList(arr2));
			long start3 = System.currentTimeMillis();
		     hsort.buildHeap(vector3,size);
		     //hsort.printHeap(vector,n);
		    Vector<Integer> reverse =hsort.heapSort(vector,size);
		    long stop3 = System.currentTimeMillis();
		    long hsortReverseTime = start3 - stop3;

			
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
	int[] arr=createArray(size);
	long qsortRandTime=qsort.inPlaceQuickSort(arr, 0, size-1);
	Arrays.sort(arr);
	long qsortSortTime=qsort.inPlaceQuickSort(arr, 0, size-1);
	arr=reverse(arr);
	long qsortReverseTime=qsort.inPlaceQuickSort(arr, 0, size-1);
					
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
	
}
case 5:{
	int[] arr=createArray(size);
	if(size==15) {
		long elt=insort.insertionSort(arr);
		System.out.println("Since input size is less than 15 performed insertion sort in  "+elt+"ms");
	}
	else{long mqsortRandTime=mqsort.modQuickSort(arr);
	Arrays.sort(arr);
	long mqsortSortTime=mqsort.modQuickSort(arr);
	arr=reverse(arr);
	long mqsortReverseTime=mqsort.modQuickSort(arr);
	
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
		
		}
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
