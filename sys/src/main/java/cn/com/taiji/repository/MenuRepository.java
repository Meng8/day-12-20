package cn.com.taiji.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.taiji.domain.Menu;


public interface MenuRepository extends 
JpaRepository<Menu, String>,JpaSpecificationExecutor<Menu>,PagingAndSortingRepository<Menu,String>{




//	@Transactional
//	@Modifying
//	@Query("update User u set u.userName=:username where u.userNum=:userNum ")
//	void updateUser(@Param("username") String username,
//					@Param("userNum") String userNum);

}
