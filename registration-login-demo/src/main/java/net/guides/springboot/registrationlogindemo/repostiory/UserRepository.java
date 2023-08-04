package net.guides.springboot.registrationlogindemo.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.registrationlogindemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

    User findByEmail(String email);
	

}
