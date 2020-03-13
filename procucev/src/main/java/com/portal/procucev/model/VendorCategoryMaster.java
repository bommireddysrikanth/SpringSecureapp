package com.portal.procucev.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_category_master database table.
 * 
 */
@Entity
@Table(name = "vendor_category_master")
public class VendorCategoryMaster extends Procucev {

	private static final long serialVersionUID = 1L;

	private String  Segment;
	
	private String  SegmentName;
	
	private String  Family;
	
	private String  FamilyName;
	
	private String  CatagoryClass;
	
	private String  ClassName;
	
	private String Commodity;
	
	private String CommodityName;
	
	
	
	
	public String getSegment() {
		return Segment;
	}




	public void setSegment(String segment) {
		Segment = segment;
	}




	public String getSegmentName() {
		return SegmentName;
	}




	public void setSegmentName(String segmentName) {
		SegmentName = segmentName;
	}




	public String getFamily() {
		return Family;
	}




	public void setFamily(String family) {
		Family = family;
	}




	public String getFamilyName() {
		return FamilyName;
	}




	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}




	




	



	public String getCatagoryClass() {
		return CatagoryClass;
	}




	public void setCatagoryClass(String catagoryClass) {
		CatagoryClass = catagoryClass;
	}




	public String getClassName() {
		return ClassName;
	}




	public void setClassName(String className) {
		ClassName = className;
	}




	public String getCommodity() {
		return Commodity;
	}




	public void setCommodity(String commodity) {
		Commodity = commodity;
	}




	public String getCommodityName() {
		return CommodityName;
	}




	public void setCommodityName(String commodityName) {
		CommodityName = commodityName;
	}




	public VendorCategoryMaster() {
		super();
	}

}