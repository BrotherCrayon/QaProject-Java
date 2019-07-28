package service;

import java.util.List;

import javax.inject.Inject;

import persistence.domain.ToDoList;
import persistence.repo.ListRepository;

public class ListServiceImpl implements ListService {

	@Inject
	private ListRepository listRepo;
	
	@Override
	public String getAllLists() {
		return this.listRepo.getAllLists();
	}
	
	@Override
	public String createList(String lists) {
		return this.listRepo.createList(lists);
	}
	
	@Override
	public String deleteList(int listId) {
		return this.listRepo.deleteList(listId);
	}

	@Override
	public String updateList(int listId, String lists) {
		return this.listRepo.updateList(listId, lists);
	}

	@Override
	public List<ToDoList> FindListByTitle(String listsTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
