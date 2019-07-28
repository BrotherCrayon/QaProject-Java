package persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ToDoList {
	@ManyToOne
	private Account account;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listId;
	private String listTitle;
	private String listContent;
	
	
	public ToDoList(Integer listId, String listTitle, String listContent) {
		super();
		this.listId = listId;
		this.listTitle = listTitle;
		this.listContent = listContent;
	}

	public ToDoList() {
		
	}

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	public String getListContent() {
		return listContent;
	}

	public void setListContent(String listContent) {
		this.listContent = listContent;
	}
	
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
