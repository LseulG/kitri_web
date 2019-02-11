package com.kitri.action.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class MemoListAction implements Action {

	// 2 자기자신 변수 하나 만들어라
	private static Action memoListAction;

	// 3 한번만 생성하고
	static {
		memoListAction = new MemoListAction();
	}

	// 1 프라이빗으로 막아라
	private MemoListAction() {}

	// 4 다른대서 쓸 수 있게 getter 만들기
	public static Action getMemoListAction() {
		return memoListAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return null;
	}
}
