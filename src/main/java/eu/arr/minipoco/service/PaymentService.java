package eu.arr.minipoco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import eu.arr.minipoco.exception.AccountNotFoundException;
import eu.arr.minipoco.exception.InsufficientFundsOnAccountException;
import eu.arr.minipoco.mapper.AccountMapper;
import eu.arr.minipoco.mapper.PaymentMapper;
import eu.arr.minipoco.model.Account;
import eu.arr.minipoco.model.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	private static final Logger log = LogManager.getLogger(PaymentService.class);
	
	public Payment makePayment(Payment payment) throws Exception{
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
		
		try {
			initPayment(payment);
			Account sender = accountMapper.findByIban(payment.getSender().getIban());
			verifyAccount(sender);		
			verifySenderAccountBalance(sender, payment.getAmount());
			
			Account receiver = accountMapper.findByIban(payment.getReceiver().getIban());
			verifyAccount(receiver);
			
			sender.setBalance(sender.getBalance().subtract(payment.getAmount()));
			accountMapper.updateAccount(sender);
			
			receiver.setBalance(receiver.getBalance().add(payment.getAmount()));
			accountMapper.updateAccount(receiver);
			
			payment.setSender(sender);
			payment.setReceiver(receiver);
			paymentMapper.insertPayment(payment);
			
			transactionManager.commit(status);
		} catch (Exception re) {
			transactionManager.rollback(status);
			//TODO: throw more reasonable exception on data access error
			throw re;
		} 
		
		return paymentMapper.selectPayment(payment.getReferenceNo());
	}
	
	private void initPayment(Payment payment){
		//TODO: add current time to payment
		LocalDateTime currentDate = LocalDateTime.now();
		payment.setReferenceNo(generateReferenceNo(currentDate));
	}
	
	private String generateReferenceNo(LocalDateTime paymentDate){
	    Random rand = new Random();
	    int randomNum = rand.nextInt(2000);
	    
	    return paymentDate.toString() + randomNum;
	}
	
	private void verifyAccount(Account account) throws AccountNotFoundException {
		if (account == null) {
			throw new AccountNotFoundException("Insufficient funds to perform this operation");
		}		
	}
	
	private void verifySenderAccountBalance(Account sender, BigDecimal amount) throws InsufficientFundsOnAccountException {
		if (sender.getBalance().compareTo(amount) < 0) {
			throw new InsufficientFundsOnAccountException("This account is not found in the system");
		}
	}

}
