package backend.e_com.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.e_com.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByProviderIdAndProviderType(String providerId, backend.e_com.entity.type.providerIdType providerType);
 }
