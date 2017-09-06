package com.nduyhai.simpledatageode.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@Region("book")
public class Book implements Serializable {
    @Id
    private Integer id;

    private String name;

    public Book() {
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
