package com.example.restapiforhttpclientstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class Controller {

    @Autowired
    private PersonRepository repository;

    @GetMapping()
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> create(@RequestBody Person person){
       return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }
}
