package edu.uark.registerapp.commands.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;
@Service
public class TransactionEntryEntityQuery {
    // @Override
    public List<TransactionEntryEntity> execute() {
        final List<TransactionEntryEntity> transactionEntryEntity =
            this.transactionEntryRepository.findByTransactionId(this.transactionId);
        return transactionEntryEntity;
    }
    private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	@Autowired
	private TransactionEntryRepository transactionEntryRepository;
}