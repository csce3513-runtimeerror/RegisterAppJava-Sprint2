package edu.uark.registerapp.models.entities;
import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import edu.uark.registerapp.models.api.Transaction;



@Entity
@Table(name="transaction")

public class TransactionEntity 
{
	@Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}

	@Column(name = "lookupcode")
	private String lookupCode;

	public String getLookupCode() {
		return this.lookupCode;
	}

	public TransactionEntity setLookupCode(final String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	@Column(name = "transaction_num")
	
	private int transaction_num;

	public int getTransaction_Num() {
		return this.transaction_num;
	}

	public TransactionEntity setTransaction_Num(final int transaction_num) {
		this.transaction_num = transaction_num;
		return this;
	}

	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public Transaction synchronize(final Transaction apiTransaction) {
		this.setLookupCode(apiTransaction.getLookupCode());

		apiTransaction.setId(this.getId());
		apiTransaction.setTransaction_Num(this.getTransaction_Num());

		return apiTransaction;
	}
	public TransactionEntity() {
		this.transaction_num = -1;
		this.id = new UUID(0, 0);
		this.lookupCode = StringUtils.EMPTY;
	}


	public TransactionEntity(final String lookupCode, final int transaction_num) {
		this.transaction_num = transaction_num;
		this.id = new UUID(0, 0);
		this.lookupCode = lookupCode;
	}

	 public TransactionEntity(final Transaction apiTransaction) {
     	this.id = new UUID(0, 0);
	 	this.transaction_num = apiTransaction.getTransaction_Num();
		this.lookupCode = apiTransaction.getLookupCode();
	 }
}

