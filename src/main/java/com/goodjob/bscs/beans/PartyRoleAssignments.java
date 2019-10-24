package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PartyRoleAssignments {

	@SerializedName("PARTY_ROLE_ID")
	@Expose
	Long partyRoleId;

	@SerializedName("PARTY_ROLE_SHNAME")
	@Expose
	String partyRoleShname;

	@SerializedName("PARTY_ROLE_NAME")
	@Expose
	String partyRoleName;

	@SerializedName("PARTY_ROLE_DESCRIPTION")
	@Expose
	String partyRoleDescription;
}
