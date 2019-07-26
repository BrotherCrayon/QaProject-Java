package service;

import java.util.List;

import persistence.domain.ToDoList;

public interface ListService {
	String getAllLists();

	String createList(String lists);

	String deleteList(int listsId);

	String updateList(int listsId, String lists) ;
	
	List<ToDoList> FindListByTitle(String listsTitle);

}
