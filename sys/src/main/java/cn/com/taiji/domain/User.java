package cn.com.taiji.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="job_city")
	private String jobCity;

	@Column(name="job_level")
	private int jobLevel;

	@Column(name="job_name")
	private String jobName;

	@Column(name="job_sequence")
	private String jobSequence;
	

	private String name;

	private String sex;

	private int state;

	@Column(name="user_id")
	private String userId;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_type")
	private String userType;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)//EAGER急加载 ，LAZY懒加载
	@JoinTable(name = "user_dept", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id"))
	private List<Dept> dept;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobCity() {
		return this.jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public int getJobLevel() {
		return this.jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobSequence() {
		return this.jobSequence;
	}

	public void setJobSequence(String jobSequence) {
		this.jobSequence = jobSequence;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<Dept> getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = (List<Dept>) dept;
	}

}