package com.kitri.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
//			String sql = "select id\r\n" + 
//					"from member\r\n" + 
//					"where id=?";
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		List<ZipCodeDto> list = new ArrayList<ZipCodeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "select 	new_post_code zipcode, sido_kor sido, gugun_kor gugun, \r\n" + 
					"		nvl(upmyon_kor, ' ') upmyon, doro_kor doro, \r\n" + 
					"		case when building_refer_number != '0'\r\n" + 
					"			then building_origin_number||'-'||building_refer_number \r\n" + 
					"			else trim(to_char(building_origin_number, '99999'))\r\n" + 
					"		end building_number, nvl(sigugun_building_name, ' ') sigugun_building_name\r\n" + 
					"from 	postcode\r\n" + 
					"where 	doro_kor like '%'||?||'%'\r\n" + 
					"or 		sigugun_building_name like '%'||?||'%'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doro);
			pstmt.setString(2, doro);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipCodeDto zipCodeDto = new ZipCodeDto();
				zipCodeDto.setZipcode(rs.getString("zipcode"));
				zipCodeDto.setSido(rs.getString("sido"));
				zipCodeDto.setGugun(rs.getString("gugun"));
				zipCodeDto.setUpmyon(rs.getString("upmyon"));
				zipCodeDto.setDoro(rs.getString("doro"));
				zipCodeDto.setBuilding_number(rs.getString("building_number"));
				zipCodeDto.setSigugun_building_name(rs.getString("sigugun_building_name"));
				
				list.add(zipCodeDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
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
		MemberDto memberDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select id, name, emailid, emaildomain \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ?");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpass"));
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
			}
			
		} catch (SQLException e) {
			memberDto = null;
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return memberDto;
	}

}
