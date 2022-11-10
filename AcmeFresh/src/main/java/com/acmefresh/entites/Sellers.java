package com.acmefresh.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Sellers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "seller name should contain only letters")
	@Size(min=3,max=20, message = "seller Name should be of size between 3 to 20 charcters")
	private String name;
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile number cannot be blank!")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	@Size(min = 10, max = 10)
	private String mobile;
	
	@NotNull(message = "Location cannot be null!")
	@NotBlank(message = "Location connot be blank!")
	@Pattern(regexp="^[a-zA-Z_]+([a-zA-Z_]+)*$", message = "Bus name should contain only letters")
	@Size(min=3,max=20, message = "busName should be of size between 3 to 20 charcters")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
	private List<ProducedGoodsToSell> goodsToSell = new ArrayList<>(); 
	
}
