// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
  // reference to linked list of items
  private Node head; 
  private int numItems; // number of items in list

  public ListReferenceBased() {
      this.head = null;
  }  // end default constructor

  public boolean isEmpty() {
    return this.head == null;
  }  // end isEmpty

  public int size() {
      return numItems;
  }  // end size

  private Node findItem(Object item) {
      if (this.isEmpty()){ return null; }
      boolean found = false;
      Node myNode = head;
      while(myNode.getNext()!= null && !found){
          if(myNode.getItem() == item){
              found = true;
          }else{
              myNode=myNode.getNext();
          }
      }
      return myNode;
  } // end find


    private Node find(int index) {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------
      if (index>numItems){ return null; }

      Node myNode = head;
      for(int i =0;i < index;i++){
          myNode=myNode.getNext();
      }
      return myNode;
  } // end find

  public Object get(int index) 
                throws ListIndexOutOfBoundsException {
      if (index>numItems ||index<0){
          throw new ListIndexOutOfBoundsException("Out of boundary");
      }

      Node myNode = head;
      for(int i =0; i<index;i++){
          myNode=myNode.getNext();
      }
      return myNode;
  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {
      if (index>numItems || index<0){
          throw new ListIndexOutOfBoundsException("Out of boundary");
      }
      Node myNode = new Node(item);
      if(index==0){
          myNode.setNext(head);
          head = myNode;
      }else{
          Node prevNode = this.find(index-1);
          myNode.setNext(prevNode.getNext());
          prevNode.setNext(myNode);
      }
      numItems++;
  }  // end add

  public void remove(int index) 
                   throws ListIndexOutOfBoundsException {
      if (index>numItems || index<0){
          throw new ListIndexOutOfBoundsException("Out of boundary");
      }

      if (index==0){
          head = head.getNext();
      }else{
          Node prevNode = this.find(index-1);
          Node myNode = this.find(index);
          prevNode.setNext(myNode.getNext());
      }
numItems--;
  }   // end remove

  public void removeAll() {
      head = null;
      numItems=0;
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
  } // end removeAll

    public void display() {
      Node myNode = head;
        for (int i = 0;i<numItems;i++){
            System.out.print(myNode.getItem()+" ");
            myNode = myNode.getNext();
        }
    }
} // end ListReferenceBased