/**
 * Name: Eric Truong
 * Date: October 30, 2019
 * Description: Makes a linked list
 */
public class LinkedList {

    /**
     * Makes circles into nodes
     */
    private static class Node {

        /**
         * Circle is the data
         */
        private Circle data;

        /**
         * Next node in the list
         */
        private Node next;

        /**
         * Puts a circle in the list
         * @param c a circle
         */
        public Node(Circle c){
            data = c;
            next = null;
        }

        /**
         * Puts a circle at a certain position
         * @param c a circle
         * @param n the position
         */
        public Node(Circle c, Node n){
            data = c;
            next = n;
        }

        /**
         * Puts data in a string
         * @return  returns data in a string
         */
        @Override
        public String toString(){
            return data + "";
        }
    }

    /**
     * Create the first node
     */
    private Node first;

    /**
     * Creates the end node
     */
    private Node last;

    /**
     * Creates the linked list
     */
    public LinkedList(){
        first = null;
        last = null;
    }

    /**
     * check if the list is empty
     * @return  return true or false if it's empty
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Adds a circle into the list
     * @param c a circle
     */
    public void add (Circle c){
        if (first == null){
            first = new Node(c);
            last = first;
        }
        else {
            Node n = new Node(c);
            last.next = n;
            last = n;
        }
    }

    /**
     * Return the circle at a certain node
     * @param i specified node
     * @return  circle at node
     */
    public Circle get(int i){
        if(first == null || i < 0){
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for(int j = 0; j < i; j++){
            n = n.next;
            if(n == null){
                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * Set the circle into a specified node
     * @param i specified node
     * @param c a circle
     */
    public void set(int i, Circle c){
        if(first == null || i < 0){
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for(int j = 0; j < i; j++){
            n = n.next;
            if(n == null){
                throw new IndexOutOfBoundsException();
            }
        }
        n.data = c;
    }

    /**
     * Gets the size of the linkedlist
     * @return  return size of linkedlist
     */
    public int size(){
        int count = 0;
        Node n = first;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * Convert the data into a string
     * @return  returns data as a string
     */
    @Override
    public String toString(){
        String str = "";
        Node n = first;
        while(n != null){
            str = str + n.data + "\n";
            n = n.next;
        }
        return str;
    }

    /**
     * Adding a new node
     * @param i position to make the new node
     * @param c a circle
     */
    public void add(int i, Circle c){
        if (i < 0){
            throw new IndexOutOfBoundsException();
        }
        if (i == 0){
            first = new Node(c, first);
            if(last == null){
                last = first;
            }
        }
        else{
            Node n = first;
            if(n == null){
                throw new IndexOutOfBoundsException();
            }
            for(int j = 1; j < i; j++){
                n = n.next;
                if(n == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            n.next = new Node(c, n.next);
            if(n.next.next == null){
                last = n.next;
            }
        }
    }


    /**
     * Remove a node
     * @param i specified node
     * @return  link set to another node
     */
    public Circle remove(int i) {
        Circle rem;
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            rem = first.data;
            first = first.next;
            if(first == null){
                last = null;
            }
        }
        else{
            Node n = first;
            for(int j = 1; j < i; j++){
                n = n.next;
                if(n == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            if(n.next == null){
                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if(n.next == null){
                last = n;
            }
        }
        return rem;
    }

    /**
     * Find a circle and remove it
     * @param c a circle
     * @return  returns if the circle has been removed, false otherwise
     */
    public boolean remove(Circle c){
        if(first != null){
            if(c.equals(first.data)){
                first = first.next;
                if(first == null){
                    last = null;
                }
                return true;
            }
            else{
                Node n = first;
                while(n.next != null && !n.next.data.equals(c)){
                    n = n.next;
                }
                if(n.next != null){
                    n.next = n.next.next;
                    if(n.next == null){
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}


