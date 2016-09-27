class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void display()
   {
      int nextIdx;
      if(nItems!=0)     // not empty
      {
         for(int i=0; i<nItems; i++)   // print each element
         {
            if(front+i >= maxSize)     // deal with wrap arrounds
               nextIdx=front+i-maxSize;
            else                       // if no wrap around, do this
               nextIdx=front+i;
            System.out.print(queArray[nextIdx]);
            System.out.print(" ");
         }
      }
      System.out.println("");
   }
//--------------------------------------------------------------      
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////

public class Simulation
{
   private Queue line1 = new Queue(1000);
   private Queue line2 = new Queue(1000);
   private Queue line3 = new Queue(1000);
   private Queue line4 = new Queue(1000);
   private int customersReadyToGetInLine=0;
   private long maxCustomerId = 0;
   private Queue[] sortedLines = {line1,line2,line3,line4};
   
   public Simulation()
   {
      while(true)
      {
         try {
            Thread.sleep(1000);   // each second represents 20 seconds in the simulation
         } catch (InterruptedException e) {
            e.printStackTrace();
         }  
         
         checkForCustomersReadyToGetInLine(); //randomly add customers to store ready to checkout
         allCustomersChooseALine();
         display();

         try {
            Thread.sleep(1000);   // each second represents 20 seconds in the simulation
         } catch (InterruptedException e) {
            e.printStackTrace();
         }  

         customersFinishCheckout();
         display();
      }
   }

   private void customersFinishCheckout()
   {         
      double unif1 = Math.random();
      double unif2 = Math.random();
      double unif3 = Math.random();
      double unif4 = Math.random();

      if(unif1<.6
      && !line1.isEmpty())
      {
         line1.remove();
      }
      if(unif2<.65
      && !line2.isEmpty())
      {
         line2.remove();
      }
      if(unif3<.55
      && !line3.isEmpty())
      {
         line3.remove();
      }
      if(unif4<.40
      && !line4.isEmpty())
      {
         line4.remove();
      }
   }

   private void display()
   {
      System.out.print("Line1: ");
      line1.display();
      System.out.print("Line2: ");
      line2.display();
      System.out.print("Line3: ");
      line3.display();
      System.out.print("Line4: ");
      line4.display();
   }

   private void allCustomersChooseALine()
   {
      while(customersReadyToGetInLine>0)
      {
         customersChooseALine(++maxCustomerId);
         customersReadyToGetInLine--;
      }
   }
   private void checkForCustomersReadyToGetInLine()
   {       
      double unif = Math.random();
      if(unif<.2)
      {
         customersReadyToGetInLine+=4;
      } else if(unif<.4)
      {
         customersReadyToGetInLine+=3;
      } else if(unif<.6)
      {
         customersReadyToGetInLine+=2;
      } else if(unif<.8)
      {
         customersReadyToGetInLine+=1;
      }
   }

   private void customersChooseALine(long customer)
   {       
      bubbleSortLinesBySize();
      double unif = Math.random();
      if(unif<.025 && line1.size() < 4) // randomly chooses line 1
      {
         line1.insert(customer);
      } else if(unif<.05 && line2.size() < 4) // randomly chooses line 2
      {
         line2.insert(customer);
      } else if(unif<.075 && line3.size() < 4) // randomly chooses line 3
      {
         line3.insert(customer);
      } else if(unif<.1 && line4.size() < 4) // randomly chooses line 4
      {
         line4.insert(customer);
      } else if(unif<.35) // chooses second best line
      {
         sortedLines[1].insert(customer);
      } else  // chooses the best line
      {
         sortedLines[0].insert(customer);
      }
   }


   private void bubbleSortLinesBySize()
   {
      for(int i=0; i<sortedLines.length-1; i++)
         if(sortedLines[i].size()>sortedLines[i+1].size())
            swap(i,i+1);
   }

   private void swap(int idx1, int idx2)
   {
      Queue temp = sortedLines[idx1];
      sortedLines[idx1] = sortedLines[idx2];
      sortedLines[idx2] = temp;
   }
}

class SimulationApp
{
   public static void main(String[] args)
   {
      new Simulation();
   }
}
