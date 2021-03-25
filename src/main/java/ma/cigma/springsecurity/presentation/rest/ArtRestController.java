package ma.cigma.springsecurity.presentation.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.cigma.springsecurity.domaine.ArtVo;
import ma.cigma.springsecurity.domaine.ArtVo;
import ma.cigma.springsecurity.service.IArtService;

@RestController
public class ArtRestController {
	/**
	 * @Autowired permet d'injecter le bean de type IProdcutService (objet
	 *            représentant la couche métier). Ici, le Design Pattern qui est
	 *            appliqué est l'IOC (Inversion Of Control).
	 */
	@Autowired
	private IArtService service;

	/**
	 * Pour chercher tous les articles
	 */
	@GetMapping(value = "/rest/emp", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ArtVo> getAll() {
		return service.getArticles();
	}

	/**
	 * Pour chercher un article par son id
	 */
	@GetMapping(value = "/rest/emp/{id}")
	public ResponseEntity<Object>  getArtById(@PathVariable(value = "id") Long artVoId) {
		ArtVo artVoFound = service.getArtById(artVoId);
		if (artVoFound == null)
			return new ResponseEntity<>("Article doen't exist", HttpStatus.OK);
		return new ResponseEntity<>(artVoFound, HttpStatus.OK);
	}

	/**
	 * Pour créer un nouveau Article
	 */
	@PostMapping(value = "/rest/emp")
	public ResponseEntity<Object> createArt(@Valid @RequestBody ArtVo artVo) {
		service.save(artVo);
		return new ResponseEntity<>("Article is created successfully", HttpStatus.CREATED);
	}
	

	/**
	 * Pour modifier un Article par son id
	 */
	@PutMapping(value = "/rest/emp/{id}")
	public ResponseEntity<Object> updateArt(@PathVariable(name = "id") Long artVoId, @RequestBody ArtVo artVo) {
		ArtVo artVoFound = service.getArtById(artVoId);
		if (artVoFound == null)
			return new ResponseEntity<>("Article doen't exist", HttpStatus.OK);
		artVo.setId(artVoId);
		service.save(artVo);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	}

	/**
	 * Pour supprimer un Article par son id
	 */
	@DeleteMapping(value = "/rest/emp/{id}")
	public ResponseEntity<Object> deleteArt(@PathVariable(name = "id") Long artVoId) {
		ArtVo artVoFound = service.getArtById(artVoId);
		if (artVoFound == null)
			return new ResponseEntity<>("Article doen't exist", HttpStatus.OK);
		service.delete(artVoId);
		return new ResponseEntity<>("Article is deleted successsfully", HttpStatus.OK);
	}
	
	/**
	 * Pour chercher tous les Articles
	 */
	@GetMapping(value = "/rest/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ArtVo> sortBy(@PathVariable String fieldName) {
		return service.sortBy(fieldName);
	}
	
	/**
	 * Afficher la liste des Articles en utilisant la pagination
	 */
	@GetMapping("/rest/pagination/{pageid}/{size}")
	public List<ArtVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		return service.findAll(pageid, size);
	}
}
