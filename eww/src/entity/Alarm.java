package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="alarm_info")
public class Alarm {
	@Id
	@GeneratedValue(generator="alarm_id")
	@GenericGenerator(name="alarm_id",strategy="native")
	private Integer alarm_id;
	private String alarm_name;
	private String alarm_pc;
	private String alarm_type;
	private String alarm_user;
	private String alarm_way;
	private String mainframe_id;
	private String alarm_describe;
	public Integer getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(Integer alarm_id) {
		this.alarm_id = alarm_id;
	}
	public String getAlarm_name() {
		return alarm_name;
	}
	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}
	public String getAlarm_pc() {
		return alarm_pc;
	}
	public void setAlarm_pc(String alarm_pc) {
		this.alarm_pc = alarm_pc;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getAlarm_user() {
		return alarm_user;
	}
	public void setAlarm_user(String alarm_user) {
		this.alarm_user = alarm_user;
	}
	public String getAlarm_way() {
		return alarm_way;
	}
	public void setAlarm_way(String alarm_way) {
		this.alarm_way = alarm_way;
	}
	public String getMainframe_id() {
		return mainframe_id;
	}
	public void setMainframe_id(String mainframe_id) {
		this.mainframe_id = mainframe_id;
	}
	public String getAlarm_describe() {
		return alarm_describe;
	}
	public void setAlarm_describe(String alarm_describe) {
		this.alarm_describe = alarm_describe;
	}
	
	
}
