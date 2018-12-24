package com.bootcamp.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.dao.AccountDao;
import com.bootcamp.dao.repository.AccountRepository;
import com.bootcamp.model.Account;
import com.bootcamp.model.Customer;

public class AccountDaoImpl extends BaseImpl implements AccountDao {

	@Autowired
	private AccountRepository repository;
	
	@Override
	public Account getById(String id) throws Exception {
		return repository.findOne(Integer.valueOf(id));
	}

	@Override
	public Account save(Account account) throws Exception {
		return repository.save(account);
	}

	@Override
	public void delete(Account account) throws Exception {
		repository.delete(account);
	}

	@Override
	public List<Account> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Account> query = critB.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		
		TypedQuery<Account> tq = em.createQuery(query);
		return tq.getResultList();
	}

	@Override
	public List<Account> getListByCustomer(Customer customer) throws Exception {
		return repository.findByCustomer(customer);
	}

}
