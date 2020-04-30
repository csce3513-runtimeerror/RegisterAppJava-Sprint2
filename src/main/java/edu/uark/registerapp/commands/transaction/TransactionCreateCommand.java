package edu.uark.registerapp.commands.transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class TransactionCreateCommand implements ResultCommandInterface<UUID> {
	@Override
	public UUID execute() {
		final TransactionEntity transactionEntity =
			this.transactionRepository.save(
				(new TransactionEntity())
					.setCashierId(this.cashierId));

		return transactionEntity.getId();
	}

	private UUID cashierId;
	public TransactionCreateCommand setCashierId(UUID cashierId) {
		this.cashierId = cashierId;
		return this;
	}

	@Autowired
	private TransactionRepository transactionRepository;
}
