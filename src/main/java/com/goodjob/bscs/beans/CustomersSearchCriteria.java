package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CustomersSearchCriteria {

	@SerializedName("IGNORE_BU_IND")
	@Expose
	Boolean ignoreBuInd;

	@SerializedName("CS_ID_HIGH")
	@Expose
	Long csIdHigh;

	@SerializedName("CS_ID_HIGH_PUB")
	@Expose
	String csIdHighPub;

	@SerializedName("ADR_STATE")
	@Expose
	String adrState;

	@SerializedName("COUNTRY_ID")
	@Expose
	Long countryId;

	@SerializedName("COUNTRY_ID_PUB")
	@Expose
	String countryIdPub;

	@SerializedName("EXTERNAL_CUSTOMER_ID")
	@Expose
	String externalCustomerId;

	@SerializedName("EXTERNAL_CUSTOMER_SET_ID")
	@Expose
	String externalCustomerSetId;

	@SerializedName("CS_CODE")
	@Expose
	String csCode;

	@SerializedName("CS_ID_PUB")
	@Expose
	String csIdPub;

	@SerializedName("CS_DEALERID")
	@Expose
	Long csDealerid;

	@SerializedName("CS_DEALERID_PUB")
	@Expose
	String csDealeridPub;

	@SerializedName("CS_STATUS")
	@Expose
	String csStatus;

	@SerializedName("CS_LEVEL_CODE")
	@Expose
	String csLevelCode;

	@SerializedName("ADR_SOCIALSENO")
	@Expose
	String adrSocialseno;

	@SerializedName("ADR_DRIVELICENCE")
	@Expose
	String adrDrivelicence;

	@SerializedName("ADR_PASSPORTNO")
	@Expose
	String adrPassportno;

	@SerializedName("ADR_COMPNO")
	@Expose
	String adrCompno;

	@SerializedName("ADR_TAXNO")
	@Expose
	String adrTaxno;

	@SerializedName("PRG_CODE")
	@Expose
	String prgCode;

	@SerializedName("RPCODE")
	@Expose
	Long rpcode;

	@SerializedName("RPCODE_PUB")
	@Expose
	String rpcodePub;

	@SerializedName("COST_ID")
	@Expose
	Long costId;

	@SerializedName("COST_CODE_PUB")
	@Expose
	String costCodePub;

	@SerializedName("ADR_ROLES")
	@Expose
	String adrRoles;

	@SerializedName("ADR_LNAME")
	@Expose
	String adrLname;

	@SerializedName("ADR_FNAME")
	@Expose
	String adrFname;

	@SerializedName("ADR_NAME")
	@Expose
	String adrName;

	@SerializedName("ADR_ZIP")
	@Expose
	String adrZip;

	@SerializedName("ADR_CITY")
	@Expose
	String adrCity;

	@SerializedName("ADR_STREET")
	@Expose
	String adrStreet;

	@SerializedName("ADR_STREETNO")
	@Expose
	String adrStreetno;

	@SerializedName("ADR_EMAIL")
	@Expose
	String adrEmail;

	@SerializedName("SRCH_COUNT")
	@Expose
	Integer srchCount;

	@SerializedName("START_INDEX")
	@Expose
	Long startIndex;

	@SerializedName("FLAG_CASE")
	@Expose
	Boolean flagCase;

	@SerializedName("FLAG_MATCH_CODE")
	@Expose
	Boolean flagMatchcode;

	@SerializedName("PAYMENTRESP")
	@Expose
	Boolean paymentResp;

	@SerializedName("LA_MEMBER")
	@Expose
	Boolean laMember;

	@SerializedName("PARTY_ROLE_ID")
	@Expose
	Long partyRoleId;

	@SerializedName("PARTY_ROLE_SHNAME")
	@Expose
	String partyRoleShname;

	@SerializedName("PARTY_TYPE")
	@Expose
	String partyType;

	@SerializedName("USE_CSR_ROLES")
	@Expose
	Boolean useCsrRoles;

}
