package persistence.repo;

import java.util.List;

import persistence.domain.Account;

import persistence.exceptions.AccountNotFoundException;

public interface AccountRepository {
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(int accountId) throws AccountNotFoundException;

	String updateAccount(int userName, String account) throws AccountNotFoundException;

	List<Account> findAccountsByUserName(String userName);

}
