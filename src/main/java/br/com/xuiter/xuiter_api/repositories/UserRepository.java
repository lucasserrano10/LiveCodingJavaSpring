package br.com.xuiter.xuiter_api.repositories;

import br.com.xuiter.xuiter_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
