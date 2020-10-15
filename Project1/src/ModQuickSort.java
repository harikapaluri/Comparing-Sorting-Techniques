

import java.io.IOException;
import java.util.*;


public class ModQuickSort 
{
            //printing the sorted array for each input size
		/*
		 * for(int i=0;i<inputsize.length;i++) { System.out.println();
		 * System.out.println(); System.out.println("For input size:" +inputsize[i]);
		 * for(int j=arr.length-1;j>=0;j--) { System.out.print(arr[j]+" "); } }
		 */
    
    public static long modQuickSort(int arr[])
    {
        long startTime = System.currentTimeMillis();
        quicksortmed( arr, 0, arr.length - 1 );
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        
        return elapsedTime;
    }
    

    private static final int CUTOFF = 15;
    private static void quicksortmed( int[] a, int first, int last ) 
    {
        if( first + CUTOFF < last )
            insertionSort( a, first, last );
        else 
        {
	// Sort low, middle, high
	int middle = ( first + last ) / 2;
	if( a[ middle ]> a[ first ] )
                        swap( a, first, middle );
	if( a[ last ]> a[ first ]  )
                        swap( a, first, last );
	if( a[last ]> a[ middle ]  )
                        swap( a, middle, last );

	// Place pivot at position high - 1
	swap( a, middle, last - 1 );
	int pivot = a[ last - 1 ];

	int i, j;
	for( i = first, j = last - 1; ; ) 
                 {
                    while( a[ ++i ]> pivot  )
		;
                    while( pivot> a[ --j ]  )
		;
                    if( i >= j )
                        break;
	ModQuickSort.swap( a, i, j );
	}

	swap( a, i, last - 1 );

	quicksortmed( a, first, i - 1 );
	quicksortmed( a, i + 1, last );
	}
        }

        private static void insertionSort( int [ ] a, int low, int high ) 
        {
            for (int p = low + 1; p <= high; p++) 
            {
                int tmp = a[p];
                int j;
                for (j = p; j > low && tmp>a[j - 1]; j--)
                        a[j] = a[j - 1];
                        a[j] = tmp;
            }
        }

        public static final void swap( int [ ] a, int index1, int index2 ) 
        {
	int tmp = a[ index1 ];
                  a[ index1 ] = a[ index2 ];
	a[ index2 ] = tmp;
        }

}
