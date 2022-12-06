package com.zeinmahfouz.exception;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id:{0}",id));
    }

}
