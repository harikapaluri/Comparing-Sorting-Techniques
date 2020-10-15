
public class InsertionSort {

	

	public long insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		for(int i=1;i<arr.length;i++) {
			
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      //System.out.println("elapsed"+elapsedTime);
	      //System.out.print("---Sorted---");
		//for(int i=0;i<arr.length;i++) {
			//System.out.print(arr[i]+" ");
		//}
	return elapsedTime;
	}

	

}
