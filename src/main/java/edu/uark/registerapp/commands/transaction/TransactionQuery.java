package edu.uark.registerapp.commands.transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.repositories.TransactionRepository;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.TransactionEntity;
import java.util.Optional;
@Service
public class TransactionQuery implements ResultCommandInterface<Transaction> 
{
	@Override
	public Transaction execute() {
		final Optional <TransactionEntity> transactionEntity =
			this.transactionRepository.findById(this.transactionId);
		if (transactionEntity.isPresent()) {
			return new Transaction(transactionEntity.get());
		} else {
			throw new NotFoundException("Transaction");
		}
	}

	// Properties
	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionQuery setEmployeeId(final UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}

	@Autowired
	private TransactionRepository transactionRepository;
	
}