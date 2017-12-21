package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jpa.entity.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer>{
	
}