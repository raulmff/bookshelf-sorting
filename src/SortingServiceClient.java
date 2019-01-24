import java.util.ArrayList;
import java.util.Collections;

public class SortingServiceClient {

	private String rules;
	private ArrayList rules_list;
	private ArrayList bookshelf;

	public SortingServiceClient(String _rules) {
		Book b1 = new Book(1, "Java How To Program", "Deitel & Deitel", 2007);
	    Book b2 = new Book(2, "Patterns of Enterprise Application Architecture", "Martin Fowler", 2002);
	    Book b3 = new Book(3, "Head First Design Patterns", "Elisabeth Freeman", 2004);
	    Book b4 = new Book(4, "Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007);

		bookshelf = new ArrayList();
		bookshelf.add(b1);
		bookshelf.add(b2);
		bookshelf.add(b3);
		bookshelf.add(b4);

		this.rules = _rules;
		this.rules_list = new ArrayList();
		this.createRulesList();
		this.callSortService();
	}

	public void createRulesList() {
		String _rules = this.rules;
		while(_rules.contains(",")) {
			int comma_index = _rules.indexOf(",");
			this.rules_list.add(_rules.substring(0, comma_index));
			_rules = _rules.substring(comma_index+2, _rules.length());
		}
		this.rules_list.add(_rules);
	}

	public void callSortService() {

		if(this.rules.length() < 1) {
			return;
		}

		SortingService comparator;
		ArrayList inverted_rules = this.rules_list;

		Collections.reverse(inverted_rules);	

		for(int i = 0; i < inverted_rules.size(); i++) {
			String rule = (String)inverted_rules.get(i);
			int space_index = rule.indexOf(" ");
			String attribute = rule.substring(0, space_index);
			String direction = rule.substring(space_index+1, rule.length());
			
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
			}
		}

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