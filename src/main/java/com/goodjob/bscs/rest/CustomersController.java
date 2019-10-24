package com.goodjob.bscs.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodjob.bscs.beans.Customer;
import com.goodjob.bscs.beans.CustomerReadInput;
import com.goodjob.bscs.beans.CustomersSearchCriteria;
import com.goodjob.bscs.beans.CustomersSearchDTO;
import com.goodjob.bscs.soi.Connection;
import com.goodjob.bscs.soi.ConnectionPoolManager;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@RestController
@RequestMapping("/bscs_rest/v3")
public class CustomersController {
	
	
	@Autowired
	ConnectionPoolManager poolManager;
	
	@RequestMapping("/customers")
	public CustomersSearchDTO searchCustomers(@RequestBody CustomersSearchCriteria criteria) throws Exception {	
		Connection con = poolManager.getConnection();
		con.executeSessionChange("WISET");
		HashMap<String, Object> out = con.executeSoiCommand("CUSTOMERS.SEARCH", criteria);	
		Gson gson = new Gson();
		JsonElement outputJson = gson.toJsonTree(out);
		CustomersSearchDTO outBean = gson.fromJson(outputJson, CustomersSearchDTO.class);
		poolManager.returnConnection(con);
		return outBean;
	}
	
	@GetMapping(value = "/customer")
	public Customer getCustomer(@RequestBody CustomerReadInput input)throws Exception{	
		Connection con = poolManager.getConnection();
		con.executeSessionChange("WISET");
		HashMap<String, Object> out = con.executeSoiCommand("CUSTOMER.READ", input);
		Gson gson = new Gson();
		JsonElement outputJson = gson.toJsonTree(out);
		Customer outBean = gson.fromJson(outputJson, Customer.class);
		poolManager.returnConnection(con);
		return outBean;
	}

}
