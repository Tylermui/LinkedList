class Node {
    Object obj;
    Node next;

    public Node() {
        obj = null;
    }

    public Node(Object obj) {
        this.obj = obj;
    }

    public String toString() {
        return obj.toString();
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    /**
     * This method returns the print representation of the list.
     * 
     * @return the print representation of the list.
     */
    public String toString() {
        String out = "";
        for (Node n = head; n != null; n = n.next)
            out += n.obj + " ";

        return out;
    }

    /**
     * This method returns the number of elements in this list.
     * 
     * @return the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * This method adds an Object to the end of the LinkedList.
     * 
     * @param obj it can be of any type - super cool stuff.
     */
    public void add(Object obj) {
        Node node = new Node(obj);
        
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
    * Adds the object given its position in the LinkedList.
    * 
    * @param   obj       represents the object to be added
    * @param   position  represents the position of the object
    *                    to be added in the LinkedList
    */
    public void add(Object obj, int position) {
        Node node = new Node(obj);
        Node curr;
        if (head == null && tail == null) {
            head = tail = node;
        }
        else if (position == 0){
            curr = head;
            head = node;
            head.next = curr;
        }
        else{
            curr = head;
            for (int i = 0; i < position; i++){
                curr.next = node;
                node.next = head.next;
                head.next = curr;
            }
        }
        size++;
    }

    /** 
    * Removes the first matched object and
    * returns the position of the removed object
    * from the LinkedList.
    * 
    * @param   obje  represents the object the user wants to remove
    * @return       position of the removed object
    */
    public int remove(Object obje) {
        if (head.obj == obje)
        {   
            head = head.next;
            size--;
        }
        Node curr = head;
        Node prev = null;
        int position=0;
        while (curr != null){
            position = -1;//is set to false automatically
            if (curr.obj == obje){
                prev.next = curr.next;
                position = 2;
            }
            prev = curr;
            curr = curr.next;
            size--;
        }
        // for (int i = 0; i < size; i++)
        // {
            
        // }
        return position;
    }

    /**
    * Removes the object given its position and
    * returns the removed object (not Node) from the LinkedList.
    * 
    * @param   position  represents the position of the object
    *                    to be removed
    * @return            the item that was removed
    */
    public Object remove(int position) {
        Node curr = new Node();
        Node prev = null;
        if(position == 0)//we point the curr to head, head points to the next node, return curr.obj
        {
            curr = head;
            head = head.next;
            size--;
            return curr.obj;
        }
        else{
            curr = head;
            for (int i = 0; i < position; i++)
            {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            size--;
            return curr.obj;
        }
        
    }

    /**
     * The method returns the found object based on the passed index.
     * It throws an Exception saying that you messed up, and you gotta fix it.
     * Starts at 0 but supports negatives and wraps the index around within
     * the limits of the list.
     * 
     * @param index the index of the object to be returned.
     * @return the object at the index.
     */
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.obj;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("Hello");
        list.add("World");
        list.add("!");
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        list.remove("Hello");

        System.out.println(list.remove("Hello"));
     }
}