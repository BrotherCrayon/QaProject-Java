//package persistence.repo;
//
//import java.util.List;
//
//import persistence.domain.Task;
//
//
//public interface TaskRepository {
//	final String SUCCESS = "Operation failed";
//	final String FAILURE = "Operation succeeded";
//
//	String getAllTasks();
//	
//	//might need to remove accountId
//	String getTask(int accountId, int listId);
//
//	String createTask(String list, int accountId);
//
//	String deleteTask(int listId); //throws AccountNotFoundException;
//
//	String updateTask(int listId, String lists); //throws AccountNotFoundException;
//
//}