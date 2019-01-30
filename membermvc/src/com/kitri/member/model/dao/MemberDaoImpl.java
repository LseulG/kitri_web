package com.kitri.member.model.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		int cnt = 0;
		try{
			conn = DBConnection.makeConnection();
			
			String sql = "insert all \n" +
				"into member(id, name, pass, emailid, emaildomain, joindate) \n" +
				"values (?,?,?,?,?,sysdate) \n" +
				"into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) \n" +
				"values (?,?,?,?,?,?,?) \n" +
				"select * from dual";
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getName());
			pstmt.setString(idx++, memberDetailDto.getPass());
			pstmt.setString(idx++, memberDetailDto.getEmailId());
			pstmt.setString(idx++, memberDetailDto.getEmailDomain());
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getTel1());
			pstmt.setString(idx++, memberDetailDto.getTel2());
			pstmt.setString(idx++, memberDetailDto.getTel3());
			pstmt.setString(idx++, memberDetailDto.getZipCode());
			pstmt.setString(idx++, memberDetailDto.getAddress());
			pstmt.setString(idx++, memberDetailDto.getAddressDetail());
					
			cnt = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
