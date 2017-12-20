package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@Table(name="dept")
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="dept_id")
	private String deptId;

	@Column(name="dept_name")
	private String deptName;

	private String descpt;

	@Column(name="parent_id")
	private String parentId;

	@Column(name="second_dept")
	private String secondDept;

//	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="dept")
//	private List<User> users;

	public Dept() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescpt() {
		return this.descpt;
	}

	public void setDescpt(String desc) {
		this.descpt = desc;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSecondDept() {
		return this.secondDept;
	}

	public void setSecondDept(String secondDept) {
		this.secondDept = secondDept;
	}



}