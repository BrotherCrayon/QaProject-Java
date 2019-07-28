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
	public String getAccountList(int accountId, int listId) {
		return this.listRepo.getAccountList(accountId, listId);
	}

	
	@Override
	public String createList(String list, int accountId) {
		return this.listRepo.createList(list, accountId);
	}
	
	@Override
	public String deleteList(int listId) {
		return this.listRepo.deleteList(listId);
	}

	@Override
	public String updateList(int listId, String list) {
		return this.listRepo.updateList(listId, list);
	}

	@Override
	public List<ToDoList> FindListByTitle(String listTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
