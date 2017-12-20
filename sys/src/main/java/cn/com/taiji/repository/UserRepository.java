package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.taiji.domain.User;


/**
 * 
 * 类名称：UserRepository   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月18日 下午1:47:32 
 * @version
 */
public interface UserRepository extends  
JpaRepository<User, String>,JpaSpecificationExecutor<User>,PagingAndSortingRepository<User,String> {

}
