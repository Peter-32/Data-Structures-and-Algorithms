// EfficientMedian.java
// demonstrates quick sort with median-of-three partitioning
// to run this program: C>java QuickSort2App
////////////////////////////////////////////////////////////////
// Takes about 1 second to find the median of 100 million elements; compared to ~11.7 seconds for quicksort to sort the array
// and then find the median
class ArrayIns
   {
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
      {
      theArray = new long[max];      // create the array
      nElems = 0;                    // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      System.out.print("A=");
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j] + "\n");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public double quickMedian()
   {
	  if(nElems==0)   // 0 length array
	  	return -1;

      int medianIdx1 = (nElems - 1) / 2;   // even numbers have two different median indices
      int medianIdx2 = (nElems/2);         // odd numbers have the same.
      return recQuickMedian(0, nElems-1, medianIdx1, medianIdx2, false, false);
   }
//--------------------------------------------------------------
   public double recQuickMedian(int left, int right, int medianIdx1, int medianIdx2, 
   	Boolean medianIdx1Found, Boolean medianIdx2Found)
      {
      int size = right-left+1;
      if(size <= 3)      // manual sort if small
      {
		manualSort(left, right);
		return ((double) (theArray[medianIdx1] + theArray[medianIdx2])) / 2.0;
      }                  
         
      else                           // quicksort if large
         {
         long median = medianOf3(left, right);
         int partition = partitionIt(left, right, median);
         if(medianIdx1==partition)        // set boolean
         {
         	medianIdx1Found = true;
         }
         if(medianIdx2==partition)        // set boolean
         {
         	medianIdx2Found = true;
         }
         if(medianIdx1Found&& medianIdx2Found)  //exit case
         {
         	return ((double) (theArray[medianIdx1] + theArray[medianIdx2])) / 2.0;
         }
         if(partition<=medianIdx1)
         {
         	return recQuickMedian(partition+1, right, medianIdx1, medianIdx2,
         	 medianIdx1Found, medianIdx2Found);
         } else
         {
         	return recQuickMedian(left, partition-1, medianIdx1, medianIdx2,
         	 medianIdx1Found, medianIdx2Found);
         }

         
         
         }
      }  // end recQuickMedian()
//--------------------------------------------------------------
   public long medianOf3(int left, int right)
      {
      int center = (left+right)/2;
                                         // order left & center
      if( theArray[left] > theArray[center] )
         swap(left, center);
                                         // order left & right
      if( theArray[left] > theArray[right] )
         swap(left, right);
                                         // order center & right
      if( theArray[center] > theArray[right] )
         swap(center, right);

      swap(center, right-1);             // put pivot on right
      return theArray[right-1];          // return median value
      }  // end medianOf3()
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  // swap two elements
      {
      long temp = theArray[dex1];        // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
      }  // end swap(
//--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot)
       {
       int leftPtr = left;             // right of first elem
       int rightPtr = right - 1;       // left of pivot

       while(true)
          {
          while( theArray[++leftPtr] < pivot )  // find bigger
             ;                                  //    (nop)
          while( theArray[--rightPtr] > pivot ) // find smaller
             ;                                  //    (nop)
          if(leftPtr >= rightPtr)      // if pointers cross,
             break;                    //    partition done
          else                         // not crossed, so
             swap(leftPtr, rightPtr);  // swap elements
          }  // end while(true)
       swap(leftPtr, right-1);         // restore pivot
       return leftPtr;                 // return pivot location
       }  // end partitionIt()
//--------------------------------------------------------------
   public void manualSort(int left, int right)
      {
      int size = right-left+1;
      if(size <= 1)
         return;         // no sort necessary
      if(size == 2)
         {               // 2-sort left and right
         if( theArray[left] > theArray[right] )
            swap(left, right);
         return;
         }
      else               // size is 3
         {               // 3-sort left, center, & right
         if( theArray[left] > theArray[right-1] )
            swap(left, right-1);                // left, center
         if( theArray[left] > theArray[right] )
            swap(left, right);                  // left, right
         if( theArray[right-1] > theArray[right] )
            swap(right-1, right);               // center, right
         }
      }  // end manualSort()
//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class QuickMedianApp
   {
   public static void main(String[] args)
      {
      int maxSize = 201;             // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

      for(int j=0; j<maxSize; j++)  // fill array with
         {                          // random numbers
         long n = (int)(java.lang.Math.random()*maxSize);
         arr.insert(n);
         }
      arr.display();                // display items
      long startTime = System.currentTimeMillis();
      System.out.println("Median is " + arr.quickMedian());              // quicksort them
      long endTime = System.currentTimeMillis();
      System.out.println("milliseconds required to find the median of " + maxSize + " million numbers " + (endTime - startTime));
      // takes 986 milliseconds compared to ~11.7 seconds to sort the 100,000,000 element array.
      }  // end main()
   }  // end class QuickSort2App
////////////////////////////////////////////////////////////////
