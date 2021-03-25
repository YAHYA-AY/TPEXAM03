package ma.cigma.springsecurity.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ma.cigma.springsecurity.dao.ArtRepository;
import ma.cigma.springsecurity.domaine.ArtConverter;
import ma.cigma.springsecurity.domaine.ArtVo;
import ma.cigma.springsecurity.service.model.Art;

import java.util.List;

@Service
public class ArtServiceImpl implements IArtService {
	@Autowired
	private ArtRepository artRepository;

	@Override
	public List<ArtVo> getArticles() {
		List<Art> list = artRepository.findAll();
		return ArtConverter.toListVo(list);
	}

	@Override
	public void save(ArtVo art){
		artRepository.save(ArtConverter.toBo(art));
	}
	@Override
	public ArtVo getArtById(Long id) {
		boolean trouve = artRepository.existsById(id);
		if (!trouve)
			return null;
		return ArtConverter.toVo(artRepository.getOne(id));
	}

	@Override
	public void delete(Long id) {
		artRepository.deleteById(id);
	}

	@Override
	public List<ArtVo> findByReference(String reference) {
		List<Art> list = artRepository.findByReference(reference);
		return ArtConverter.toListVo(list);
	}

	@Override
	public List<ArtVo> findByDescription(String description) {
		List<Art> list = artRepository.findByDescription(description);
		return ArtConverter.toListVo(list);
	}

	@Override
	public List<ArtVo> findAll(int pageId, int size) {
		Page<Art> result = artRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "reference"));
		return ArtConverter.toListVo(result.getContent());
	}

	@Override
	public List<ArtVo> sortBy(String fieldName) {
		return ArtConverter.toListVo(artRepository.findAll(Sort.by(Direction.DESC,fieldName)));

	}

}
