package com.kitri.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class ReboardListAction implements Action {

	private static Action reboardListAction;
	
	static {
		reboardListAction = new ReboardListAction();
	}
	
	private ReboardListAction() {}
	
	public static Action getReboardListAction() {
		return reboardListAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return null;
	}

}
