package br.com.surb.surb.modules.user.infra.jps.repositories;

import br.com.surb.surb.modules.user.infra.jps.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User, Long> {
}
