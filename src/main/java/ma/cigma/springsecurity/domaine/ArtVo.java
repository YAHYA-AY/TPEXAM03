package ma.cigma.springsecurity.domaine;

import lombok.Data;

@Data
public class ArtVo {
	private Long id;
	private String reference;
	private String description;
	private Double price;
	public ArtVo() {
		super();
	}
	public ArtVo(Long id, String reference, String description, Double price) {
		this(reference,description,price);
		this.id = id;
	}
	
	public ArtVo(String reference, String description, Double price) {
		super();
		this.reference = reference;
		this.description = description;
		this.price = price;
	}
}
