package cn.com.taiji.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * 类名称：EmployeeDto   
 * 类描述： 
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午1:57:04 
 * @version
 */

public class  EmployeeDto implements Serializable {
	
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", empId=" + empId + ", name=" + name + ", gender=" + gender + ", emptype="
				+ emptype + ", jobcity=" + jobcity + ", dept=" + dept + ", secondDept=" + secondDept + ", jobSequence="
				+ jobSequence + ", jobLevel=" + jobLevel + ", jobName=" + jobName + ", time=" + time + ", phone="
				+ phone + ", email=" + email + ", username=" + username + ", password=" + password + ", avatar="
				+ Arrays.toString(avatar) + ", age=" + age + ", education=" + education + ", dateOfBirth=" + dateOfBirth
				+ ", deletemark=" + deletemark + ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", recoveryUser=" + recoveryUser + ", recoveryTime=" + recoveryTime + ", role=" + role + "]";
	}

	/**
	 * Description:
	 * @author Meng
	 */
	private static final long serialVersionUID = 1384389070884874860L;

	@Id // 主键
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解  
	@GeneratedValue(generator="idGenerator") //使用uuid的生成策略
	private String id; // 用户的唯一标识
 
	@NotNull(message = "编号不能为空")
	@Column(name="emp_id",nullable = false, length = 10,unique = true)
	private Long empId;
	
	@NotNull(message = "姓名不能为空")
	@Column(nullable = false, length = 20) // 映射为字段，值不能为空
	private String name;
	
	@NotNull(message = "性别不能为空")
	@Column(nullable = false, length = 2) // 映射为字段，值不能为空
	private String gender;
	
	@Column(name="emp_type",length = 20)
	private String emptype;//员工类别
	
	@Column(name="jobcity",length = 20)
	private String jobcity;//工作城市
	
	@Column(nullable = false,length = 20)
	private String dept;//部门
	
	@Column(nullable = false,length = 20)
	private String secondDept;//二级部门
	
	@Column(nullable = false,length = 20)
	private String jobSequence;//岗位序列
	
	@Column(nullable = false,length = 2)
	private int jobLevel;//岗位级别
	
	@Column(nullable = false,length = 20)
	private String jobName;//岗位名称
	
	@Column(nullable = false)
	private Date time;//入职时间
	
	@NotNull(message = "手机号不能为空")
	@Column(nullable = false, length = 20, unique = true)
	private String phone;//手机号
	
	@NotNull(message = "邮箱不能为空")
	@Email(message= "邮箱格式不对" ) 
	@Column(nullable = false, length = 50, unique = true)
	private String email;

	@NotNull(message = "账号不能为空")
	@Size(min=3, max=20)
	@Column(name="user_name",nullable = false, length = 20, unique = true)
	private String username; // 用户账号，用户登录时的唯一标识

	@NotNull(message = "密码不能为空")
	@Size(max=100)
	@Column(nullable = false,length = 20)
	private String password; // 登录时密码
	
	@Basic(fetch=FetchType.LAZY)//懒加载
	@Lob()
	private byte[] avatar; // 头像图片地址 file.getButes
	
	@Column(nullable = false,length = 3)
	private int age; //年龄
	
	@Column(nullable = false,length = 20)
	private String education; //学历
	
	@Column(nullable = false,length = 20)
	private Date dateOfBirth; //出生日期

	@Column(nullable=false,length=1)
	private int deletemark;//逻辑删除标识，0代表逻辑删除不显示，1代表没被删除可以显示。
	
	@Column()
	private Date updateTime;//逻辑删除删除时间。
	
	@Column()
	private String updateUser;//逻辑删除的用户。
	
	@Column()
	private String recoveryUser;//逻辑删除恢复的用户。
	
	@Column()
	private Date recoveryTime;//逻辑删除恢复时间。
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)//EAGER急加载 ，LAZY懒加载
	@JoinTable(name = "Emp_Role", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<RoleDto> role;//引入role对象集合 并设置多对多关系通过关联表和menu表关联起来

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public String getJobcity() {
		return jobcity;
	}

	public void setJobcity(String jobcity) {
		this.jobcity = jobcity;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSecondDept() {
		return secondDept;
	}

	public void setSecondDept(String secondDept) {
		this.secondDept = secondDept;
	}

	public String getJobSequence() {
		return jobSequence;
	}

	public void setJobSequence(String jobSequence) {
		this.jobSequence = jobSequence;
	}

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getDeletemark() {
		return deletemark;
	}

	public void setDeletemark(int deletemark) {
		this.deletemark = deletemark;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getRecoveryUser() {
		return recoveryUser;
	}

	public void setRecoveryUser(String recoveryUser) {
		this.recoveryUser = recoveryUser;
	}

	public Date getRecoveryTime() {
		return recoveryTime;
	}

	public void setRecoveryTime(Date recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	public List<RoleDto> getRole() {
		return role;
	}

	public void setRole(List<RoleDto> role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
