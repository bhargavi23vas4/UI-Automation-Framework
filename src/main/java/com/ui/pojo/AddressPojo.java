package com.ui.pojo;

public class AddressPojo {
	
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String zipOrPostalCode;
	private String homePhone;
	private String mobilePhone;
	private String additionalInfo;
	private String addressAlias;
	private String state;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipOrPostalCode() {
		return zipOrPostalCode;
	}
	public void setZipOrPostalCode(String zipOrPostalCode) {
		this.zipOrPostalCode = zipOrPostalCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public void setAddressAlias(String addressAlias) {
		this.addressAlias = addressAlias;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	public AddressPojo(String company, String address1, String address2, String city, String zipOrPostalCode,
			String homePhone, String mobilePhone, String additionalInfo, String addressAlias, String state) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zipOrPostalCode = zipOrPostalCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additionalInfo = additionalInfo;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	@Override
	public String toString() {
		return "AddressPojo [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", zipOrPostalCode=" + zipOrPostalCode + ", homePhone=" + homePhone + ", mobilePhone="
				+ mobilePhone + ", additionalInfo=" + additionalInfo + ", addressAlias=" + addressAlias + ", state="
				+ state + "]";
	}
	
	
	
	
	
	
}
