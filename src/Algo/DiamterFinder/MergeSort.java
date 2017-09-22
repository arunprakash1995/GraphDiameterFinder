package Algo.DiamterFinder;

public class MergeSort {
	
	/** This is the method for implementing Merge Sort Algorithm for integer type array. 
	 * @param array
	 * @param LowerIndex
	 * @param middleIndex
	 * @param upperIndex
	 */
	public static void mergeSubArrays(int[] array,int lowerIndex,int middleIndex,int upperIndex){
		
		int n1= middleIndex-lowerIndex+1;  // Number of elements in the left sub array
		int n2= upperIndex-middleIndex;   // Number of elements in the right sub array
		int  i=0, j=0;     // Initializing the Indices of left and right sub array
		int k=lowerIndex;  //Initialzing the index of main array to lower Index
		
		int[] leftSubArray = new int[n1];
		int[] rightSubArray = new int[n2];
		
		//Initializing the left sub-array
		for(i=0;i<n1;++i){
			leftSubArray[i]=array[lowerIndex+i];
		}
		
		//Initializing the right sub-array
		for(i=0;i<n2;++i){
			rightSubArray[i]=array[middleIndex+1+i];
		}
		
		i=0; j=0;
		while(i<n1 & j<n2){
			//checking if element of left-sub array is less than right sub-array
			if(leftSubArray[i]<=rightSubArray[j]){
				array[k]=leftSubArray[i];  //copy element of left sub-array to main array
				++i;
			}
			else{
				array[k]=rightSubArray[j];  //copy element of right sub-array to main array 
				++j;
			}
			++k;
		}
		
		/** Pushing the remaining elements of left Sub Array */
		
		while(i<n1){
			array[k]=leftSubArray[i];
			++i;
			++k;
		}
		
		/**Pushing the remaining elements of right Sub Array */
		
		while(j<n2){
			array[k]=rightSubArray[j];
			++j;
			++k;
		}
	}
	
	/** This is the method for implementing Merge Sort Algorithm for Generics.
	 * 
	 * @param array
	 * @param lowerIndex
	 * @param middleIndex
	 * @param upperIndex
	 */
	 public static<T extends Comparable<T>> void mergeSubArraysGenerics(T[] array,int lowerIndex,int middleIndex,int upperIndex){
		
		Object[] temp = new Object[upperIndex-lowerIndex+1];
	 
		int i=lowerIndex;       //Initializing the start index of left sub-array
		int j=middleIndex+1;    //Initializing the start index of right sub-array
		int k=0;                //Initializing the index value of temp array
		
		while(i<=middleIndex && j<=upperIndex){
				if (array[i].compareTo(array[j])<=0){  //checking if element of left-sub array is less than right sub-array
					temp[k] = array[i++];       //Copying the element of left sub-array to temp variable
				}
			    else{                          // element of right-sub array is less than left sub-array
				temp[k] = array[j++];          //Copying the element of left sub-array to temp variable
			    }
			    k++;
			}
		    //Pushing the remaining elements of left sub-array if any
			if (i <= middleIndex) {
			    while (i <= middleIndex) 
				temp[k++] = array[i++];
			}
			//Pushing the remaining elements of right sub-array if any
			else {
			    while (j <= upperIndex)
				temp[k++] = array[j++];
			}
			
			//Copying the elements of ordered temp variable to main array
			for (k = 0; k < temp.length; k++) {
			    array[k+lowerIndex] = (T)(temp[k]); 
			}
	}	
	 
	/** This method calls the mergeSubArrays for Generics.
	 * 
	 * @param array
	 * @param lowerIndex
	 * @param upperIndex
	 */
	public static <T extends Comparable<T>> void mergeSortG(T[] array,int lowerIndex,int upperIndex){
		
		if(lowerIndex<upperIndex){
			int middleIndex = (lowerIndex+upperIndex)>>>1;
			mergeSortG(array,lowerIndex,middleIndex);
			mergeSortG(array,middleIndex+1,upperIndex);
			mergeSubArraysGenerics(array,lowerIndex,middleIndex,upperIndex);
			
		}
	}
	
	/** This method calls the method mergeSubArrays for integer type array
	 * @param array
	 * @param lowerIndex
	 * @param upperIndex
	 */
	public static void mergeSort(int[] array,int lowerIndex,int upperIndex){
		
		if(lowerIndex<upperIndex){
			int middleIndex = (lowerIndex+upperIndex)>>>1;
			mergeSort(array,lowerIndex,middleIndex);
			mergeSort(array,middleIndex+1,upperIndex);
			mergeSubArrays(array,lowerIndex,middleIndex,upperIndex);
			
		}
	}

	
	/** This is the method for printing array integers
	 * 
	 * @param array
	 */
	public static void print(int[] array){
		for(int element:array){
			System.out.print(element+" ");
		}
	}
	
	/** This is the method for printint generic array
	 * 
	 * @param array
	 */
	public static<T> void printG(T[] array){
		for(T element:array){
			System.out.print(element+" ");
		}
	}
	
	/** This method implements Bubble Sort algorithm for integer type array. 
	 *  Bubble sort is the O(n*n) algorithm chosen for comparison
	 *  
	 * @param array
	 */
	public static void bubbleSort(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
	
	/** This method implements Bubble sort algorithm for generic array.
	 * Bubble sort is the O(n*n) algorithm chosen for comparison
	 * 
	 * @param array
	 */
	public static<T extends Comparable<T>> void bubbleSort(T[] array)
    {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j].compareTo(array[j+1])>=0)
                {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
	
	
	public static void main(String[] args){
		
		int size = 1000000;     //Size of array
		int count = 1;
		while(size<=16000000){  // Iterates upto size of 16M
		int[] array = new int[size] ;
		for(int i=1;i<=1000000; ++i){
			array[i-1]=i;
		}
		Shuffle.shuffle(array);   // Shuffling the array
		Integer[] int_array= new Integer[array.length];
		int i=0;
		for(int element:array){
			int_array[i]= new Integer(element);
			++i;
		}
		System.out.println("Time for Merge Sorting Integer(Generic): ");
		Timer t = new Timer();
		t.start();
		mergeSortG(int_array,0,array.length-1);
		System.out.println(t.end());
		
		
		System.out.println();
		System.out.println("Time for Merge Sorting integer array: ");
		t.start();
		mergeSort(array,0,array.length-1);
		System.out.println(t.end());
		
		System.out.println("Bubble Sort");
		
		Shuffle.shuffle(int_array);
		System.out.println("Time for bubble Sorting Integer(Generic): ");
		t = new Timer();
		t.start();
		bubbleSort(int_array);
		System.out.println(t.end());
		
		System.out.println();
		System.out.println("Time for Bubble Sorting integer array: ");
		Shuffle.shuffle(array);
		t.start();
		bubbleSort(array);
		System.out.println(t.end());
		
		
		
		System.out.println("_______________________________________________");
		size+=1000000;	
	}
	
	}
}

/** Sample output : 
 * Time for Merge Sorting Integer(Generic): 
 * Time: 491 msec.
 * Memory: 74 MB / 155 MB.

 * Time for Merge Sorting int: 
 * Time: 191 msec.
 * Memory: 56 MB / 220 MB.

 * Time for bubble Sorting Integer(Generic): 
 * Time: 1190 msec.
 * Memory: 63 MB / 304 MB.

 * Time for Bubble Sorting int: 
 * Time: 281 msec.
 * Memory: 131 MB / 379 MB.

*/
