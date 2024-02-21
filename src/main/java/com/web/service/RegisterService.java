package com.web.service;

import com.web.model.Register;

public interface RegisterService {
	public Register saveCustomer(Register customer);

	public Register login(String email, String password);

}
