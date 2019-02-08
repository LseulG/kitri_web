package com.kitri.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.service.AdminBoardServiceImpl;

public class AdminBoardListAction implements Action {

	// 2 자기자신 변수 하나 만들어라
	private static Action adminBoardListAction;
	
	// 3 한번만 생성하고
	static {
		adminBoardListAction = new AdminBoardListAction();
	}

	// 1 프라이빗으로 막아라
	private AdminBoardListAction() {}
	
	// 4 다른대서 쓸 수 있게 getter 만들기
	public static Action getAdminBoardListAction() {
		return adminBoardListAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardListDto> list = AdminBoardServiceImpl.getAdminBoardService().getBoardMenu();
		ServletContext application = request.getServletContext();
		application.setAttribute("boardmenu", list);
		
		return "/admin/board/boardmenu.jsp";
	}

}
