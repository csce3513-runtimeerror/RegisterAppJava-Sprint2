package edu.uark.registerapp.commands.products;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.api.ProductSearch;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class ProductSearchCommand implements ResultCommandInterface<Product> {

    @Override
	public Product execute() {
        // TODO Auto-generated method stub
        
        //Figure out partial search
        //Possibly involving productby(partial)lookupcodequery.java classes
		return null;
    }

    //Properties
    private ProductSearch productSearch;
    public ProductSearch getProductSearch() {
        return this.productSearch;
    }
    public ProductSearchCommand setProductSearch(final ProductSearch productSearch) {
        this.productSearch = productSearch;
        return this;
    }

    private String sessionID;
    public String getSessionID() {
        return this.sessionID;
    }
    public ProductSearchCommand setSessionID(final String sessionID) {
        this.sessionID = sessionID;
        return this;
    }

    @Autowired
    private ProductRepository productRepository;
}