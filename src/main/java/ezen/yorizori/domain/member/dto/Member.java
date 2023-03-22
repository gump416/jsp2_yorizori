package ezen.yorizori.domain.member.dto;

import java.util.Date;

/**
 * javabean 규약(명세)에 따라 작성
 * 재사용 가능한 컴포넌트
 * @author 송진호
 * @Date	2023. 3. 8.
 */
public class Member { //첫번쨰규약첫번째는 class는 public이어야함+디폴트생성

	private String id; //property이름
	private String password;
	private String name;
	private String email;
	private int age;
	private Date regdate;
	
	public Member() {}
	public Member(String id, String password, String name, String email, int age, Date regdate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", regdate=" + regdate + "]";
	}
	
	
}
