package com.kitri.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class BoardModifyAction implements Action {

	// 2 자기자신 변수 하나 만들어라
	private static Action boardModifyAction;

	// 3 한번만 생성하고
	static {
		boardModifyAction = new BoardModifyAction();
	}

	// 1 프라이빗으로 막아라
	private BoardModifyAction() {}

	// 4 다른대서 쓸 수 있게 getter 만들기
	public static Action getBoardModifyAction() {
		return boardModifyAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return null;
	}

}
