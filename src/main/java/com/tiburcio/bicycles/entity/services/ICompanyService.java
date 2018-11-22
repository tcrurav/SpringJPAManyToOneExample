package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.models.Company;

public interface ICompanyService {
	public List<Company> findAll();
	public Company findOne(long id);
	public void delete(long id);
	public void save(Company bicycle);
	public void update(Company bicycle, long id);
}
