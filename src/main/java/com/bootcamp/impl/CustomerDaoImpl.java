package com.bootcamp.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bootcamp.dao.CustomerDao;
import com.bootcamp.dao.repository.CustomerRepository;
import com.bootcamp.model.Customer;

public class CustomerDaoImpl extends BaseImpl implements CustomerDao {

	private CustomerRepository repository;
	
	@Override
	public Customer getById(int id) throws Exception {
		return repository.findOne(id);
	}

	@Override
	public Customer save(Customer customer) throws Exception {
		return repository.save(customer);
	}

	@Override
	public void delete(Customer customer) throws Exception {
		repository.delete(customer);
	}

	@Override
	public List<Customer> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Customer> query = critB.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		
		TypedQuery<Customer> tq = em.createQuery(query);
		return tq.getResultList();
	}
	
	
}
