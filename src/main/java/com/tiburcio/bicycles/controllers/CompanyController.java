package com.tiburcio.bicycles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiburcio.bicycles.entity.models.Company;
import com.tiburcio.bicycles.entity.services.ICompanyService;

@CrossOrigin(origins = "*")
@RestController
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;
	
	@GetMapping("/company/{id}")
	public Company getCompany(@PathVariable(value = "id") Long id) {
		return companyService.findOne(id);
	}
	
	@GetMapping("/companies")
	public List<Company> getAllCompany(){
		return companyService.findAll();
	}
	
	@PostMapping("/company")
	public void save(Company company) {
		companyService.save(company);
	}
	
	@DeleteMapping("/company/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		companyService.delete(id);
	}
	
	@PutMapping("/company/{id}")
	public void update(Company company, @PathVariable(value = "id") long id) {
		System.out.println("controller antes: " + company.toString());
		companyService.update(company, id);
		System.out.println("controller después: " + company.toString());
	}
}
