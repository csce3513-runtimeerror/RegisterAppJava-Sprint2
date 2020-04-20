package edu.uark.models.repositories;

import java.sql.SQLException;
import edu.uark.models.entities.TransactionEntity;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface 
{
	@Override
	public TransactionEntity byLookupCode(String lookupCode) 
	{
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.LOOKUP_CODE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, lookupCode.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public TransactionEntity createOne() {
		return new TransactionEntity();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}

	@Override
	public TransactionEntity byTransaction_Num(String transaction_num) 
	{
		// TODO Auto-generated method stub
		return null;
	}

    // TODO: Connect to database
}