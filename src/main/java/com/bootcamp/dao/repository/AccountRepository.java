package com.bootcamp.dao.repository;

import java.util.List;

import com.bootcamp.model.Account;
import com.bootcamp.model.Customer;

public interface AccountRepository {

	Account findByAccountnumber(int accountnumber);
	List<Account> findByCustomer(Customer customer);
}
