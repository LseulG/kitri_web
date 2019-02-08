package com.kitri.admin.board.model.service;

import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.model.dao.AdminBoardDaoImpl;

public class AdminBoardServiceImpl implements AdminBoardService {

	// 2 변수 하나 만들어라
	private static AdminBoardService adminBoardService;
	
	// 3 한번만 생성하고
	static {
		adminBoardService = new AdminBoardServiceImpl();
	}

	// 1 프라이빗으로 막아라
	private AdminBoardServiceImpl() {}
	
	// 4 다른대서 쓸 수 있게 getter 만들기
	public static AdminBoardService getAdminBoardService() {
		return adminBoardService;
	}
	
	@Override
	public List<BoardListDto> getBoardMenu() {
		return AdminBoardDaoImpl.getAdminBoardDao().getBoardMenu();
	}

}
