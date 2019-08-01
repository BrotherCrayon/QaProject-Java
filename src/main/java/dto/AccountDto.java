package dto;

import java.util.HashSet;
import java.util.Set;

public class AccountDto {
	private Integer accountId;
	private String userName;
	private String userPass;
	
	private Set<ToDoListDto> lists = new HashSet<>();

	public AccountDto() {

	}

	public AccountDto(Integer accountId, String userName, String userPass, Set<ToDoListDto> lists) {
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

	public Set<ToDoListDto> getLists() {
		return lists;
	}

	public void setLists(Set<ToDoListDto> lists) {
		this.lists = lists;
	}



}













