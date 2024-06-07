package com.example.restapiforhttpclientstudy;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitBean {
    @Autowired
    private PersonRepository repository;
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++){
            repository.save(new Person());
        }

    }
}
