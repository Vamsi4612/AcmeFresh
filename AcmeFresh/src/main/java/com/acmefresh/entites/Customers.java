package com.acmefresh.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name connot be blank!")
	@Pattern(regexp="^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "User name should contain only letters")
	@Size(min=3,max=20, message = "UserName should be of size between 3 to 20 charcters")
	private String userName ;
	
	@NotNull(message="Password cannot be null!")
	@NotBlank(message= "Password cannot be blank!")
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include alphanumerics and special characters")
	private String password ;
	
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
	
	@Email
	private String email ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Plants> plantsChoosen = new ArrayList<>(); 
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<AutomationTechniques> techniquesChoosen = new ArrayList<>();
	
	private Integer amountPaid;
	
}
