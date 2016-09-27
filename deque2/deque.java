// Deque.java
// demonstrates deque
// to run this program: C>java DequeApp
////////////////////////////////////////////////////////////////
class Deque
   {
   private int maxSize;
   private long[] dequeArray;
   private int right;
   private int left;
   private int nItems;
//--------------------------------------------------------------
   public void displayRightToLeft()
   {
      int nextIdx;
      if(nItems==0)     // empty
         System.out.println("");
      else
      {
         for(int i=0; i<nItems; i++)   // print each element
         {
            if(right+i >= maxSize)     // deal with wrap arrounds
               nextIdx=right+i-maxSize;
            else                       // if no wrap around, do this
               nextIdx=right+i;
            System.out.print(dequeArray[nextIdx]);
            System.out.print(" ");
         }
      }
      System.out.println("");
   }
//--------------------------------------------------------------   
   public Deque(int s)          // constructor
      {
      maxSize = s;
      dequeArray = new long[maxSize];
      right = 0;
      left = -1;
      nItems = 0;
      }
//--------------------------------------------------------------      
   public void insertLeft(long j)   // put item at left of deque
      {
      if(left == maxSize-1)         // deal with wraparound
         left = -1;
      dequeArray[++left] = j;         // increment left and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long removeRight()         // take item from right of deque
      {
      long temp = dequeArray[right++]; // get value and incr right
      if(right == maxSize)           // deal with wraparound
         right = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------      
   public void insertRight(long j)   // put item at left of deque
      {
      if(right == 0)         // deal with wraparound
         right = maxSize;
      dequeArray[--right] = j;         // increment left and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long removeLeft()         // take item from right of deque
      {
      long temp = dequeArray[left--]; // get value and incr right
      if(left == -1)           // deal with wraparound
         left = maxSize-1;
      nItems--;                      // one less item
      return temp;
      }      
//--------------------------------------------------------------
   public boolean isEmpty()    // true if deque is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if deque is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in deque
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Deque
////////////////////////////////////////////////////////////////   
class StackX
{
   private int maxSize;
   private long[] stackArray;
   private int top;
   private Deque theDeque;
   public StackX(int s)          // constructor
      {
      maxSize = s;
      theDeque = new Deque(maxSize);
      }   
   //--------------------------------------------------------------
   public void push(long j)    // put item on top of stack
      {
      theDeque.insertLeft(j);
      }
//--------------------------------------------------------------
   public long pop()           // take item from top of stack
      {
      return theDeque.removeLeft();
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if stack is empty
      {
      return theDeque.isEmpty();
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if stack is full
      {
      return theDeque.isFull();
      }
   // public void displayRightToLeft()
   // {
   //    theDeque.displayRightToLeft();
   // }
      
}   
////////////////////////////////////////////////////////////////
class DequeApp
   {
   public static void main(String[] args)
      {
      //Deque theDeque = new Deque(5);  // deque holds 5 items
      StackX theStackX = new StackX(5);

      theStackX.push(10);
      theStackX.push(20);
      theStackX.push(30);
      theStackX.push(40);
      //theStackX.displayRightToLeft();     


      while( !theStackX.isEmpty() )     // until it's empty,
         {                             // delete item from stack
         long value = theStackX.pop();
         System.out.print(value);      // display it
         System.out.print(" ");
         }  // end while
      System.out.println("");



      // theDeque.insertLeft(10);            // insert 4 items
      // theDeque.insertLeft(20);
      // theDeque.insertLeft(30);
      // theDeque.insertLeft(40);
      // theDeque.displayRightToLeft();

      // theDeque.removeRight();              // remove 3 items
      // theDeque.removeRight();              //    (10, 20, 30)
      // theDeque.removeLeft();
      // theDeque.displayRightToLeft();

      // theDeque.insertRight(10);            // insert 4 items
      // theDeque.insertRight(20);
      // theDeque.insertRight(30);
      // theDeque.insertRight(40);
      // theDeque.removeRight();  
      // theDeque.removeRight();  
      // theDeque.removeRight();  
      // theDeque.removeRight();  
      // theDeque.insertRight(10);            // insert 4 items
      // theDeque.insertRight(20);
      // theDeque.insertRight(30);
      // theDeque.insertRight(40);      
      // theDeque.displayRightToLeft();  



      }  // end main()
   }  // end class DequeApp
////////////////////////////////////////////////////////////////
