package persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ToDoList {
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Account account;
	
	private String listContent;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listId;
	private String listTitle;
	

	public ToDoList() {
		
	}

	public ToDoList(Integer listId, String listTitle, String listContent) {
		super();
		this.listId = listId;
		this.listTitle = listTitle;
		this.listContent = listContent;
	}

	public Account getAccount() {
		return account;
	}

	public String getListContent() {
		return listContent;
	}

	public Integer getListId() {
		return listId;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setListContent(String listContent) {
		this.listContent = listContent;
	}
	
	
	public void setListId(Integer listId) {
		this.listId = listId;
	}
	
	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}
	
}
