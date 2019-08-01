package service;

import javax.inject.Inject;

import persistence.repo.ListRepository;

public class ListServiceImpl implements ListService {

	@Inject
	private ListRepository listRepo;
	
	@Override
	public String getAllLists() {
		return this.listRepo.getAllLists();
	}
	
	@Override
	public String getAccountList(int accountId) {
		return this.listRepo.getAccountList(accountId);
	}

	
//	@Override
//	public String createList(String list, int accountId) {
//		return this.listRepo.createList(list, accountId);
//	}
	
	@Override
	public String createListItem(String list, int accountId) {
 		return this.listRepo.createListItem(list, accountId);
	}
	
	@Override
	public String deleteList(int listId) {
		return this.listRepo.deleteList(listId);
	}

//	@Override
//	public String updateList(int listId, String list) {
//		return this.listRepo.updateList(listId, list);
//	}

}
