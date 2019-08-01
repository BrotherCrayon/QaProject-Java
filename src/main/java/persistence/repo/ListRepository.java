package persistence.repo;


public interface ListRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllLists();
	
	//might need to remove accountId
	String getAccountList(int accountId);

//	String createList(String list, int accountId);

	String createListItem(String list, int accountId);

	String deleteList(int listId); 

//	String updateList(int listId, String lists);

}