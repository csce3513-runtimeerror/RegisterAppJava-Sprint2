package edu.uark.registerapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.uark.registerapp.commands.transaction.TransactionEntryEntityQuery;

import edu.uark.registerapp.commands.products.ProductCreateCommand;
import edu.uark.registerapp.commands.products.ProductDeleteCommand;
import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.commands.products.ProductUpdateCommand;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.LineItemDisplay;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.api.Transaction; 


@Controller
@RequestMapping(value = "/transactionSummary")
public class TransactionSummaryRouteController extends BaseRouteController {
	//Handle adding items to cart
	@RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
	public ModelAndView start(
		@PathVariable final UUID transactionId,
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {
		ArrayList<Product> productsList = new ArrayList<Product>();
	   ModelAndView view = new ModelAndView(ViewNames.TRANSACTION.getViewName()); 
	   List<TransactionEntryEntity> transactionList = this.transactionEntryEntityQuery
	   		.setTransactionId(transactionId)
			   .execute();
		double price = (transactionList.get(0)).getPrice();
		Product product = new Product();
		for (int i = 0; i < transactionList.size(); i++) {
			UUID productId = (transactionList.get(i)).getProductId();
			product = productQuery.setProductId(productId).execute();
		}
		String lookupCode = product.getLookupCode();
		LineItemDisplay display = new LineItemDisplay(lookupCode, price);
	   view.addObject("displays", display);
	   view.addObject(ViewModelNames.TRANSACTION_ID.getValue(), transactionId.toString());
	   return view;
	   
   }
   @Autowired
   private TransactionEntryEntityQuery transactionEntryEntityQuery;

   @Autowired
   private ProductQuery productQuery;

}
