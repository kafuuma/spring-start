package com.henry.springstart.repositories;

import com.henry.springstart.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
