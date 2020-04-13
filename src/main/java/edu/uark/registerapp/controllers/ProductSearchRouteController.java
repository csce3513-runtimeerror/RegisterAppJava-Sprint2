package edu.uark.registerapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.products.ProductByLookupCodeQuery;
import edu.uark.registerapp.commands.products.ProductByPartialLookupCodeQuery;
import edu.uark.registerapp.commands.products.ProductSearchCommand;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ProductSearch;


@Controller
@RequestMapping(value = "/productSearch")

public class ProductSearchRouteController extends BaseController {
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView performProductSearch(ProductSearch productSearch,
    HttpServletRequest request) {
        try {
            this.productSearchCommand
                    .setSessionID(request.getSession().getId())
                    .setProductSearch(productSearch)
                    .execute();
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView(ViewNames.PRODUCT_SEARCH.getViewName());
            modelAndView.addObject(ViewModelNames.PRODUCT.getValue(),productSearch.getLookupCode());
            return modelAndView;
            //NOT COMPLETE:: add whatever needed that I can't figure out at the current moment
        }
        return new ModelAndView();
    }
	
    @Autowired
    private ProductSearchCommand productSearchCommand;
    @Autowired
    private ProductByLookupCodeQuery productByLookupCodeQuery;
    @Autowired
    private ProductByPartialLookupCodeQuery productByPartialLookupCodeQuery;
}
