package persistence.repo;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public String showAccount(String accountId) {
//		Account thisAccount = this.json.getObjectForJSON(account, Account.class);
//		String userName = thisAccount.getUserName();
//		return SUCCESS;
		TypedQuery<Account> loginQuery = this.manager.createQuery("SELECT a FROM Account a WHERE a.userName=:userName", Account.class);
		return this.json.getJSONForObject(loginQuery.getSingleResult());
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
//		existing.setAccountId(newAccount.getAccountId());
		existing.setUserPass(newAccount.getUserPass());
		this.manager.persist(existing);
		return SUCCESS;
	}
	
	@Override
	public String login(String account) throws AccountNotFoundException {
		Account newLogin = this.json.getObjectForJSON(account, Account.class);
		String userName = newLogin.getUserName();
		String userPass = newLogin.getUserPass();
		
		String searchAcc = "SELECT a FROM Account a WHERE a.userName=:userName and a.userPass=:userPass";

		Query query =  this.manager.createQuery(searchAcc);
		query.setParameter("userName", userName);
		query.setParameter("userPass", userPass);
		
		Account loginSuccess  = (Account) query.getSingleResult();
		
		return this.json.getJSONForObject(loginSuccess);
	}

	@Override
	public List<Account> findAccountsByUserName(String userName) {
		TypedQuery<Account> query = this.manager.createQuery("SELECT a FROM Account a WHERE a.userName = :userName",
				Account.class);
		query.setParameter("userName", userName);
		return query.getResultList();
	}

	

}
