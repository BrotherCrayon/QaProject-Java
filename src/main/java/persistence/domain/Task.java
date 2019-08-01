//package persistence.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Task {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer taskId;
//
//	private boolean completed;
//
//	private String content;
//
//	@ManyToOne
//	private ToDoList list;
//
//	public Task(Integer taskId, boolean completed, String content, ToDoList list) {
//		super();
//		this.taskId = taskId;
//		this.completed = completed;
//		this.content = content;
//		this.list = list;
//	}
//
//	public Task() {
//		super();
//	}
//
//	public Integer getTaskId() {
//		return taskId;
//	}
//
//	public void setTaskId(Integer taskId) {
//		this.taskId = taskId;
//	}
//
//	public boolean isCompleted() {
//		return completed;
//	}
//
//	public void setCompleted(boolean completed) {
//		this.completed = completed;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public ToDoList getList() {
//		return list;
//	}
//
//	public void setList(ToDoList list) {
//		this.list = list;
//	}
//
//}
