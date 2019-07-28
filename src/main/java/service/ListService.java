package service;

import java.util.List;

import persistence.domain.ToDoList;

public interface ListService {
	String getAllLists();

	String getAccountList(int accountId, int listId);

	String createList(String list, int accountId);

	String deleteList(int listId);

	String updateList(int listId, String list) ;
	
	List<ToDoList> FindListByTitle(String listTitle);



}
