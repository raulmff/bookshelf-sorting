import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
	    Book b1 = new Book(1, "Java How To Program", "Deitel & Deitel", 2007);
	    Book b2 = new Book(2, "Patterns of Enterprise Application Architecture", "Martin Fowler", 2002);
	    Book b3 = new Book(3, "Head First Design Patterns", "Elisabeth Freeman", 2004);
	    Book b4 = new Book(4, "Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007);

		List bookshelf = new ArrayList();
		bookshelf.add(b1);
		bookshelf.add(b2);
		bookshelf.add(b3);
		bookshelf.add(b4);

		SortingService comparator;
		Collections.sort(bookshelf, SortingService.ByTitle.desc());

		for(int i = 0; i < bookshelf.size(); i++) {
			Book b = (Book)bookshelf.get(i);
			System.out.println(b.getTitle());
		}   
	}
}