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
		return this.json.getJSONForObject(this.repo.getAllAccounts());
	}

	@Override
	public String createAccount(String account) {
		return this.json.getJSONForObject(this.repo.createAccount(this.json.getObjectForJSON(account, Account.class)));
	}

	@Override
	public String showAccount(int accountId) {
		return this.json.getJSONForObject(this.repo.showAccount(accountId));
	}

	@Override
	public String deleteAccount(int accountId) {
		return this.repo.deleteAccount(accountId);
	}

	@Override
	public String updateAccount(int accountId, String account) {
		return this.json.getJSONForObject(
				this.repo.updateAccount(accountId, this.json.getObjectForJSON(account, Account.class)));
	}

	public String login(String account) {
		return this.json.getJSONForObject(this.repo.login(this.json.getObjectForJSON(account, Account.class)));
	}

	@Override
	public List<Account> findAccountsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

}