# Project1

Steps to run the code:

1. Unzip the project zip file
2. The unzipped file can be run on eclipse or netbeans or any IDE.
3. Run the Main.java file
4. The program asks for the user input:
    1) Option 1 executes all the sorting algorithm with different input sizes like {1000, 2000, 3000, 5000, 10000,20000,30000,40000, 50000}. The sorting algorithm with its input          size and execution time in ms gets stored in ExecutionTimes.csv file.
    2) Option 2 asks the user to choose the algorithm and the size of the input array. The sorting algorithm with its input size and execution time in ms gets stored in                  OneByOneExecution.csv file. The choice for the algorithms are:
          	i) Insertion sort
	         ii) Heap sort
	        iii) Merge sort
	         iv) Inplace Quicksort
	          v) Modified Quicksort
5. After receiving these execution times from the respective .csv files, the graph is plotted using Python.
6. The report shows the execution results of comparing sorting algorithm with the help of line graphs.

Note: 

1. Please make sure to close the respective .csv file while running its code. If the .csv file is kept open since two process are acessing the file at the same time it will     through an exception.
2. If you want to run  the python notebook for graphs please make sure that you have generated an ExecutionTimes.csv from  by running the Main program option 1.
