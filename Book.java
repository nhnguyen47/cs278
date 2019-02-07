import java.util.Arrays;
import java.util.*;

public class Book 

{
    
    //create instance variables
    
    public String title;
    public int numofau;
    public String[] authors;
    public String isbn;
    
    /*no-argument constructor
    *create a String array with length 3 for authors
    */
    
    public Book () 
    
    {
        
        this.title = null;
        this.numofau = 0;
        this.authors = new String[3];
        this.isbn = null;
        
    } //end of no-argument constructor
    
    /*constructor to set book title
    *create a String array with length 3 for authors
    */
    
    public Book (String _title) 
    
    {
        
        this.title = _title;
        this.numofau = 0;
        this.authors = new String[3];
        this.isbn = null;
        
    } //end of constructor to set book title
    
    /*copy constructor
     * @precondition
     * obj is not null, and
     * an instance of Book
     */
     
    public Book (Book obj) 
    
    {
        
        if(obj != null && obj instanceof Book)
            
        {
            
            this.title = obj.title;
            this.numofau = obj.numofau;
            this.isbn = obj.isbn;
            this.authors = new String[obj.authors.length];
            for(int i=0; i < numofau; i++)
                authors[i] = obj.authors[i];
            
        } //end of if
        
        
    } //end of copy constructor
    
    //return a book title
    
    public String getTitle ()
    
    {
        
        return title;
        
    } //end of returning book title
    
    //return number of authors of current book
    
    public int getAuthorNumber ()
    
    {
     
        return numofau;
        
    } //end of returning number of authors
    
    //return ISBN of current book
    
    public String getISBN ()
    
    {
        
        return isbn;
        
    } //end of returning ISBN
    
    //set title of a book
    
    public void setTitle (String _title)
    
    {
        
        this.title = _title;
        
    } //end of setting book title
    
    //set ISBN of a book
    
    public void setISBN (String _isbn)
    
    {
        
        this.isbn = _isbn;
        
    } //end of setting book ISBN
    
    // add authors to author list
    
    public boolean addAuthor (String _authors)
    
    {
        
        //check if sufficient space in author array
        
        if(numofau < authors.length)
        
        {
            
            authors[numofau] = _authors;
            numofau++;
            return true;
            
        } //end of if
        
        else 
            
            return false;
        
    } //end of addAuthor method
    
    /*check if given ISBN is the same as book ISBN
     * @precondition
     * obj is not null, and
     * an instance of Book
     */
    
    public boolean equals(Book obj)
    
    {
        
        if(obj != null && obj instanceof Book)
            
        {
            
            if(obj.isbn == this.isbn) return true;
            else return false;
            
        } //end of if
        
        else
            
            return false;
        
    } //end of equals method
    
    /*get all distinct authors of two books
     * @param b1
     * first of the two books
     * @param b2
     * second of the two books
     * @precondition
     * neither b1 nor b2 is null
     * @return
     * the union of b1 and b2
     */
    
    public static String[] getAllAuthors(Book b1, Book b2)
    
    {
        
         String allAuthors[] ={};
        
        
        for (String i : allAuthors)
            System.out.println(i);
        
        if(b1 != null && b2 != null)
            
        {
     
            for (int i = 0; i< b1.authors.length; i++)
                
            {   
                if (isExist(allAuthors,b1.authors[i]) == false)
                
                {
                    allAuthors = Arrays.copyOf(allAuthors, allAuthors.length + 1);
                    allAuthors[allAuthors.length -1] = b1.authors[i];
                    
                }
            
            } 
      
            for (int j = 0; j< b2.authors.length; j++)
                
            {
                if (isExist(allAuthors,b2.authors[j]) == false)
                
                {
                    
                    allAuthors = Arrays.copyOf(allAuthors, allAuthors.length + 1);
                    allAuthors[allAuthors.length -1] = b2.authors[j];
                    
                }
                
            }
            
        } //end of if
        
        return allAuthors;
        
    } //end of static method
    
    //check if a String in the array
    
    public static boolean isExist( String[] array,  String v) 
    
    {

        boolean result = false;

        for(String s : array){
            if(s.equals(v)){
                result = true;
                break;
            }
        }

        return result;
    }
    
    //generate a string representation of a book
    
    public String toString()
    
    {
        
        return "Title:" + title + ", ISBN: " + isbn + ", Number of Authors: " + Integer.toString(numofau) + ", List of Authors: " + Arrays.toString(authors);
        
    } //end of toString method

    public static void main(String[] args)
    
    {
        
        // first book

        Book book1 = new Book();
        book1.title = "Book 1";
        book1.isbn = "1234567891";
        book1.addAuthor("Joe Song");
        book1.addAuthor("Son Tran");
        book1.addAuthor("Antonio Lara");
        System.out.println(book1.toString());

        // second book

        Book book2 = new Book();
        book2.title = "Book 2";
        book2.isbn = "167889325";
        book2.addAuthor("Son Tran");
        book2.addAuthor("Joe Song");
        book2.addAuthor("Michael Johnson");
        book2.addAuthor("Antonio Lara");
        System.out.println(book2.toString());

        //print nonduplicate authors

        System.out.println(Arrays.toString(getAllAuthors(book1,book2)));
        
    } //end of main() method
    
} //end of class Book

