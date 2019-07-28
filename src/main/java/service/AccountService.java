package service;

import java.util.List;

import persistence.domain.Account;

//import persistence.exceptions.AccountNotFoundException;

public interface AccountService {
	String getAllAccounts();

	String createAccount(String account);

	String showAccount(String accountId);

	String deleteAccount(int accountId);

	String updateAccount(int accountId, String account);

	String login(String accountId);
	
	List<Account> findAccountsByFirstName(String userName);


}
