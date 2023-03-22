package ezen.yorizori.domain.member.dao;

import java.sql.SQLException;
import java.util.List;

import ezen.yorizori.domain.member.dto.Member;


/**
 * 회원 Database 관련 기능 명세(역할)
 * @author 송진호
 * @Date	2023. 3. 8.
 */
public interface MemberDao {
	//회원 가입
	public void create(ezen.yorizori.domain.member.dto.Member member) throws SQLException;
	//회원 인증
//	public boolean isMEmber(Member member) throws SQLException;
	public Member isMember(String id, String password) throws SQLException; //boolean도 좋지만 객체로 반환하는게 유연한 방법이고 나중에 재사용가능
	
	//회원 목록 조회
	public List<Member> findAll() throws SQLException;
	
	//회원 아이디로 조회
	public Member findUserId(String userid) throws SQLException;
	//회원 삭제
	
	//회원 정보 수정
	
}
