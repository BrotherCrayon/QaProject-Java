package service;

import java.util.List;

import javax.inject.Inject;
import util.JSONUtil;

import persistence.domain.Account;
import persistence.repo.AccountRepository;

//import persistence.exceptions.AccountNotFoundException;


public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;
	
	@Inject
	private JSONUtil json;

	@Override
	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		List<Account> accDB = this.repo.findAccountsByUserName(account);
		
		String newAccount = this.json.getObjectForJSON(account, Account.class).getUserName();
		
		if(accDB != null) {
			for(Account a : accDB) {
				if(a.getUserName().equals(newAccount)) {
					return "{\"message\": \"That name already exists\"}";
				}
			}			
		}
		return this.repo.createAccount(account);
	}
	
	@Override
	public String showAccount(int accountId) {
		return this.repo.showAccount(accountId);
	}

	@Override
	public String deleteAccount(int accountId) {
		return this.repo.deleteAccount(accountId);
	}

	@Override
	public String updateAccount(int accountId, String account) {
		return this.repo.updateAccount(accountId, account);
	}
	
	public String login(String account) {
		return this.repo.login(account);
	}

	@Override
	public List<Account> findAccountsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

}