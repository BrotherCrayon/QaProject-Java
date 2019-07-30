	package persistence.repo;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.Account;
import persistence.domain.ToDoList;
import persistence.exceptions.AccountNotFoundException;
import util.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
@Default
public class ListDBRepository implements ListRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil json;

	@Override
	public String getAllLists() {
		TypedQuery<ToDoList> query = this.manager.createQuery("SELECT l from ToDoList l", ToDoList.class);
		return this.json.getJSONForObject(query.getResultList());
	}
	
	//TO-DO yet
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public String getAccountList(int accountId) {
		Account showAcc = this.manager.find(Account.class, accountId);
		if (showAcc == null) {
			throw new AccountNotFoundException();
		}
		return this.json.getJSONForObject(showAcc.getLists());
	}

//	@Override
//	@Transactional(value = TxType.REQUIRED)
//	public String createList(String list, int accountId) {
//		Account getAccount = this.manager.find(Account.class, accountId);
//		ToDoList listCreate = this.json.getObjectForJSON(list, ToDoList.class);
//		
//		listCreate.setAccount(getAccount);
//		this.manager.persist(listCreate);
//		return SUCCESS;
//	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createListItem(String list, int accountId) {
		Account getAccount = this.manager.find(Account.class, accountId);
		ToDoList listCreate = this.json.getObjectForJSON(list, ToDoList.class);
		
		listCreate.setAccount(getAccount);
		this.manager.persist(listCreate);
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteList(int listId) {
		this.manager.remove(this.manager.find(ToDoList.class, listId));
		return SUCCESS;
	}

//	@Override
//	@Transactional(value = TxType.REQUIRED)
//	public String updateList(int listId, String list) {
//		ToDoList newList = this.json.getObjectForJSON(list, ToDoList.class);
//		ToDoList existingList = this.manager.find(ToDoList.class, listId);
//		existingList.setListId(newList.getListId());
//		existingList.setListTitle(newList.getListTitle());
//		existingList.setListContent(newList.getListContent());
//		this.manager.persist(existingList);
//		
//		return SUCCESS;
//	}

	//later functionality.
//	@Override
//	public List<ToDoList> findListByTitle(String listTitle) {
//		TypedQuery<ToDoList> query = this.manager.createQuery("SELECT from l WHERE l.listsTitle = :listsTitle", ToDoList.class);
//		query.setParameter("listsTitle", listTitle);
//		return query.getResultList();
//	}
}
