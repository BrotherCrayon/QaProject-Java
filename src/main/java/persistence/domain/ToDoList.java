package persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listsId;
	private String ListsTitle;
	private String listsContent;
	
	public ToDoList() {
		
	}
	
	public ToDoList(Integer listsId, String listsTitle, String listsContent) {
		super();
		this.listsId = listsId;
		this.ListsTitle = listsTitle;
		this.listsContent = listsContent;
	}

	public Integer getListsId() {
		return listsId;
	}

	public void setListsId(Integer listsId) {
		this.listsId = listsId;
	}

	public String getListsTitle() {
		return ListsTitle;
	}

	public void setListsTitle(String listsTitle) {
		ListsTitle = listsTitle;
	}

	public String getListsContent() {
		return listsContent;
	}

	public void setListsContent(String listsContent) {
		this.listsContent = listsContent;
	}
	
}
