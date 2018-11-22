package com.tiburcio.bicycles.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.bicycles.entity.models.Company;

public interface ICompanyDao extends CrudRepository<Company, Long>{

}
