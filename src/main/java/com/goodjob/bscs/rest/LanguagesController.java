package com.goodjob.bscs.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodjob.bscs.beans.LanguagesReadDTO;
import com.goodjob.bscs.soi.Connection;
import com.goodjob.bscs.soi.ConnectionPoolManager;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@RestController
@RequestMapping("/bscs_rest/v3")
public class LanguagesController {
	
	@Autowired
	ConnectionPoolManager poolManager;
	
	@RequestMapping("/language")
	public LanguagesReadDTO getLanguages() throws Exception {
		Connection con = poolManager.getConnection();
		HashMap<String, Object> out = con.executeSoiCommand("LANGUAGES.READ", null);
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(out);
		LanguagesReadDTO outBean = gson.fromJson(jsonElement, LanguagesReadDTO.class);
		poolManager.returnConnection(con);
		return outBean;
	}

}
