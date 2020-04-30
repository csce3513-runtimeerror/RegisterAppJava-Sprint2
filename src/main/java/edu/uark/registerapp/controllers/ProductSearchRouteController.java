package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.products.ProductByPartialSearchQuery;
import edu.uark.registerapp.commands.products.ProductsQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.api.ProductSearch;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/mainMenu/productSearch")
//@RequestMapping(value = "/productSearch/{transactionId}")
public class ProductSearchRouteController extends BaseRouteController {
    @RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
    //@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSearch(
        @RequestParam final UUID transactionId,
        @RequestParam final Map<String, String> queryParameters,
        final HttpServletRequest request
    ) {
        final Optional<ActiveUserEntity> activeUserEntity =
        this.getCurrentUser(request);
         if (!activeUserEntity.isPresent()) {
            return buildInvalidSessionResponse();
        }

        try {
            this.productByPartialSearchQuery.execute();
        } catch (final NotFoundException e) {
            return new ModelAndView(REDIRECT_PREPEND.concat(
                ViewNames.PRODUCT_LISTING.getRoute()));
        }

        final ModelAndView modelAndView = this.setErrorMessageFromQueryString(
            new ModelAndView(ViewNames.PRODUCT_SEARCH.getViewName()), 
            queryParameters);

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				this.productsQuery.execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCTS.getValue(),
				(new Product[0]));
        }

        //modelAndView.addObject("transactionId", transactionId);

        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView performProductSearch(final ProductSearch productSearch,
    final HttpServletRequest request) {
        /*try {
            this.
                    .setSessionID(request.getSession().getId())
                    .setProductSearch(productSearch)
                    .execute();
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(
                ViewNames.PRODUCT_SEARCH.getViewName()
            );
            modelAndView.addObject(ViewModelNames.ERROR_MESSAGE.getValue(),
            e.getMessage());
            modelAndView.addObject( 
                ViewModelNames.PRODUCT_SEARCH.getValue(),
                productSearch.getLookupCode()
            );
            return modelAndView;
        }*/        
        return new ModelAndView(REDIRECT_PREPEND.concat(
            ViewNames.PRODUCT_LISTING.getRoute())
        );
    }
    
    
    //Properties
	@Autowired
    private ProductsQuery productsQuery;

    @Autowired
    private ProductByPartialSearchQuery productByPartialSearchQuery;
}