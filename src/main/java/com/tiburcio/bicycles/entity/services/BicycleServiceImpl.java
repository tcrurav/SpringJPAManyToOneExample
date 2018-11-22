package com.tiburcio.bicycles.entity.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.IBicycleDao;
import com.tiburcio.bicycles.entity.dao.ICompanyDao;
import com.tiburcio.bicycles.entity.models.Bicycle;
//import com.tiburcio.bicycles.entity.models.Company;

@Service
public class BicycleServiceImpl implements IBicycleService{

	@Autowired
	private IBicycleDao bicycleDao;
	
	@Autowired
	private ICompanyDao companyDao;
	
	@Override
	public List<Bicycle> findAll() {
		return (List<Bicycle>) bicycleDao.findAll();
	}

	@Override
	public Bicycle findOne(long id) {
		return bicycleDao.findById(id).get();
	}

	@Override
	public void delete(long id) {
		bicycleDao.deleteById(id);
		
	}

	@Override
	public void save(Bicycle bicycle) {
		bicycleDao.save(bicycle);
		
	}

	@Override
	public void update(Bicycle bicycle, long id) {
		bicycleDao.findById(id).ifPresent((x)->{
			bicycle.setId(x.getId());
			bicycleDao.save(bicycle);
		});
		
	}

	@Override
	public List<Bicycle> getAllBicyclesByCompanyId(long companyId) {
		List<Bicycle> bicycles = bicycleDao.findByCompanyId(companyId);
		return bicycles;
	}

	@Override
	public void saveBicycleInCompanyByCompanyId(Bicycle bicycle, long companyId) {
		companyDao.findById(companyId).ifPresent(x->{
			bicycle.setCompany(x);
			bicycleDao.save(bicycle);
		});
		
	}

}
