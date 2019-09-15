package com.coding.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.DojosAndNinjas.models.Dojo;
import com.coding.DojosAndNinjas.models.Ninja;
import com.coding.DojosAndNinjas.repositories.DojoRepo;
import com.coding.DojosAndNinjas.repositories.NinjaRepo;

@Service
public class DojoNinjaServ {
	private final DojoRepo DojoRepo;
	private final NinjaRepo NinjaRepo;
	
	public DojoNinjaServ(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.DojoRepo = dojoRepo;
		this.NinjaRepo = ninjaRepo;
	}

	public void addDojo(Dojo dojo) {
		DojoRepo.save(dojo);
	}
	
	public List<Dojo> getAllDojos() {
		return DojoRepo.findAll();
	}
	
	public Dojo singleDojo(Long id) {
		Optional<Dojo> dojo = DojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	public void addNinja(Ninja ninja) {
		Ninja.save(ninja);
	}
}