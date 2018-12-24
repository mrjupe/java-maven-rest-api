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
import com.bootcamp.dao.TransactionDao;
import com.bootcamp.model.Account;
import com.bootcamp.model.Transaction;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@GetMapping("{id}")
	public Transaction getTransactionById(@PathVariable("id") String id) throws Exception{
		return transactionDao.getById(id);
	}
	
	@GetMapping("/list")
	public List<Transaction> getList(@RequestParam(name="account", defaultValue="")String id) throws Exception{
		if(!StringUtils.isEmpty(id)) {
			Account checkAccount = accountDao.getById(id);
			if(checkAccount==null) {
				throw new Exception("account tidak ditemukan");
			}
			return transactionDao.getListByAccount(checkAccount);
			
		}else {
			return transactionDao.getList();
		}
	}
	
	@PostMapping("")
	public Transaction insert(@RequestBody Transaction transaction)throws Exception{
		transactionDao.save(transaction);
		return transaction;
	}
	
	@PutMapping("")
	public Transaction update(@RequestBody Transaction transaction) throws Exception{
		Transaction update = transactionDao.save(transaction);
		return update;
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Transaction transaction) throws Exception{
		try {
			transactionDao.delete(transaction);
			return "Data berhasil dihapus";
		} catch (Exception e) {
			return "Data gagal dihaspus";
		}
	}
	
}


