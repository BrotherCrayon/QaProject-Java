package persistence.repo;

import java.util.List;

import dto.AccountDto;
import persistence.domain.Account;

import persistence.exceptions.AccountNotFoundException;

public interface AccountRepository {
	final String SUCCESS = "Operation successed";
	final String FAILURE = "Operation failed";

	List<AccountDto> getAllAccounts();


	Account showAccount(int accountId) throws AccountNotFoundException;
	
	String deleteAccount(int accountId) throws AccountNotFoundException;


	List<AccountDto> findAccountsByUserName(String userName);

	AccountDto login(Account account) throws AccountNotFoundException;

	String updateAccount(int userName, Account account) throws AccountNotFoundException;

	String createAccount(Account account);

}