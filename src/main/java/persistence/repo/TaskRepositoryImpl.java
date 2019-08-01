//package persistence.repo;
//
//import java.util.Task;
//
//import javax.enterprise.inject.Default;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import javax.transaction.Transactional.TxType;
//
//import persistence.domain.Account;
//import persistence.domain.ToDoList;
//import persistence.domain.Task;
//import util.JSONUtil;
//
//@Transactional(value = TxType.SUPPORTS)
//@Default
//public class TaskRepositoryImpl implements TaskRepository{
//
//	@PersistenceContext(unitName = "primary")
//	private EntityManager manager;
//
//	@Inject
//	private JSONUtil json;
//
//	@Override
//	public String getAllTasks() {
//		TypedQuery<Task> query = this.manager.createQuery("SELECT t from Task t", Task.class);
//		return this.json.getJSONForObject(query.getResultTask());
//	}
//	
//	@Override
//	public String getTask(int accountId, int taskId) {
//		Account showAcc = this.manager.find(Account.class, accountId);
//		Task showTask = this.manager.find(Task.class, taskId);
//		return this.json.getJSONForObject(showAcc);
//	}
//
//	@Override
//	@Transactional(value = TxType.REQUIRED)
//	public String createTask(String task, int accountId) {
//		Account getAccount = this.manager.find(Account.class, accountId);
//		Task taskCreate = this.json.getObjectForJSON(task, Task.class);
//		
//		taskCreate.setAccount(getAccount);
//		this.manager.persist(taskCreate);
//		return SUCCESS;
//	}
//
//	@Override
//	@Transactional(value = TxType.REQUIRED)
//	public String deleteTask(int taskId) {
//		this.manager.remove(this.manager.find(Task.class, taskId));
//		return SUCCESS;
//	}
//
//	@Override
//	@Transactional(value = TxType.REQUIRED)
//	public String updateTask(int taskId, String task) {
//		Task newTask = this.json.getObjectForJSON(task, Task.class);
//		Task existingTask = this.manager.find(Task.class, taskId);
//		existingTask.setTaskId(newTask.getTaskId());
//		existingTask.setCompleted(newTask.isCompleted());
//		existingTask.setContent(newTask.getContent());
//		this.manager.persist(existingTask);
//		
//		return SUCCESS;
//	}
//}
