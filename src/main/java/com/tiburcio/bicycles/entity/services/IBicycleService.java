package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.models.Bicycle;

public interface IBicycleService {
	public List<Bicycle> findAll();
	public List<Bicycle> getAllBicyclesByCompanyId(long companyId);
	public Bicycle findOne(long id);
	public void delete(long id);
	public void save(Bicycle bicycle);
	public void saveBicycleInCompanyByCompanyId(Bicycle bicycle, long CompanyId);
	public void update(Bicycle bicycle, long id);
}
