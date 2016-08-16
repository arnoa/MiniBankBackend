package eu.arr.minipoco.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import eu.arr.minipoco.model.Account;
import eu.arr.minipoco.model.Payment;

public interface PaymentMapper {
	
	@Insert("INSERT INTO payment(amount, sender, receiver, payment_date, reference_no, details)"
			+ "VALUES(#{amount}, #{sender.id}, #{receiver.id}, #{paymentDate}, #{referenceNo}, #{details})")
	void insertPayment(Payment payment);
	
	@Select("SELECT * FROM payment WHERE reference_no = #{referenceNo}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="amount", column="amount"),
		@Result(property="referenceNo", column="reference_no"),
		@Result(property="sender", column="sender", javaType=Account.class, 
		one=@One(select="eu.arr.minipoco.mapper.AccountMapper.findById")),
		@Result(property="receiver", column="receiver", javaType=Account.class, 
		one=@One(select="eu.arr.minipoco.mapper.AccountMapper.findById")),
	})
	Payment selectPayment(String referenceNo);
}
