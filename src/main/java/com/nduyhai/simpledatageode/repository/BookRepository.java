package com.nduyhai.simpledatageode.repository;

import com.nduyhai.simpledatageode.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
