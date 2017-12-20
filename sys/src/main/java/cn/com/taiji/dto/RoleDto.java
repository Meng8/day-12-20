package cn.com.taiji.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 类名称：Role   
 * 类描述：   角色表实体创建
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午2:09:26 
 * @version
 */

public class RoleDto implements Serializable{
	
	/**
	 * Description:
	 * @author Meng
	 */
	private static final long serialVersionUID = -1401190008262790289L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解  
	@GeneratedValue(generator="idGenerator") //使用uuid的生成策略
	private String id;//用户id
	
	@Column(nullable=false,length=20)
	private String name;//用户名称
	
	@Column(nullable=false,length=100)
	private String description;//用户名称
	
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
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "Role_Menu", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
	private List<MenuDto> menu;//引入menu对象集合 并设置多对多关系通过关联表和menu表关联起来

//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "Role")
//	private List<Employee> employee;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<MenuDto> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuDto> menu) {
		this.menu = menu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
