package com.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.dao.CustomerDao;
import com.bootcamp.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("")
	public String getCustomerById(@RequestParam(value="id", defaultValue="")String id) {
		try {
			Customer customer = customerDao.getById(Integer.valueOf(id));
			if(customer == null) {
				return "Data not found";
			}else {
				return "Name : "+customer.getFirstname()+" "+customer.getLastname();
			}
		} catch (NumberFormatException e) {
			return "Wrong input format";
		} catch (Exception e) {
			return String.format("Any trouble on system : %s ", e.getMessage());
		}
	}
	
	@GetMapping("/list")
	public List<Customer> getList() throws Exception{
		List<Customer> list = customerDao.getList();
		try {
			if(list != null && list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
