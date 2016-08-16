package eu.arr.minipoco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Payment implements Serializable{

	private static final long serialVersionUID = 1202204055575277570L;
	
	private int id;
	private BigDecimal amount;
	private Account sender;
	private Account receiver;
	private Date paymentDate;
	private String referenceNo;
	private String details;
	
	public int getPaymentId() {
		return id;
	}
	public void setPaymentId(int paymentId) {
		this.id = paymentId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	public Account getReceiver() {
		return receiver;
	}
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
