package com.kopo.data1;

public class User {
	
	private int idx;
	private String type;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String created;
	private String updated;
	
	/**
	 * 2022년 11월 1일
	 * 타입이름 getter, setter 추가 정의
	 */
	private String typeName;
	
	/**
	 * 사용자 번호를 리턴한다
	 * @return 사용자 번호
	 */
	public int getIdx() {
		return idx;
	}
	
	/**
	 * 사용자 번호를 저장한다
	 * @param idx
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	/**
	 * 사용자 타입을 리턴한다
	 * @return 사용자 타입
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 사용자 타입을 저장한다
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 사용자 아이디를 리턴한다
	 * @return 사용자 아이디
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 사용자 아이디를 저장한다
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 사용자 비밀번호를 리턴한다
	 * @return 사용자 비밀번호
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 사용자 비밀번호를 저장한다
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 사용자 이름을 리턴한다
	 * @return 사용자 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 사용자 이름을 저장한다
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 사용자 전화번호를 리턴한다
	 * @return 사용자 전화번호
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 사용자 전화번호를 저장한다
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 사용자 주소를 리턴한다
	 * @return 사용자 주소
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 사용자 주소를 저장한다
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 사용자 생성일자를 리턴한다
	 * @return 사용자 생성일자
	 */
	public String getCreated() {
		return created;
	}
	
	/**
	 * 사용자 생성일자를 저장한다
	 * @param created
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	
	/**
	 * 사용자 수정일자를 리턴한다
	 * @return 사용자 수정일자
	 */
	public String getUpdated() {
		return updated;
	}
	
	/**
	 * 사용자 수정일자를 저장한다
	 * @param updated
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	/**
	 * 타입 이름을 리턴한다
	 * @return 타입 이름
	 */
	public String getTypeName() {
		return typeName;
	}
		
	/**
	 * 타입 이름을 저장한다
	 * @param typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	//생성자
	User(){
		
	}
		
	//사용자 type, name 저장 생성자
	User(String type, String name){
		this.type = type;
		this.name = name;
	}



}
