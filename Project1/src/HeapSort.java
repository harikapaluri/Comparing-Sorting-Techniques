import java.util.Vector;

public class HeapSort {

	
	// To heapify a subtree rooted with node i which is 
    // an index in arr[].Nn is size of heap 
    static void heapify( Vector<Integer> vector, int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && vector.get(l) > vector.get(largest)) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && vector.get(r) > vector.get(l)) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) { 
            int swap =vector.get(i); 
            vector.set(i,vector.get(largest)); 
            vector.set(largest,swap); 
  
            // Recursively heapify the affected sub-tree 
            heapify(vector, n, largest); 
        } 
    } 
    // Function to build a Max-Heap from the Array 
    static void buildHeap(Vector<Integer> vector, int n) 
    { 
        // Index of last non-leaf node 
        int startIdx = (n / 2) - 1; 
  
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = startIdx; i >= 0; i--) { 
            heapify(vector, n, i); 
        } 
    }
     static void printHeap(Vector<Integer> vector,int n) 
    { 
        //System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
        { 
        	  //System.out.print(vector.get(i) + " "); 
        }
        //System.out.println(); 
    }
    // main function to do heap sort 
static Vector<Integer> heapSort(Vector<Integer> vector, int n) 
{ 
    
    // One by one extract an element from heap 
    for (int i=n-1; i>0; i--) 
    { 
        // Move current root to end 
         int temp =vector.get(0);
         vector.set(0,vector.get(i));
         vector.set(i,temp);
          
  
        // call max heapify on the reduced heap 
        heapify(vector, i, 0); 
    } 
return vector;
    
} 
}
