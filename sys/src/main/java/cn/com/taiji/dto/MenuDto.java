package cn.com.taiji.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 类名称：MenuDto   
 * 类描述：  
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午3:21:03 
 * @version
 */


public class MenuDto implements Serializable{
	
	/**
	 * Description:
	 * @author Meng
	 */
	private static final long serialVersionUID = 8341177982507259054L;

	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解  
	@GeneratedValue(generator="idGenerator") //使用uuid的生成策略
	private String id;
	
	@Column(nullable=false,unique=true,length=20)
	private String name;//菜单名称
	
	@Column(nullable=false,length=100)
	private String url;//菜单链接
	
	@Column(nullable=false,length=100)
	private String descpt;//菜单描述，该desc与SQL查询语句中的降序排列关键字DESC冲突了！运行后会报错不能用description，换成其他名称就好
	
	@Column(nullable=false,length=20)
	private String hierarchy;//菜单层级
	

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

//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "Menu")
//	private List<Role> role;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescpt() {
		return descpt;
	}

	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
