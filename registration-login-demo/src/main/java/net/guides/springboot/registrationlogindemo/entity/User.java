package net.guides.springboot.registrationlogindemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(nullable = false)
	private String name ;
	
	
	@Column(nullable = false , unique = true)
	private String email;
	
	
	
	@Column(nullable = false)
	private String password;

	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            		joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
                    inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	
	private List<Role> roles = new ArrayList<>();
	
	
	
	
	

}
