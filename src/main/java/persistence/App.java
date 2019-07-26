package persistence;

import persistence.domain.ToDoList;
import util.JSONUtil;

public class App {

	public static void main(String[] args) {
		JSONUtil json = new JSONUtil();
		ToDoList test = new ToDoList(1, "ListA", "Item goes in here");
		System.out.println(json.getJSONForObject(test));
	}
}
