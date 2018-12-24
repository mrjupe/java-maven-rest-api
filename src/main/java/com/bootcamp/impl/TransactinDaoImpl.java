package com.bootcamp.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.dao.TransactionDao;
import com.bootcamp.dao.repository.TransactionRepository;
import com.bootcamp.model.Account;
import com.bootcamp.model.Transaction;

public class TransactinDaoImpl extends BaseImpl implements TransactionDao {

	@Autowired
	private TransactionRepository repository;
	
	@Override
	public Transaction getByIt(String id) throws Exception {
		return repository.findOne(Integer.valueOf(id));
	}

	@Override
	public Transaction save(Transaction transaction) throws Exception {
		return repository.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) throws Exception {
		repository.delete(transaction);
		
	}

	@Override
	public List<Transaction> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> query = critB.createQuery(Transaction.class);
		Root<Transaction> root = query.from(Transaction.class);
		
		TypedQuery<Transaction> tq = em.createQuery(query);
		return tq.getResultList();
	}

	@Override
	public List<Transaction> getListByAccount(Account account) throws Exception {
		return repository.findByAccount(account);
	}

	
}
