package persistence.repo;

import java.util.List;

import persistence.domain.Account;

import persistence.exceptions.AccountNotFoundException;

public interface AccountRepository {
	final String SUCCESS = "Operation successed";
	final String FAILURE = "Operation failed";

	String getAllAccounts();

	String createAccount(String account);

	String showAccount(String accountId);
	
	String deleteAccount(int accountId) throws AccountNotFoundException;

	String updateAccount(int userName, String account) throws AccountNotFoundException;

	String login(String accountId) throws AccountNotFoundException;
	
	List<Account> findAccountsByUserName(String userName);


	

}
