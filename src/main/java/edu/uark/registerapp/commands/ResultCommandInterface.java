package edu.uark.registerapp.commands;

import edu.uark.registerapp.models.api.Product;

public interface ResultCommandInterface<T> {
	Product execute();
}
