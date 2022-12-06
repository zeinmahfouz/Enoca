package com.zeinmahfouz.exception;


import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(final Long id){
        super(MessageFormat.format("Could not find item with id:{0}",id));
    }
}
