package persistence.repo;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import dto.AccountDto;
import persistence.domain.Account;
import persistence.exceptions.AccountNotFoundException;
import util.AccountMapper;

@Transactional(value = TxType.SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private AccountMapper mapper;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<AccountDto> getAllAccounts() {
		TypedQuery<Account> query = this.manager.createQuery("SELECT a from Account a", Account.class);
		return query.getResultList().stream().map(this.mapper::mapToDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Account showAccount(int accountId) throws AccountNotFoundException {
		return this.manager.find(Account.class, accountId);

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public String createAccount(Account account) {
		this.manager.persist(account);
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
	public String updateAccount(int userName, Account account) throws AccountNotFoundException {
		Account existing = this.manager.find(Account.class, userName);
		existing.setUserName(account.getUserName());
//		existing.setAccountId(newAccount.getAccountId());
		existing.setUserPass(account.getUserPass());
		this.manager.persist(existing);
		return SUCCESS;
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public AccountDto login(Account account) throws AccountNotFoundException {
		String searchAcc = "SELECT a FROM Account a WHERE a.userName=:userName and a.userPass=:userPass";

		Query query = this.manager.createQuery(searchAcc);
		query.setParameter("userName", account.getUserName());
		query.setParameter("userPass", account.getUserPass());

		Account loginSuccess = (Account) query.getSingleResult();
		return this.mapper.mapToDto(loginSuccess);
	}

	@Override
	public List<AccountDto> findAccountsByUserName(String userName) {
		TypedQuery<Account> query = this.manager.createQuery("SELECT a FROM Account a WHERE a.userName = :userName",
				Account.class);
		query.setParameter("userName", userName);
		
		return query.getResultList().stream().map(this.mapper::mapToDto).collect(Collectors.toList());
	}

}
