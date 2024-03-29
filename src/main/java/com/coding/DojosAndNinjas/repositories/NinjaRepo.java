package com.coding.DojosAndNinjas.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.coding.DojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}