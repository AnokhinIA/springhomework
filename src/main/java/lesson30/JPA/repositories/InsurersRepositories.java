package lesson30.JPA.repositories;

import lesson30.JPA.model.Insurers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurersRepositories extends JpaRepository<Insurers,Long> {
}
