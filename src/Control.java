import java.util.*;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;

public class Control {

	public Control() {
		String rules = this.getRules();
		SortingServiceClient client = new SortingServiceClient(rules);
	}

	public String getRules() {
		Properties prop = new Properties();
		String fileName = "../app.config";
		InputStream is = null;

		try {
		    is = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
		    System.out.println(e);
		}
		try {
		    prop.load(is);
		} catch (IOException e) {
		    System.out.println(e);
		}

		String rules = (String)prop.getProperty("rules");

		if(rules.equals("Null")) {
			System.err.println("OrderingException");
			return "";
		}

		return rules;
	}

}