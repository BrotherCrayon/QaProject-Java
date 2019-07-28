package persistence.repo;

import java.util.List;

import persistence.domain.ToDoList;


public interface ListRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllLists();

	String createList(String list);

	String deleteList(int listsNumber); //throws AccountNotFoundException;

	String updateList(int listsNumber, String lists); //throws AccountNotFoundException;

	List<ToDoList> findListByTitle(String listsTitle);

}
