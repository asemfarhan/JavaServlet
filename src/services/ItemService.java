package services;

import java.util.Arrays;
import java.util.List;
import model.Item;


public class ItemService {

	public List<Item> getItems(){
		return Arrays.asList(	new Item(1, "AAAAA","ddddddd"),
								new Item(2, "BBBBB","ddddddd"),
								new Item(3, "CCCCC","ddddddd"),
								new Item(4, "DDDDD","ddddddd")) ;
	}
}
