package com.goodjob.bscs.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodjob.bscs.beans.AddressWriteInput;
import com.goodjob.bscs.beans.AddressWriteOutput;
import com.goodjob.bscs.beans.Addresses;
import com.goodjob.bscs.beans.AddressesReadInput;
import com.goodjob.bscs.soi.Connection;
import com.goodjob.bscs.soi.ConnectionPoolManager;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@RestController
@RequestMapping("/bscs_rest/v3")
public class AddressController {
	
	
	@Autowired
	ConnectionPoolManager poolManager;
	
	@PostMapping("/address")
	public AddressWriteOutput searchCustomers(@RequestBody AddressWriteInput input) throws Exception {
		Gson gson = new Gson();
		Connection con = poolManager.getConnection();
		con.executeSessionChange("WISET");
		HashMap<String, Object> out = con.executeSoiCommand("ADDRESS.WRITE", input);	
		JsonElement outputJson = gson.toJsonTree(out);
		AddressWriteOutput outBean = gson.fromJson(outputJson, AddressWriteOutput.class);
		con.commit();
		poolManager.returnConnection(con);
		return outBean;
	}
	
	@GetMapping("/address")
	public Addresses getAddresses(@RequestBody AddressesReadInput input) throws Exception{
		Gson gson = new Gson();
		Connection con = poolManager.getConnection();
		con.executeSessionChange("WISET");
		HashMap<String, Object> out = con.executeSoiCommand("ADDRESSES.READ", input);	
		JsonElement outputJson = gson.toJsonTree(out);
		Addresses outBean = gson.fromJson(outputJson, Addresses.class);
		poolManager.returnConnection(con);
		return outBean;
	}

}
