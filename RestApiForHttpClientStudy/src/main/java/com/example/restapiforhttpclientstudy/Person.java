package com.example.restapiforhttpclientstudy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String middleName;

    private String lastName;


    public Person(){
        this.name = RandomStringUtils.randomAlphabetic(5);
        this.lastName = RandomStringUtils.randomAlphabetic(7);
        this.middleName = RandomStringUtils.randomAlphabetic(6);
    }

}
