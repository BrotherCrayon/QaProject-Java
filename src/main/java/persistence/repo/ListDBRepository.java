package persistence.repo;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.ToDoList;
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

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createList(String lists) {
		ToDoList listCreate = this.json.getObjectForJSON(lists, ToDoList.class);
		this.manager.persist(listCreate);
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteList(int listsId) {
		this.manager.remove(this.manager.find(ToDoList.class, listsId));
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateList(int listsId, String lists) {
		ToDoList newList = this.json.getObjectForJSON(lists, ToDoList.class);
		ToDoList existingList = this.manager.find(ToDoList.class, listsId);
		existingList.setListsId(newList.getListsId());
		existingList.setListsTitle(newList.getListsTitle());
		existingList.setListsContent(newList.getListsContent());
		this.manager.persist(existingList);
		
		return null;
	}

	@Override
	public List<ToDoList> findListByTitle(String listsTitle) {
		TypedQuery<ToDoList> query = this.manager.createQuery("SELECT from l WHERE l.listsTitle = :listsTitle", ToDoList.class);
		query.setParameter("listsTitle", listsTitle);
		return query.getResultList();
	}
}
