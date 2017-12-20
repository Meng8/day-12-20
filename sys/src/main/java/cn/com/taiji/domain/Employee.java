package cn.com.taiji.domain;

import java.io.Serializable;
import java.sql.Date;
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
 * 类名称：Employee   
 * 类描述：  员工表实体类创建
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午1:57:04 
 * @version
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class  Employee implements Serializable {
	
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
	@Column(nullable = false, length = 20)
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
	private List<Role> role;//引入role对象集合 并设置多对多关系通过关联表和menu表关联起来

}
