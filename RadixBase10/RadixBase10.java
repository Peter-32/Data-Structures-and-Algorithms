// EfficientMedian.java
// demonstrates quick sort with median-of-three partitioning
// to run this program: C>java QuickSort2App
////////////////////////////////////////////////////////////////
// Takes about 1 second to find the median of 100 million elements; compared to ~11.7 seconds for quicksort to sort the array
// and then find the median
class RadixBase10
   {
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items
   private int max;
   private long[] array0;
   private long[] array1;
   private long[] array2;
   private long[] array3;
   private long[] array4;
   private long[] array5;
   private long[] array6;
   private long[] array7;
   private long[] array8;
   private long[] array9;
   private int nElems0 = 0;
   private int nElems1 = 0;
   private int nElems2 = 0;
   private int nElems3 = 0;
   private int nElems4 = 0;
   private int nElems5 = 0;
   private int nElems6 = 0;
   private int nElems7 = 0;
   private int nElems8 = 0;
   private int nElems9 = 0;
//--------------------------------------------------------------
   public RadixBase10(int max)          // constructor
      {
      theArray = new long[max];      // create the array
      nElems = 0;                    // no items yet
      this.max = max;
      array0 = new long[max];   // setting these to an excessive size; linked lists work better
      array1 = new long[max];
      array2 = new long[max];
      array3 = new long[max];
      array4 = new long[max];
      array5 = new long[max];
      array6 = new long[max];
      array7 = new long[max];
      array8 = new long[max];
      array9 = new long[max];
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
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  // swap two elements
      {
      long temp = theArray[dex1];        // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
      }  // end swap()
   public void radixSort()
   {
   		int divideBy = 1;
   		while(true)
   		{


   		for(int i=0; i<nElems; i++)
   		{
   			switch((int)( ( (int)(theArray[i]/divideBy) )%10 ))   // fill the 10 arrays
   			{
   				case 0:
   					array0[nElems0] = theArray[i];
   					nElems0++;
   					break;
   				case 1:
   					array1[nElems1] = theArray[i];
   					nElems1++;
   					break;
   				case 2:
   					array2[nElems2] = theArray[i];
   					nElems2++;
   					break;
   				case 3:
   					array3[nElems3] = theArray[i];
   					nElems3++;
   					break;
   				case 4:
   					array4[nElems4] = theArray[i];
   					nElems4++;
   					break;
   				case 5:
   					array5[nElems5] = theArray[i];
   					nElems5++;
   					break;
   				case 6:
   					array6[nElems6] = theArray[i];
   					nElems6++;
   					break;
   				case 7:
   					array7[nElems7] = theArray[i];
   					nElems7++;
   					break;
   				case 8:
   					array8[nElems8] = theArray[i];
   					nElems8++;
   					break;
   				case 9:
   					array9[nElems9] = theArray[i];
   					nElems9++;  
   					break;					   					   					   					   				
   			}
   		} // END OF "for" loop
   			if(nElems0==nElems)  // EXIT CONDITION; all numbers too small
   				return;
   			
   			int j = 0; // refill the original array in order of 0 to 9

   			for(int k=0; k<nElems0; k++)
   			{
   				theArray[j++] = array0[k];
   			}
   			for(int k=0; k<nElems1; k++)
   			{
   				theArray[j++] = array1[k];
   			}
   			for(int k=0; k<nElems2; k++)
   			{
   				theArray[j++] = array2[k];
   			}
   			for(int k=0; k<nElems3; k++)
   			{
   				theArray[j++] = array3[k];
   			}
   			for(int k=0; k<nElems4; k++)
   			{
   				theArray[j++] = array4[k];
   			}
   			for(int k=0; k<nElems5; k++)
   			{
   				theArray[j++] = array5[k];
   			}
   			for(int k=0; k<nElems6; k++)
   			{
   				theArray[j++] = array6[k];
   			}
   			for(int k=0; k<nElems7; k++)
   			{
   				theArray[j++] = array7[k];
   			}
   			for(int k=0; k<nElems8; k++)
   			{
   				theArray[j++] = array8[k];
   			}
   			for(int k=0; k<nElems9; k++)
   			{
   				theArray[j++] = array9[k];
   			}   			   			
   			
   			nElems0 = 0;
   			nElems1 = 0;
   			nElems2 = 0;
   			nElems3 = 0;
   			nElems4 = 0;
   			nElems5 = 0;
   			nElems6 = 0;
   			nElems7 = 0;
   			nElems8 = 0;
   			nElems9 = 0;   		

			divideBy*=10;  // divide by a larger number for next digit
   	} // end of "while" loop
   }
//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class RadixBase10App
   {
   public static void main(String[] args)
      {
      int maxSize = 1000000;             // array size
      RadixBase10 arr;                 // reference to array
      arr = new RadixBase10(maxSize);  // create the array

      for(int j=0; j<maxSize; j++)  // fill array with
         {                          // random numbers
         long n = (int)(java.lang.Math.random()*maxSize);
         arr.insert(n);
         }
      //arr.display();                // display items
      long startTime = System.currentTimeMillis();
      arr.radixSort();
      long endTime = System.currentTimeMillis();
      System.out.println("milliseconds " + (endTime - startTime));
      //arr.display();                // display items
      // runs in 26 milliseconds
      }  // end main()
   }  // end class QuickSort2App
////////////////////////////////////////////////////////////////
