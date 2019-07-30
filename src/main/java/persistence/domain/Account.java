package persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	private String userName;
	private String userPass;
	
	@OneToMany(mappedBy = "account")
	private Set<ToDoList> lists = new HashSet<>();

	public Account() {

	}

	public Account(Integer accountId, String userName, String userPass, Set<ToDoList> lists) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.userPass = userPass;
		this.lists = lists;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Set<ToDoList> getLists() {
		return lists == null ? new HashSet<ToDoList>() : lists;
	}

	public void setLists(Set<ToDoList> lists) {
		this.lists = lists;
	}



}













