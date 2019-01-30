package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;

public interface MemberDao {
	
	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto);
	
	MemberDetailDto getMember(String id); // 회원정보 수정 페이지로 이동
	int modify(MemberDetailDto memberDetailDto);// 회원정보 update
	
	int delete(String id); // 회원 탈퇴
	
	/*
	 *  MemberDto login(String id, String pass);
	 *  id, pass로 받아도 되는데 나중에 마이바티스 쓸때는 인자값을 1개밖에 못얻어오기 때문에
	 *  이번 예제에서는 map 을 이용해본다.
	 */
	MemberDto login(Map<String, String> map);
	
}
