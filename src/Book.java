/*
 *  Class Book
 *  Instance of a book in the bookshelf
 */

public class Book {

	private int id;
	private String title;
	private String author;
	private int edition_year;

	/* Constructor */
	public Book(int _id, String _title, String _author, int _edition_year) {
		this.id = _id;
		this.title = _title;
		this.author = _author;
		this.edition_year = _edition_year;
	}		

	/* Getters methods */
	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public int getEditionYear() {
		return this.edition_year;
	}

}