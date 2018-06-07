package yk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="memCategory")
public class MemberCategory {

	@Id
	@GeneratedValue(generator="memwid")
	@GenericGenerator(name="memwid",strategy="native")
	private Integer memwid;
	
	private String memType;
	private Integer memlid;
	public Integer getMemwid() {
		return memwid;
	}
	public void setMemwid(Integer memwid) {
		this.memwid = memwid;
	}
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	public Integer getMemlid() {
		return memlid;
	}
	public void setMemlid(Integer memlid) {
		this.memlid = memlid;
	}
	


}
