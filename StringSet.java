package cs272lab2;

import java.util.Arrays;

public class StringSet {

	// create instance variables
    
    public String[] set;
    public int size;
    
    /**
     * @postcondition
     *   this collection is empty and has an initial capacity of 2.
     */
    
    public StringSet() {
        
        final int INITIAL_CAPACITY = 2;
        this.size = 0;
        this.set = new String[INITIAL_CAPACITY];
        
    }
    
    /**
     * @param _capacity
     *  initial capacity of this collection. 
     * @precondition
     *  _capacity is a positive value.
     * @postcondition
     *  this collection is empty and has the given initial capacity.
     * @exception IllegalArgumentException
     *  indicates initial capacity is negative.
     */
    
    public StringSet(int _capacity) {
        
        if(_capacity < 0)
            throw new IllegalArgumentException
            ("The initial capacity is negative: " + _capacity);
        
        set = new String[_capacity];
        size = 0;
        
    }

    /**
     * @param obj
     *  new copied object
     * @precondition
     *  obj is not null, and
     *  an instance of StringSet.
     */
    
    public StringSet (Object obj) {
    	
        if(obj == null)
            throw new IllegalArgumentException
            ("obj is null");
        
        if(!(obj instanceof StringSet))
            throw new IllegalArgumentException
            ("obj is not an instance of StringSet");
        
        StringSet copyset = (StringSet)obj;
        this.size = copyset.size;
        this.set = new String[size];
        for(int i = 0; i < size; i++)
            set[i] = copyset.set[i];
        
    }
    
    /**
     * @return
     *  actual number of elements in this collection.
     */
    
    public int size() {
        
        return size;
        
    }

    /**
     * @return
     *  the capacity of this collection. 
     */
    
    public int capacity() {
        
        return set.length;
        
    }
    
    /**
     * @param a
     *  new element to be added into the collection.
     * @precondition
     *  a is not null.
     * @postcondition
     *  an new element has been added to the collection.
     */
    
    public void add(String a) {
        
        String temp;
        if(a == null)
            throw new IllegalArgumentException
            ("new element is null");
        
        if(size == set.length) {
            
            // ensure twice as much space
            
            ensureCapacity(size*2);
            
        }
        
        set[size] = a;
        size++;
        
        // sort alphabetically.
        
        for (int i = 0; i < size; i++) {
                
                for (int j = i + 1; j < size; j++) {

                    if (set[i].compareToIgnoreCase(set[j])>0) {

                        temp = set[i];
                        set[i] = set[j];
                        set[j] = temp;

                    }

                }

            }
        
    }
      
    /**
     * @param a
     *  element to be checked.
     * @precondition
     *  a is not null.
     * @return
     *  whether the element is already in the collection or not.
     */
    
    public boolean contains(String a) {
        
        if(a == null)
            return false;
        
        for(int i = 0; i < size; i++) {
            
            if(set[i].equalsIgnoreCase(a))
                return true;
            
        }
        
        return false;
        
    }
    
    /**
     * @param a
     *  element to be checked and removed
     * @precondition
     *  a is not null.
     * @return
     * the element would be removed if existed in the collection.
     */
    
    public boolean remove(String a) {
        
        int a1;
        String temp;
        
        if(a == null)
            return false;
        
        for(a1 = 0; (a1 < size) && (!(set[a1].equalsIgnoreCase(a))); a1++);
        
        if(a1 == size)
            return false;
                
        else {
        	
            size--;
            set[a1] = set[size];
            
            // sort alphabetically.
            
            for (int i = 0; i < size; i++) {       
            	
                for (int j = i + 1; j < size; j++) {

                    if (set[i].compareToIgnoreCase(set[j])>0) {

                        temp = set[i];
                        set[i] = set[j];
                        set[j] = temp;

                    }

                }
                
            }
                
            return true;
                
        }
        
    }
    
