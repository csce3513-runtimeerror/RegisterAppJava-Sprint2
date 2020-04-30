package edu.uark.registerapp.commands.transaction;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.models.api.TransactionEntryCreate;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;

@Service
public class TransactionEntryCreateCommand {
	@Transactional
	public void execute() {
		final Optional<TransactionEntryEntity> entryEntity =
			this.transactionEntryRepository.findByTransactionIdAndProductId(
				this.createData.getTransactionId(),
				this.createData.getProductId());

			if (entryEntity.isPresent()) {
				entryEntity.get().setQuantity(
					entryEntity.get().getQuantity() + 1);

				this.transactionEntryRepository.save(entryEntity.get());
			} else {
				final Optional<ProductEntity> productEntity = this.productRepository.findById(
					this.createData.getProductId());

				final TransactionEntryEntity newTransactionEntryEntity =
					(new TransactionEntryEntity())
						.setPrice(productEntity.get().getPrice())
						.setProductId(this.createData.getProductId())
						.setQuantity(1)
						.setTransactionId(this.createData.getTransactionId())
						.setItemName(productEntity.get().getLookupCode());
				this.transactionEntryRepository.save(newTransactionEntryEntity);
			}
	}

	private TransactionEntryCreate createData;
	public TransactionEntryCreateCommand setCreateData(TransactionEntryCreate createData) {
		this.createData = createData;
		return this;
	}

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TransactionEntryRepository transactionEntryRepository;
}