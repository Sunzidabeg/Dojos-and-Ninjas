package com.coding.DojosAndNinjas.repositories;

import javax.print.Doc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepo extends CrudRepository<Doc, Long>{
	Iterable<Doc> findAll();
}