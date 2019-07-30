package service;

public interface ListService {
	String getAllLists();

	String getAccountList(int accountId);

//	String createList(String list, int accountId);
	
	String createListItem(String list, int accountId);

	String deleteList(int listId);

//	String updateList(int listId, String list) ;
	
}
