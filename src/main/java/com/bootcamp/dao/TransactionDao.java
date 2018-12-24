package com.bootcamp.dao;

import java.util.List;

import com.bootcamp.model.Account;
import com.bootcamp.model.Transaction;

public interface TransactionDao {

	Transaction getByIt(String id) throws Exception;
	Transaction save(Transaction transaction) throws Exception;
	void delete(Transaction transaction) throws Exception;
	List<Transaction> getList() throws Exception;
	List<Transaction> getListByAccount(Account account) throws Exception;
}
