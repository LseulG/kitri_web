package com.kitri.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// a
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}