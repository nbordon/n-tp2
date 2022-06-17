package com.neoris.tp2.exceptions;

public class ResourcesNotFoundException extends Exception {
    public ResourcesNotFoundException(){
        super();
    }

    public ResourcesNotFoundException(String message){
        super(message);
    }
}
