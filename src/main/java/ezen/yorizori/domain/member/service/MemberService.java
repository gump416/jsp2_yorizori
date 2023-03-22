package ezen.yorizori.domain.member.service;

import java.util.List;

import ezen.yorizori.domain.member.dto.Member;

/**
 * 회원 관련 비지니스 메소드 정의 및 복잡한 트랜잭션 처리,ex)카카오API처리할때 로그인정보 불러들일때 service에서 처리
 * @author 송진호
 * @Date	2023. 3. 13.
 */
public interface MemberService {
	//회원 등록
	public void registerMember(Member member) throws RuntimeException;
	//회원 전체 조회
	public List<Member> getMembers() throws RuntimeException;
	//회원 아이디로 전체 조회
		public Member findUserId(String id) throws RuntimeException;
	
	//회원인증
	public Member isMember(String id, String password) throws RuntimeException;
}
