package ma.cigma.springsecurity.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.cigma.springsecurity.domaine.RoleVo;
import ma.cigma.springsecurity.domaine.UserVo;
import ma.cigma.springsecurity.service.model.User;
import ma.cigma.springsecurity.domaine.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
	void save(UserVo user);
	void save(RoleVo role);
	List<UserVo> getAllUsers();
	List<RoleVo> getAllRoles();
	RoleVo getRoleByName(String role);
	void cleanDataBase();
	User findByUsername(String username);
	User save(UserRegistrationDto registration);
}
