package edu.uark.registerapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.uark.registerapp.controllers.enums.ViewNames;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionSummaryRouteController extends BaseRouteController {
	//Handle adding items to cart
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {
	   return new ModelAndView(ViewNames.TRANSACTION.getViewName()); 
	   
	   Product product = this.getItem(position);
	   if (product != null) {
		   TextView lookupCodeTextView = (TextView) view.findViewById(R.id.list_view_item_product_lookup_code);
		   if (lookupCodeTextView != null) {
			   lookupCodeTextView.setText(product.getLookupCode());
		   }

		   TextView countTextView = (TextView) view.findViewById(R.id.list_view_item_product_count);
		   if (countTextView != null) {
			   countTextView.setText(String.format(Locale.getDefault(), "%d", product.getCount()));
		   }
	   }

	   return view;
   }

	}

}