package edu.uark.registerapp.commands.transaction;
import java.util.UUID;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.repositories.TransactionRepository;

public class TransactionQuery implements ResultCommandInterface<Transaction> 
{.
	@Override
	public Transaction execute() 
	{
		return new Transaction(
			this.transactionRepository.get(this.transactionId)
		);
	}

	//Properties
	private UUID transactionId;
	public UUID getTransactionId() 
	{
		return this.transactionId;
	}
	
	public TransactionQuery setTransactionId(UUID transactionId) 
	{
		this.transactionId = transactionId;
		return this;
	}
	

	public TransactionQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) 
	{
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionQuery() 
	{
		this.transactionRepository = new TransactionRepository();
	}

    //TODO: TransactionRepositoryInterface
}