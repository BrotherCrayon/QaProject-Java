package dto;

public class ToDoListDto {

	private AccountDto account;

	private String listContent;
	private Integer listId;
	private String listTitle;

	public ToDoListDto() {

	}

	public ToDoListDto(Integer listId, String listTitle, String listContent) {
		super();
		this.listId = listId;
		this.listTitle = listTitle;
		this.listContent = listContent;
	}

	public AccountDto getAccount() {
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

	public void setAccount(AccountDto account) {
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
