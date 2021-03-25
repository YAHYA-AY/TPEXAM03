package ma.cigma.springsecurity.service;

import java.util.List;

import ma.cigma.springsecurity.domaine.ArtVo;

public interface IArtService {
	List<ArtVo> getArticles();
	void save(ArtVo art);
	ArtVo getArtById(Long id);
	void delete(Long id);
	List<ArtVo> findByReference(String reference);
	List<ArtVo> findByDescription(String description);
	//List<EmpVo> findBySalaryAndFonction(Double salary, String fonction);
	//EmpVo getEmpHavaingMaxSalary();
	//Pour la pagination
	List<ArtVo> findAll(int pageId, int size);
	//pour le tri
	List<ArtVo> sortBy(String fieldName);
}
