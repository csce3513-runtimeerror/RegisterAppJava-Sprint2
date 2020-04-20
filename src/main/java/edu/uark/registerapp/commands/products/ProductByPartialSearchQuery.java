package edu.uark.registerapp.commands.products;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class ProductByPartialSearchQuery implements ResultCommandInterface<Product> {

	@Override
	public Product execute() {
		this.validateProperties();

		final List<Product> products = new LinkedList<Product>();
		final List<ProductEntity> productEntity = this.productRepository
				.findByLookupCodeContainingIgnoreCase(this.getPartialSearch());
		// if (productEntity.isPresent()) {
		// return new Product(productEntity.get());
		// } else {
		// throw new NotFoundException("Product");
		// }
		// for (ProductEntity productEntity : productEntites) {
		// products.add(new Product(productEntity));
		// }
		// return (Product[])products toArray();
		return this.productRepository.findByLookupCodeContainingIgnoreCase(this.partialSearch.stream()
				.map(productEntity -> (new Product(productEntity))).toArray(Product[]::new);
	}

	// Helper methods
	public void validateProperties() {
		if (StringUtils.isBlank(this.getPartialSearch())) {
			throw new UnprocessableEntityException("partialSearch");
		}
	}

	// Properties
	private String partialLookupCode;

	public String getPartialSearch() {
		return this.getPartialSearch();
	}

	public ProductByPartialSearchQuery setPartialSearchQuery(final String partialSearch) {
		this.partialSearch = partialSearch;
		return this;
	}

	@Autowired
	private ProductRepository productRepository;
}