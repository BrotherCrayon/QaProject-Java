package persistence.repo;

import java.util.List;

import persistence.domain.ToDoList;


public interface ListRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllLists();
	
	//might need to remove accountId
	String getAccountList(int accountId, int listId);

	String createList(String list, int accountId);

	String deleteList(int listId); //throws AccountNotFoundException;

	String updateList(int listId, String lists); //throws AccountNotFoundException;

	List<ToDoList> findListByTitle(String listTitle);

}