    /**
     * @param minimumCapacity
     *  new capacity for the collection.
     * @precondition
     *  minimumCapacity is positive.
     * @postcondition
     *  increase capacity to at least minimumCapacity.
     *  unchanged if the capacity was equal or greater than minimumCapacity.
     * @exception IllegalArgumentException
     *  indicates initial capacity is negative.
     */
    
    public void ensureCapacity(int minimumCapacity) {
    	
        if(minimumCapacity < 0)
            throw new IllegalArgumentException
            ("The minimumCapacity is negative: " + minimumCapacity);
        
        String[] biggerset;
        
        if(set.length < minimumCapacity) {
            
            biggerset = new String[minimumCapacity];
            System.arraycopy(set,0,biggerset,0,size);
            set = biggerset;
            
        }
        
    }
    
    /**
     * @param a
     *  new element to be added and sorted
     * @precondition
     *  a is not null, and
     *  the values in the collection's string array are already ordered ascendingly.
     * @postcondition
     *  an element has been added to this collection, and
     *  the values are ordered ascendingly. 
     */
    
    public void addOrdered(String a) {
        
        String temp;
        
        if(a == null)
            throw new IllegalArgumentException
            ("new element is null");
        
        if(size < set.length) {
            
            // ensure twice as much space
            
            ensureCapacity(size*2);
        
        }
        
        set[size] = a;
        size++;
            
            //sort alphabetically
        
            for (int i = 0; i < size; i++) {

                for (int j = i + 1; j < size; j++) {

                    if (set[i].compareToIgnoreCase(set[j])>0) {

                        temp = set[i];
                        set[i] = set[j];
                        set[j] = temp;

                    }

                }

            }
        
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString() {
    	
    	return Arrays.toString(set);
        
    }

	/**
	 * the main method of this program
	 * @param args
	 *  array of string arguments.
	 */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test add method.
        
        StringSet set1 = new StringSet(4);
        System.out.println("\n=>Test add method<=");
        set1.add("Nish");
        set1.add("cate");
        set1.add("renee");
        System.out.println("String: "+set1.toString());
        
        // Test size() and capacity() methods.
        
        System.out.println("\n=>Test size() and capacity() methods<=");
        System.out.println("Capacity: "+set1.capacity());
        System.out.println("Capacity: "+set1.size());
        
        // Test addOdered method.
        
        System.out.println("\n=>Test addOdered method<=");
        set1.addOrdered("nhat");
        System.out.println("New String: "+set1.toString());
        System.out.println("Initial Capacity: "+set1.capacity());
        System.out.println("Initial Size: "+set1.size());
        
        // Test ensureCapacity method.
        
        System.out.println("\n=>Test ensureCapacity method<=");
        set1.add("Joshua");
        set1.addOrdered("Moticha");
        set1.add("Nish");
        System.out.println("New String: "+set1.toString());
        System.out.println("New Capacity: "+set1.capacity());
        System.out.println("New Size: "+set1.size());
        
        // Test contains() method.
        
        System.out.println("\n=>Test contains() methods<=");
        System.out.println("Duplicate?: "+set1.contains("nish"));
        
        // Test remove() method.
        
        System.out.println("\n=>Test remove() methods<=");
        System.out.println("Original String: "+set1.toString());
        System.out.println("Duplicate?: "+set1.remove("Nish"));
        StringSet set2 = new StringSet(set1);
        System.out.println("New String: "+set2.toString());
        System.out.println("New Capacity: "+set2.capacity());
        System.out.println("New Size: "+set2.size());
        
        // Test copy constructor.
        
        System.out.println("\n=>Test copy constructor<=");
        System.out.println("Original String: "+set2.toString());
        StringSet set3 = new StringSet(set2);
        System.out.println("Copied String: "+set3.toString());
        System.out.println("Copied Capacity: "+set3.capacity());
        System.out.println("Copied Size: "+set3.size());
        
        
        // Test capacity cannot be negative. 
        
        System.out.println("\n=>Test capacity cannot be negative<=");
        StringSet set4 = new StringSet(-1);

	}

}
