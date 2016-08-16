package eu.arr.minipoco.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import eu.arr.minipoco.model.Account;

public interface AccountMapper {
	
	@Select("SELECT * FROM account WHERE iban = #{iban}")
	Account findByIban(String iban);
	
	@Select("SELECT * FROM account WHERE id = #{id}")
	Account findById(String id);
	
	@Insert("INSERT INTO account(name, iban, balance, currency)"
			+ "VALUES(#{name}, #{iban}, #{balance}, #{currency})")
	void insertAccount(Account account);
	
	//TODO: add all fields
	@Update("UPDATE account SET balance = #{balance} where iban = #{iban}")
	void updateAccount(Account account);
}
