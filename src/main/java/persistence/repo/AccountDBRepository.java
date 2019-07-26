package persistence.repo;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.Account;
import util.JSONUtil;

import persistence.exceptions.AccountNotFoundException;

@Transactional(value = TxType.SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil json;

	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = this.manager.createQuery("SELECT a from Account a", Account.class);
		return this.json.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		Account toCreate = this.json.getObjectForJSON(account, Account.class);
		this.manager.persist(toCreate);
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountId) throws AccountNotFoundException {
		this.manager.remove(this.manager.find(Account.class, accountId));
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int userName, String account) throws AccountNotFoundException {
		Account newAccount = this.json.getObjectForJSON(account, Account.class);
		Account existing = this.manager.find(Account.class, userName);
		existing.setUserName(newAccount.getUserName());
		existing.setId(newAccount.getId());
		existing.setUserPass(newAccount.getUserPass());
		this.manager.persist(existing);
		return null;
	}

	@Override
	public List<Account> findAccountsByUserName(String userName) {
		TypedQuery<Account> query = this.manager.createQuery("SELECT a FROM Account a WHERE a.firstName = :firstName",
				Account.class);
		query.setParameter("firstName", userName);
		return query.getResultList();
	}

}
