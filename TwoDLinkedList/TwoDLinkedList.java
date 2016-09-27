// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
   {
   public double value;           // data item
   public Link right;              // next link in list
   public Link down;
// -------------------------------------------------------------
   public Link(double value) // constructor
   {
      String str = String.format("%1.2f", value);
      this.value = Double.valueOf(str);
   }                           //  set to null)
// -------------------------------------------------------------
   public void set(double value)
   {
      String str = String.format("%1.1f", value);
      this.value = Double.valueOf(str);
   }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
   {
      System.out.print(value + " ");
   }
   }  // end class Link
////////////////////////////////////////////////////////////////
public class TwoDLinkedList
   {
   private Link first;            // ref to first link on list
// -------------------------------------------------------------
   public TwoDLinkedList(int width, int height)              // constructor
   {
      Link[][] linkArray = new Link[height+1][width+1]; // extra length for null values
      for(int j=0; j<linkArray.length-1; j++)
      {
         for(int i=0; i<linkArray[0].length-1; i++)
         {
            linkArray[j][i] = new Link(0);
         }
      }

      first = linkArray[0][0];     // define first
      int x, y;

      for(int j=0; j<linkArray.length-1; j++)
      {
         for(int i=0; i<linkArray[0].length-1; i++)
         {
            linkArray[j][i].right = linkArray[j][i+1];
            linkArray[j][i].down = linkArray[j+1][i];
         }
      }
   }
// -------------------------------------------------------------
                                  // insert at start of list
   public void insert(int x, int y, double v)
      {                           // make new link
         Link current = first;
         while(x>0)
         {
            current=current.right;
            x--;
         }
         while(y>0)
         {
            current=current.down;
            y--;
         }
         current.set(v);
      }
// -------------------------------------------------------------
   public double delete(int x, int y)
      {                           // make new link
         Link current = first;
         double temp;
         while(x>0)
         {
            current=current.right;
            x--;
         }
         while(y>0)
         {
            current=current.down;
            y--;
         }
         temp=current.value;
         current.set(0);
         return temp;
      }
// -------------------------------------------------------------
   public void display()
      {
         Link current = first;
         Link current2 = first;
         while(current2 != null)
         {
            while(current != null)
            {
               current.displayLink();
               current=current.right;
            }
            current2=current2.down;
            current=current2;
            System.out.println("");
         }
      }
// -------------------------------------------------------------      
   }  // end class LinkList
////////////////////////////////////////////////////////////////
class TwoDLinkedListApp
   {
   public static void main(String[] args)
   {
      int randX, randY, width=7, height=10;
      double randValue;
      TwoDLinkedList twoDLinkedList = new TwoDLinkedList(width,height);  // make new list
      

      twoDLinkedList.insert(0,0,0.0);
      twoDLinkedList.insert(0,1,1.0);
      twoDLinkedList.insert(0,2,2.0);
      twoDLinkedList.insert(0,3,3.0);
      twoDLinkedList.display();
      System.out.println("");
      System.out.println("");
      System.out.println("Deleted " + twoDLinkedList.delete(0,3));
      System.out.println("");
      System.out.println("");

      for(int i=0; i<50; i++)
      {
         randX=(int) (Math.random()*width);
         randY=(int) (Math.random()*height);
         randValue=(double) (Math.random()*10);
         twoDLinkedList.insert(randX, randY, randValue);
      }
      twoDLinkedList.display();

   }  // end main()
}  // end class LinkListApp
////////////////////////////////////////////////////////////////
