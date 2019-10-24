package com.goodjob.bscs.beans;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ListOfAssignments {

	@SerializedName("FAMILY_ID")
	@Expose
	Long familyId;

	@SerializedName("COMPLETION_STATUS")
	@Expose
	Long completionStatus;

	@SerializedName("VALID_FROM")
	@Expose
	Date validFrom;

}
