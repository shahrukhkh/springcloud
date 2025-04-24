package in.hcl.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hcl.app.entity.UserEntity;

public interface UserEntityRepo extends JpaRepository<UserEntity, Long>{

	
	Optional<UserEntity> findByEmail(String email);
}
