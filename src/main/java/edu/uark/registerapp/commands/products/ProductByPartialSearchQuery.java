package edu.uark.registerapp.commands.products;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class ProductByPartialSearchQuery implements ResultCommandInterface<Product[]> {
	@Override
	public Product[] execute() {
		this.validateProperties();
		
		List<Product> products = new LinkedList<Product>();
		final List<ProductEntity> productEntities =
			this.productRepository.findByLookupCodeContainingIgnoreCase(
				this.partialSearch);
		for (ProductEntity productEntity : productEntities){
			products.add(new Product(productEntity));
		}
		return (Product[])products.toArray();
	}

	// Helper methods
	private void validateProperties() {
		if (StringUtils.isBlank(this.partialSearch)) {
			throw new UnprocessableEntityException("partialSearch");
		}
	}

	// Properties
	private String partialSearch;
	public String getPartialSearch() {
		return this.partialSearch;
	}
	public ProductByPartialSearchQuery setPartialSearch(final String partialSearch) {
		this.partialSearch = partialSearch;
		return this;
	}

	@Autowired
	private ProductRepository productRepository;
}
