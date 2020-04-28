package edu.uark.registerapp.models.api;

import java.util.UUID;
import edu.uark.registerapp.models.entities.TransactionEntity;

public class Transaction 
{
	private UUID id;
	public UUID getId() 
	{
		return this.id;
	}
	public Transaction setId(UUID id) 
	{
		this.id = id;
		return this;
	}
	
	private int transaction_num;
	public int getTransaction_Num() 
	{
		return this.transaction_num;
	}
	public Transaction setTransaction_Num(int transaction_num) 
	{
		this.transaction_num = transaction_num;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public Transaction setLookupCode(String lookupCode) 
	{
		this.lookupCode = lookupCode;
		return this;
	}	

	
	
	public Transaction(TransactionEntity transactionEntity) 
	{
		this.id = transactionEntity.getId();
		this.transaction_num = transactionEntity.getTransaction_Num();
		this.lookupCode = transactionEntity.getLookupCode();

	
	}
}
