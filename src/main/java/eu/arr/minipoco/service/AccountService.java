package eu.arr.minipoco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.arr.minipoco.mapper.AccountMapper;
import eu.arr.minipoco.model.Account;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account insertAccount(Account account) {
		accountMapper.insertAccount(account);
		
		return accountMapper.findByIban(account.getIban());
	}
	
	public Account getAccount(String iban){
		return accountMapper.findByIban(iban);
	}		
}
