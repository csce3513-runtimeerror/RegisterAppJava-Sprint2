package edu.uark.registerapp.models.api;

import org.apache.commons.lang3.StringUtils;

public class ProductSearch {
    private String lookupCode;
    public String getLookupCode() {
        return this.lookupCode;
    }
    public ProductSearch setLookupCode(final String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    public ProductSearch() {
        this.lookupCode = StringUtils.EMPTY;
    }
    
}