package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.entities.TransactionEntity;

public class Transaction extends ApiResponse {
	private UUID id;
	public UUID getId() 
	{
		return this.id;
	}
	public Transaction setId(final UUID id) 
	{
		this.id = id;
		return this;
	}

	private UUID cashierId;
	public Transaction setCashierId(final UUID id){
		this.cashierId = id;
		return this;
	}
	public UUID getCashierId(){
		return this.cashierId;
	}

	private int total;
	public int getTotal(){
		return this.total;
	}
	public Transaction setTotal(final int t){
		this.total = t;
		return this;
	}

	private int transactionType;
	public int getTransactionType(){
		return this.transactionType;
	}
	public Transaction setTransactionType(final int tr){
		this.transactionType = tr;
		return this;
	}

	private UUID transactionReferenceId;
	public UUID getTranscationReferenceId(){
		return this.transactionReferenceId;
	}
	public Transaction setTransactionReferenceId(final UUID ref){
		this.transactionReferenceId = ref;
		return this;
	}

	private String createdOn;

	public String getCreatedOn() {
		return this.createdOn;
	}

	public Transaction setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Transaction setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn =
			createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		return this;
	}
	
	//private int transaction_num;
	//public int getTransaction_Num() 
	//{
	//	return this.transaction_num;
	//}
	//public Transaction setTransaction_Num(int transaction_num) 
	//{
	//	this.transaction_num = transaction_num;
	//	return this;
	//}
	
	/*private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public Transaction setLookupCode(String lookupCode) 
	{
		this.lookupCode = lookupCode;
		return this;
	}*/

	public Transaction(){
		super();

		this.id = new UUID(0,0);
		this.cashierId = new UUID(0,0);
		this.total = 0;
		this.transactionType = 0;
		this.transactionReferenceId = new UUID(0,0);
		this.setCreatedOn(LocalDateTime.now());


	}
	
	public Transaction(final TransactionEntity transactionEntity) {
		super(false);

		this.id = transactionEntity.getId();
		this.cashierId = transactionEntity.getCashierId();
		this.total = (int) transactionEntity.getTotal();
		this.transactionType = transactionEntity.getType();
		this.transactionReferenceId = transactionEntity.getReferenceId();

		this.setCreatedOn(transactionEntity.getCreatedOn());
		//this.transaction_num = -1; // TODO
		//this.lookupCode = transactionEntity.getLookupCode(); // TODO

	
	}
}