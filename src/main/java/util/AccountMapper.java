package util;

import java.util.stream.Collectors;

import javax.inject.Inject;

import dto.AccountDto;
import persistence.domain.Account;

public class AccountMapper {
	
	@Inject
	private ListMapper listMapper;
	
	public AccountDto mapToDto(Account account) {
		return new AccountDto(account.getAccountId(), account.getUserName(), account.getUserPass(), account.getLists().stream().map(this.listMapper::mapToDto).collect(Collectors.toSet()));
	}
	
}
