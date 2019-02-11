package com.kitri.admin.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class AdminBoardDaoImpl implements AdminBoardDao {

	// 2 변수 하나 만들어라
	private static AdminBoardDao adminBoardDao;
	
	// 3 한번만 생성하고
	static {
		adminBoardDao = new AdminBoardDaoImpl();
	}

	// 1 프라이빗으로 막아라
	private AdminBoardDaoImpl() {}
	
	// 4 다른대서 쓸 수 있게 getter 만들기
	public static AdminBoardDao getAdminBoardDao() {
		return adminBoardDao;
	}
	
	@Override
	public List<BoardListDto> getBoardMenu() {
		List<BoardListDto> list = new ArrayList<BoardListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select bl.bcode, bl.bname, bl.btype, c.ccode, c.cname, \n");
			sql.append("		decode(btype, '5', 'reboard', \n");
			sql.append("					  '6', 'album', \n");
			sql.append("					  '7', 'bbs', \n");
			sql.append("					  'board') control \n");
			sql.append("from board_list bl, category c \n");
			sql.append("where bl.ccode = c.ccode \n");
			sql.append("order by c.ccode, bl.bcode");
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardListDto boardListDto = new BoardListDto();
				boardListDto.setBcode(rs.getInt("bcode"));
				boardListDto.setBname(rs.getString("bname"));
				boardListDto.setBtype(rs.getInt("btype"));
				boardListDto.setCcode(rs.getInt("ccode"));
				boardListDto.setCname(rs.getString("cname"));
				
				list.add(boardListDto);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

}
