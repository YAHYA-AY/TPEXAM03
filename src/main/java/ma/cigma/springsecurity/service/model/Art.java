package ma.cigma.springsecurity.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Art {
	@Id
	@GeneratedValue
	private Long id;
	private String reference;
	private String description;
	private Double price;

	public Art(String reference, String description, Double price) {
		super();
		this.reference = reference;
		this.description = description;
		this.price = price;
	}
}