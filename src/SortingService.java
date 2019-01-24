/*
 * Enum SortingService
 * Is the heart of the bookshelf's sorting service
 */

import java.util.Comparator;
import java.util.Collections;

public enum SortingService implements Comparator {

	/* Sort based on books titles */
	ByTitle() {
		@Override
		public int compare(Object o1, Object o2) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			return b1.getTitle().compareTo(b2.getTitle());
		}
	},
	/* Sort based on books authors */
	ByAuthor() {
		@Override
		public int compare(Object o1, Object o2) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			return b1.getAuthor().compareTo(b2.getAuthor());
		}
	},
	/* Sort based on books edition year */
	ByEditionYear() {
		@Override
		public int compare(Object o1, Object o2) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			if(b1.getEditionYear() < b2.getEditionYear()) {
				return -1;
			} else if (b1.getEditionYear() > b2.getEditionYear()) {
				return 1;
			} 

			return 0;	
		}
	};

	/* 
	 *  Sort by ascendent way 
	 *  Simply keeps the comparator like it is
	 */
	public Comparator asc() {
    	return this;
    }

    /*   
	 *	Sort by descendent way
	 *	Invert the comparator result order
     */
    public Comparator desc() {
        return Collections.reverseOrder(this);
    }

}