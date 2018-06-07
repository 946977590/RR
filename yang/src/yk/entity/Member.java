package yk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="member")
public class Member {
	
	@Id
	@GeneratedValue(generator="mid")
	@GenericGenerator(name="mid",strategy="native")
	private Integer mid;
	private String memName;	
	private String memAccount;
	@ManyToOne
	@JoinColumn(name="memwid",referencedColumnName="memwid")
	private MemberCategory memCategory;
	
	private String memPassword;
	private String memSex;
	private String memSign;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemAccount() {
		return memAccount;
	}
	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}
	public MemberCategory getMemCategory() {
		return memCategory;
	}
	public void setMemCategory(MemberCategory memCategory) {
		this.memCategory = memCategory;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	public String getMemSign() {
		return memSign;
	}
	public void setMemSign(String memSign) {
		this.memSign = memSign;
	}

}
