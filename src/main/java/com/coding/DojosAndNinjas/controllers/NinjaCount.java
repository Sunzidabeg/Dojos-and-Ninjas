package com.coding.DojosAndNinjas.controllers;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.DojosAndNinjas.models.Ninja;
import com.coding.DojosAndNinjas.services.DojoNinjaServ;

@Controller
public class NinjaCount {
	private final DojoNinjaServ DojoNinjaServ;
	
	public NinjaCount(DojoNinjaServ DojoNinjaServ) {
		this.DojoNinjaServ = DojoNinjaServ;
	}

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObject") Ninja Ninja, Model model) {
		model.addAttribute("dojos", DojoNinjaServ.getAllDojos());
		return "/DojosAndNinjas/newninja.jsp";
	}
	
	@PostMapping("/addninja")
	public String addNinja(@Valid @ModelAttribute("ninjaObject") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/DojosAndNinjas/newninja.jsp";
		}
		else {
			DojoNinjaServ.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId() ;
		}
	}
}