// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
   {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
      iData = id;                 // initialize data
      dData = dd;                 // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////
class CircularList
   {
   private Link current;            // ref to first link on list
   private int nItems=0;

// -------------------------------------------------------------
   public CircularList()              // constructor
      {
      current = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (current==null);
      }
// -------------------------------------------------------------                                 t
   public void insertNextAndStep(int id, double dd)
      {                           // make new link
      Link newLink = new Link(id, dd);
      if( isEmpty() ) // handle if empty
      {
         current = newLink;
         current.next = newLink;
      }
      newLink.next = current.next;  // newLink --> current.next
      current.next = newLink;       // current --> newLink
      current=current.next;      
      nItems++;
      }
// -------------------------------------------------------------
   public Link deleteNextAndStep()      // deletes next item
      {                           // (assumes list not empty)
      Link temp;          // save reference to link

      if( isEmpty() )   // handle empty
         return null;
      nItems--;            // going to remove an item
      if( current==current.next )  // handle 1 element
      {
         temp=current;
         current=null;
         return temp;
      }
      temp=current.next;
      current.next = current.next.next;         // delete it: first-->old next
      current=current.next;
      return temp;                // return deleted link
      }
// -------------------------------------------------------------      
   public Link deleteNext()      // deletes next item
      {                           // (assumes list not empty)
      Link temp;          // save reference to link

      if( isEmpty() )   // handle empty
         return null;
      nItems--;            // going to remove an item
      if( current==current.next )  // handle 1 element
      {
         temp=current;
         current=null;
         return temp;
      }
      temp=current.next;
      current.next = current.next.next;         // delete it: first-->old next
      return temp;                // return deleted link
      }      
// -------------------------------------------------------------
   public Link deleteIdAndStep(int id)      // deletes next item
      {                           // (assumes list not empty)
      Link temp;          // save reference to link


      if( isEmpty() )   // handle empty
      {
         return null;
      }     
      if( current==current.next && id==current.iData )  // handle 1 element if it matches
      {
         temp=current;

         current=null;
         nItems--;
         return temp;   
      }
      for(int i=0; i<nItems; i++)  // loop for the # of items in the list
      {
         if(current.next.iData==id)
         {
            System.out.println(nItems);            
            temp=current.next;        // going to remove this
            current.next = current.next.next;         // delete it: first-->old next
            current=current.next;        // increment one
            nItems--;
            return temp;                // return deleted link
         }
         current=current.next;
      }
      return null;    // couldn't find it
      }
// -------------------------------------------------------------
   public Link searchId(int id)      // deletes next item
      {                           // (assumes list not empty)

      for(int i=0; i<nItems; i++)  // loop for the # of items in the list
      {
         if(current.next.iData==id)
         {
            current=current.next;        // increment to this Id
            return current;                // return deleted link
         }
         current=current.next;         
      }
      return null;    // couldn't find it
      }
// -------------------------------------------------------------      
   public void displayCurrent()
      {
      System.out.print("Current List Item: ");
      current.displayLink();
      System.out.println("");
      }
// -------------------------------------------------------------
   public void step()
   {
      if(current==null)
         return;
      current=current.next;
   }
// -------------------------------------------------------------      
   public void displayAll()
   {
      Link temp = current;
      for(int i=0; i<nItems; i++)
      {
         System.out.print("Current List Items: ");
         temp.next.displayLink();
         temp=temp.next;
         System.out.println("");
      }
   }
// -------------------------------------------------------------      
   }  // end class LinkList
class CircularListQueue
   {
   private CircularList circularList;
//--------------------------------------------------------------
   public CircularListQueue()                // constructor
      { circularList = new CircularList(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return circularList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(int i, double j)        // insert, rear of queue
      { circularList.insertNextAndStep(i,j); }
//--------------------------------------------------------------
   public Link remove()              // remove, front of queue
      {  return circularList.deleteNext();  }
//--------------------------------------------------------------
   public void displayQueue()
      {
      circularList.displayAll();
      }
//--------------------------------------------------------------
   }  // end class LinkQueue
// -------------------------------------------------------------      
class CircularListQueueApp
{

   public static void main(String[] args)
   {
      CircularListQueue circularListQueue = new CircularListQueue();
      circularListQueue.insert(1,1.00);
      circularListQueue.insert(2,2.00);
      circularListQueue.insert(3,3.00);
      circularListQueue.insert(4,4.00);
      circularListQueue.insert(5,5.00);
      circularListQueue.insert(6,6.00);
      circularListQueue.displayQueue();
      while( !circularListQueue.isEmpty() )
      {
         System.out.print("Removed: ");
         circularListQueue.remove().displayLink();
         System.out.println("");
         circularListQueue.displayQueue();         
      }
      circularListQueue.displayQueue();


      // CircularList circularList = new CircularList();
      // circularList.insertNextAndStep(1, 1.00);
      // circularList.insertNextAndStep(2, 2.00);
      // circularList.insertNextAndStep(3, 3.00);
      // circularList.insertNextAndStep(4, 4.00);
      // circularList.insertNextAndStep(5, 5.00);
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();      
      // System.out.println("Deleted: " + circularList.deleteNextAndStep().iData);
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();                  
      // System.out.print("Search for id=3; Deleted: ");
      // System.out.println(circularList.deleteIdAndStep(3).iData);
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();  
      // circularList.displayCurrent();
      // circularList.step();
      // circularList.displayCurrent();
      // System.out.println("Searching for id=2; found: " + circularList.searchId(2).iData);
      // circularList.displayCurrent();
      // circularList.step();        
      // circularList.displayCurrent();
      // circularList.step();        
      // circularList.displayCurrent();
      // circularList.step();        
      // circularList.displayCurrent();
      // circularList.step();        
      // circularList.displayCurrent();
      // circularList.step();                          
      // System.out.println("Searching for id=1; found: " + circularList.searchId(1).iData);
      // circularList.displayCurrent();
   }
}
