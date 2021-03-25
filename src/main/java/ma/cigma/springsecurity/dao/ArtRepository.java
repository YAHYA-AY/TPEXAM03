package ma.cigma.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.cigma.springsecurity.service.model.Art;

public interface ArtRepository extends JpaRepository<Art, Long> {	

	List<Art> findByReference(String reference);
	List<Art> findByDescription(String description);
	//List<Emp> findBySalaryAndFonction(Double salary, String fonction);

	//@Query("SELECT e from Emp e where e.salary=(select MAX(salary) as salary FROM Emp)")
	//Emp getEmpHavaingMaxSalary();

	
}
