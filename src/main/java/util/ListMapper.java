package util;

import dto.ToDoListDto;
import persistence.domain.ToDoList;

public class ListMapper {
	
	public ToDoListDto mapToDto(ToDoList list) {
		return new ToDoListDto(list.getListId(), list.getListTitle(), list.getListContent());
	}

}
