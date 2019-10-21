package com.goodjob.bscs.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		Gson gson = new Gson();
		JsonElement inputJson = gson.toJsonTree(criteria, CustomersSearchCriteria.class);
		HashMap<?, ?> input = gson.fromJson(inputJson, HashMap.class);
		Connection con = poolManager.getConnection();
		con.executeSessionChange("WISET");
		HashMap<String, Object> out = con.executeSoiCommand("CUSTOMERS.SEARCH", input);	
		JsonElement outputJson = gson.toJsonTree(out);
		CustomersSearchDTO outBean = gson.fromJson(outputJson, CustomersSearchDTO.class);
		poolManager.returnConnection(con);
		return outBean;
	}

}
