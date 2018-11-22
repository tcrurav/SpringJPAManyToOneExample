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

import com.tiburcio.bicycles.entity.models.Bicycle;
import com.tiburcio.bicycles.entity.services.IBicycleService;

@CrossOrigin(origins = "*")
@RestController
public class BicycleController {
	
	@Autowired
	private IBicycleService bicycleService;
	
	@GetMapping("/bicycle/{id}")
	public Bicycle getBicycle(@PathVariable(value = "id") Long id) {
		return bicycleService.findOne(id);
	}
	
	@GetMapping("/company/{companyId}/bicycles")
    public List<Bicycle> getAllBicyclesByCompanyId(@PathVariable (value = "companyId") Long companyId) {
        return bicycleService.getAllBicyclesByCompanyId(companyId);
    }
	
	@GetMapping("/bicycles")
	public List<Bicycle> getAllBicycles(){
		return bicycleService.findAll();
	}
	
	@PostMapping("/bicycle")
	public void save(Bicycle bicycle) {
		bicycleService.save(bicycle);
	}
	
	@PostMapping("/company/{companyId}/bicycle")
	public void save(Bicycle bicycle, @PathVariable (value = "companyId") Long companyId) {
		bicycleService.saveBicycleInCompanyByCompanyId(bicycle, companyId);
	}
	
	@DeleteMapping("/bicycle/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		bicycleService.delete(id);
	}
	
	@PutMapping("/bicycle/{id}")
	public void update(Bicycle bicycle, @PathVariable(value = "id") long id) {
		System.out.println("controller antes: " + bicycle.toString());
		bicycleService.update(bicycle, id);
		System.out.println("controller después: " + bicycle.toString());
	}
}
