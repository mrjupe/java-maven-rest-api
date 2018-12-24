package com.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.dao.AccountDao;
import com.bootcamp.dao.CustomerDao;
import com.bootcamp.model.Account;
import com.bootcamp.model.Customer;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("{accountnumber}")
	public Account getAccountById(@PathVariable("accountnumber") String accountnumber) throws Exception{
		return accountDao.getById(accountnumber);
	}
	
	@GetMapping("/list")
	public List<Account> getList(@RequestParam(name="customer", defaultValue="") String customer) throws NumberFormatException, Exception{
		if(!StringUtils.isEmpty(customer)) {
			Customer checkCustomer = customerDao.getById(Integer.valueOf(customer));
			if(checkCustomer == null) {
				throw new Exception("Customer not found");
			}
			return accountDao.getListByCustomer(checkCustomer);
		}else {
			return accountDao.getList();
		}
	}
	
	@PostMapping("")
	public Account insert(@RequestBody Account account) throws Exception{
		accountDao.save(account);
		return account;
	}
	
	@PutMapping("")
	public Account update(@RequestBody Account account) throws Exception{
		Account update = accountDao.save(account);
		return update;
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Account account) throws Exception{
		try {
			accountDao.delete(account);
			return "Delete success";
		} catch (Exception e) {
			return "Delete failed";
		}
	}
}
