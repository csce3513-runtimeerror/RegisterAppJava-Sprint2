package edu.uark.registerapp.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.uark.registerapp.commands.products.ProductsQuery;
import edu.uark.registerapp.models.api.Product;

@Controller
@RequestMapping(value = "/productSearch")

public class ProductSearchRouteController extends BaseController {
    @RequestMapping(method = RequestMethod.GET)
	
	
}
