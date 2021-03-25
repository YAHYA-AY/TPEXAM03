package ma.cigma.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.cigma.springsecurity.domaine.UserVo;
import ma.cigma.springsecurity.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String userName);
}
