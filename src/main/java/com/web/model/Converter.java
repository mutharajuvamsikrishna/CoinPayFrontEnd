package com.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Converter implements Serializable {

	private static final long serialVersionUID = -6206009238197715962L;

	@Id
	private String mob;
	private String email;
	private String fcurrency;
	private int amt;
	private double coins;
	private String password;
	private String cnpassword;

	public Converter() {

	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFcurrency() {
		return fcurrency;
	}

	public void setFcurrency(String fcurrency) {
		this.fcurrency = fcurrency;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public double getCoins() {
		return coins;
	}

	public void setCoins(double coins) {
		this.coins = coins;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnpassword() {
		return cnpassword;
	}

	public void setCnpassword(String cnpassword) {
		this.cnpassword = cnpassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Converter [mob=" + mob + ", email=" + email + ", fcurrency=" + fcurrency + ", amt=" + amt + ", coins="
				+ coins + ", password=" + password + ", cnpassword=" + cnpassword + ", getMob()=" + getMob()
				+ ", getEmail()=" + getEmail() + ", getFcurrency()=" + getFcurrency() + ", getAmt()=" + getAmt()
				+ ", getCoins()=" + getCoins() + ", getPassword()=" + getPassword() + ", getCnpassword()="
				+ getCnpassword() + "]";
	}

}