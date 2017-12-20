package cn.com.taiji.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dept database table.
 * 
 */
public class DeptDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="dept_id")
	private String deptId;

	@Column(name="dept_name")
	private String deptName;

	private String desc;

	@Column(name="parent_id")
	private String parentId;

	@Column(name="second_dept")
	private String secondDept;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="dept")
	private List<UserDto> users;

	public DeptDto() {
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

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public List<UserDto> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	public UserDto addUser(UserDto user) {
		getUsers().add(user);
		user.setDept(this);

		return user;
	}

	public UserDto removeUser(UserDto user) {
		getUsers().remove(user);
		user.setDept(null);

		return user;
	}

	@Override
	public String toString() {
		return "DeptDto [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", desc=" + desc + ", parentId="
				+ parentId + ", secondDept=" + secondDept + ", users=" + users + "]";
	}

	
}