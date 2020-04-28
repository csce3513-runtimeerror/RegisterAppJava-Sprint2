
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;



public class PTransition  {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public PTransition setId(UUID id) {
		this.id = id;
		return this;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public PTransition setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public PTransition setCount(int count) {
		this.count = count;
		return this;
	}

	private Date createdOn;
	public Date getCreatedOn() {
		return this.createdOn;
	}
	public PTransition setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
		return this;
	}

		public PTransition[] newArray(int size) {
			return new PTransition[size];
		}
	};

	public PTransition() {
		this.count = -1;
		this.id = new UUID(0, 0);
		this.createdOn = new Date();
		this.lookupCode = StringUtils.EMPTY;
	}

	public PTransition(P product) { 
		this.id = product.getId();
		this.count = product.getCount();
		this.createdOn = product.getCreatedOn();
		this.lookupCode = product.getLookupCode();
	}

	
}