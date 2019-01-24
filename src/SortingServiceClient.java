/*
 *  Class SortingServiceClient
 *	Prepare and call the sorting service
 */

import java.util.ArrayList;
import java.util.Collections;

public class SortingServiceClient {

	private String rules; 			//Rules for the call
	private ArrayList rules_list; 	//List of rules
	private ArrayList bookshelf; 	//List of books in the bookshelf

	/*  
	 *  Constructor
	 *	\param _rules rules from the config file
	 */
	public SortingServiceClient(String _rules) {

		/* Creating the books */
		Book b1 = new Book(1, "Java How To Program", "Deitel & Deitel", 2007);
	    Book b2 = new Book(2, "Patterns of Enterprise Application Architecture", "Martin Fowler", 2002);
	    Book b3 = new Book(3, "Head First Design Patterns", "Elisabeth Freeman", 2004);
	    Book b4 = new Book(4, "Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007);

	    /* Adding the books to the bookshelf list */
		this.bookshelf = new ArrayList();
		this.bookshelf.add(b1);
		this.bookshelf.add(b2);
		this.bookshelf.add(b3);
		this.bookshelf.add(b4);

		this.rules = _rules;
		this.rules_list = new ArrayList();
		this.createRulesList();
		this.callSortService();
	}

	/*
	 * 	Function createRulesList()
	 * 	Creates the rules list by splitting the rules string
	 */
	public void createRulesList() {
		String _rules = this.rules;
		while(_rules.contains(",")) {
			int comma_index = _rules.indexOf(","); 						//Finding the index of the comma
			this.rules_list.add(_rules.substring(0, comma_index));		//Adding the rule in the rules list
			_rules = _rules.substring(comma_index+2, _rules.length()); 	//Splitting the string for the next round
		}

		/* Just add the string when there's no comma */
		this.rules_list.add(_rules);
	}

	/*
	 * 	Function callSortService()
	 * 	Prepare, calls the sorting service and shows its answer
	 */
	public void callSortService() {

		/* In the case of the user typed nothing in the config file */
		if(this.rules.length() < 1) {
			return;
		}

		ArrayList inverted_rules = this.rules_list;
		Collections.reverse(inverted_rules); //Invert the rules list, according to the logic of sorting service

		/* For each rule, call the specific service from the sorting service */
		for(int i = 0; i < inverted_rules.size(); i++) {
			String rule = (String)inverted_rules.get(i);
			int space_index = rule.indexOf(" ");
			String attribute = rule.substring(0, space_index);
			String direction = rule.substring(space_index+1, rule.length());

			/* Avoiding user mistake */
			attribute = attribute.toLowerCase();
			direction = direction.toLowerCase();
			
			switch(attribute) {
				case "title":
					if(direction.contains("asc")) {
						Collections.sort(this.bookshelf, SortingService.ByTitle.asc());
					} else {
						Collections.sort(this.bookshelf, SortingService.ByTitle.desc());
					}
					break;
				case "author":
					if(direction.contains("asc")) {
						Collections.sort(this.bookshelf, SortingService.ByAuthor.asc());
					} else {
						Collections.sort(this.bookshelf, SortingService.ByAuthor.desc());
					}
					break;
				case "edition":
					if(direction.contains("asc")) {
						Collections.sort(this.bookshelf, SortingService.ByEditionYear.asc());
					} else {
						Collections.sort(this.bookshelf, SortingService.ByEditionYear.desc());
					}
					break;
				default:
					return;
			}
		}

		/* Showing the answer */ 
		System.out.print("Livros: ");
		for(int i = 0; i < this.bookshelf.size(); i++) {
			Book b = (Book)this.bookshelf.get(i);
			if(i != this.bookshelf.size()-1) {
				System.out.print(b.getId() + ", ");
			} else {
				System.out.println(b.getId());
			}
		}
	}
}