import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.ListDetails;
import model.ListItem;
import model.Shopper;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Feb 21, 2023
*/
public class ListDetailsTester {
	public static void main(String[] args) {
		Shopper cameron = new Shopper("Cameron");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListItem shampoo = new ListItem("Target", "Shampoo");
		ListItem brush = new ListItem("Target", "Brush");
		
		List<ListItem> cameronsItems = new ArrayList<ListItem>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		
		ListDetails cameronsList = new ListDetails("Cameron's ShoppingList", LocalDate.now(), cameron);
		cameronsList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronsList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}
}
