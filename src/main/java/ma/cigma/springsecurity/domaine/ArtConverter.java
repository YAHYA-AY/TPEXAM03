package ma.cigma.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.cigma.springsecurity.service.model.Art;

public class ArtConverter {
	public static ArtVo toVo(Art bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		ArtVo vo = new ArtVo();
		vo.setId(bo.getId());
		vo.setReference(bo.getReference());
		vo.setDescription(bo.getDescription());
		vo.setPrice(bo.getPrice());
		return vo;
	}
	public static Art toBo(ArtVo vo) {
		Art bo = new Art();
		bo.setId(vo.getId());
		bo.setReference(vo.getReference());
		bo.setDescription(vo.getDescription());
		bo.setPrice(vo.getPrice());
		return bo;
	}
	public static List<ArtVo> toListVo(List<Art> listBo) {
		List<ArtVo> listVo = new ArrayList<>();
		for (Art art : listBo) {
			listVo.add(toVo(art));
		}
		return listVo;
	}
}
