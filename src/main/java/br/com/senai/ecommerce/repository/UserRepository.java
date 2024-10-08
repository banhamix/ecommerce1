package br.com.senai.ecommerce.repository;

import br.com.senai.ecommerce.emtities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
