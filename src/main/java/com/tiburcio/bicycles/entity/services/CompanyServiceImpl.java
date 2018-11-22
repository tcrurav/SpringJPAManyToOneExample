package com.tiburcio.bicycles.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.ICompanyDao;
import com.tiburcio.bicycles.entity.models.Company;

@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	private ICompanyDao companyDao;
	
	@Override
	public List<Company> findAll() {
		return (List<Company>) companyDao.findAll();
	}

	@Override
	public Company findOne(long id) {
		return companyDao.findById(id).get();
	}

	@Override
	public void delete(long id) {
		companyDao.deleteById(id);
		
	}

	@Override
	public void save(Company company) {
		companyDao.save(company);
		
	}

	@Override
	public void update(Company company, long id) {
		companyDao.findById(id).ifPresent((x)->{
			company.setId(x.getId());
			companyDao.save(company);
		});
		
	}

}
