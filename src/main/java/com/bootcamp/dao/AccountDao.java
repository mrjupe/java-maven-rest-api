package com.bootcamp.dao;

import java.util.List;

import com.bootcamp.model.Account;
import com.bootcamp.model.Customer;

public interface AccountDao {

	Account getById(String id) throws Exception;
	Account save(Account account) throws Exception;
	void delete(Account account) throws Exception;
	
	List<Account> getList() throws Exception;
	List<Account> getListByCustomer(Customer customer) throws Exception;
}
