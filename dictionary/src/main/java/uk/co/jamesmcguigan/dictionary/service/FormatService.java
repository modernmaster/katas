package uk.co.jamesmcguigan.dictionary.service;

import org.springframework.stereotype.Service;

@Service
public class FormatService implements StringFormat {
    @Override
    public String toTitleCase(String value){
        return value.substring(0,1).toUpperCase()+value.substring(1).toLowerCase();
    }
}
