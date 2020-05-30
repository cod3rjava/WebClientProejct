package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stdtab")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "stsid")
	private Integer stsId;
	@Column(name = "stsName")
	private String stdName;
	@Column(name = "stsfee")
	private Double stsFee;
	@Column(name = "stscourse")
	private String stdCourse;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Integer stsId, String stdName, Double stsFee, String stdCourse) {
		super();
		this.stsId = stsId;
		this.stdName = stdName;
		this.stsFee = stsFee;
		this.stdCourse = stdCourse;
	}
	@Override
	public String toString() {
		return "Student [stsId=" + stsId + ", stdName=" + stdName + ", stsFee=" + stsFee + ", stdCourse=" + stdCourse
				+ ", getStsId()=" + getStsId() + ", getStdName()=" + getStdName() + ", getStsFee()=" + getStsFee()
				+ ", getStdCourse()=" + getStdCourse() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Integer getStsId() {
		return stsId;
	}
	public void setStsId(Integer stsId) {
		this.stsId = stsId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Double getStsFee() {
		return stsFee;
	}
	public void setStsFee(Double stsFee) {
		this.stsFee = stsFee;
	}
	public String getStdCourse() {
		return stdCourse;
	}
	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}

}
