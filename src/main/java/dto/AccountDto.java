package dto;

import java.util.HashSet;
import java.util.Set;

public class AccountDto {
	private Integer id;
	private String userName;
	private String userPass;
	
	private Set<ToDoListDto> lists = new HashSet<>();

	public AccountDto() {

	}

	public AccountDto(Integer id, String userName, String userPass, Set<ToDoListDto> lists) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPass = userPass;
		this.lists = lists;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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













