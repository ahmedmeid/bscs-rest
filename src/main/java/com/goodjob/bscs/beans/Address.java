package com.goodjob.bscs.beans;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Address {

	@SerializedName("ADR_SEQ")
	@Expose
	Long adrSeq;

	@SerializedName("ADR_ROLES")
	@Expose
	String adrRoles;

	@SerializedName("ADR_JUR_TAX_OVERRIDDEN")
	@Expose
	Boolean adrJurTaxOverridden;

	@SerializedName("ADR_TEMPBILL_OVERRIDDEN")
	@Expose
	Boolean adrTempbillOverridden;

	@SerializedName("ADR_DELETED")
	@Expose
	Boolean adrDeleted;

	@SerializedName("TTL_ID")
	@Expose
	Long ttlId;

	@SerializedName("TTL_ID_PUB")
	@Expose
	String ttlIdPub;

	@SerializedName("ADR_LNAME")
	@Expose
	String adrLname;

	@SerializedName("ADR_NAME")
	@Expose
	String adrName;

	@SerializedName("ADR_FNAME")
	@Expose
	String adrFname;

	@SerializedName("ADR_STREET")
	@Expose
	String adrStreet;

	@SerializedName("ADR_STREETNO")
	@Expose
	String adrStreetno;

	@SerializedName("ADR_ZIP")
	@Expose
	String adrZip;

	@SerializedName("ADR_CITY")
	@Expose
	String adrCity;

	@SerializedName("COUNTRY_ID")
	@Expose
	Long countryId;

	@SerializedName("COUNTRY_ID_PUB")
	@Expose
	String countryIdPub;

	@SerializedName("LNG_CODE")
	@Expose
	Long lngCode;

	@SerializedName("LNG_CODE_PUB")
	@Expose
	String lngCodePub;

	@SerializedName("ADR_NOTE1")
	@Expose
	String adrNote1;

	@SerializedName("ADR_NOTE2")
	@Expose
	String adrNote2;

	@SerializedName("ADR_NOTE3")
	@Expose
	String adrNote3;

	@SerializedName("ADR_JBDES")
	@Expose
	String adrJbdes;

	@SerializedName("ADR_PHN1_AREA")
	@Expose
	String adrPhn1Area;

	@SerializedName("ADR_PHN1")
	@Expose
	String adrPhn1;

	@SerializedName("ADR_PHN2_AREA")
	@Expose
	String adrPhn2Area;

	@SerializedName("ADR_PHN2")
	@Expose
	String adrPhn2;

	@SerializedName("ADR_FAX_AREA")
	@Expose
	String adrFaxArea;

	@SerializedName("ADR_FAX")
	@Expose
	String adrFax;

	@SerializedName("ADR_MNAME")
	@Expose
	String adrMname;

	@SerializedName("ADR_EMAIL")
	@Expose
	String adrEmail;

	@SerializedName("ADR_SMSNO")
	@Expose
	String adrSmsno;

	@SerializedName("ADR_YEARS")
	@Expose
	Integer adrYears;

	@SerializedName("ADR_STATE")
	@Expose
	String adrState;

	@SerializedName("ADR_COUNTY")
	@Expose
	String adrCounty;

	@SerializedName("ADR_VALIDDATE")
	@Expose
	Date adrValiddate;

	@SerializedName("ADR_INCCODE")
	@Expose
	String adrInccode;

	@SerializedName("ADR_URGENT")
	@Expose
	Boolean adrUrgent;

	@SerializedName("ADR_FORWARD")
	@Expose
	Boolean adrForward;

	@SerializedName("ADR_LOCATION_1")
	@Expose
	String adrLocation1;

	@SerializedName("ADR_LOCATION_2")
	@Expose
	String adrLocation2;

	@SerializedName("ADR_REMARK")
	@Expose
	String adrRemark;

	@SerializedName("ADR_TAXNO")
	@Expose
	String adrTaxno;

	@SerializedName("ADR_COMPNO")
	@Expose
	String adrCompno;

	@SerializedName("IDTYPE_CODE")
	@Expose
	Long idtypeCode;

	@SerializedName("ADR_IDNO")
	@Expose
	String adrIdno;

	@SerializedName("ADR_BIRTHDT")
	@Expose
	Date adrBirthdt;

	@SerializedName("ADR_SOCIALSENO")
	@Expose
	String adrSocialseno;

	@SerializedName("ADR_DRIVELICENCE")
	@Expose
	String adrDrivelicence;

	@SerializedName("ADR_SEX")
	@Expose
	String adrSex;

	@SerializedName("ADR_EMPLOYER")
	@Expose
	String adrEmployer;

	@SerializedName("ADR_CUSTTYPE")
	@Expose
	String adrCusttype;

	@SerializedName("MAS_CODE")
	@Expose
	Long masCode;

	@SerializedName("MAS_CODE_PUB")
	@Expose
	String masCodePub;

	@SerializedName("ADR_NATIONALITY")
	@Expose
	Long adrNationality;

	@SerializedName("ADR_NATIONALITY_PUB")
	@Expose
	String adrNationalityPub;

	@SerializedName("ADR_EMPLOYEE")
	@Expose
	Boolean adrEmployee;

}
