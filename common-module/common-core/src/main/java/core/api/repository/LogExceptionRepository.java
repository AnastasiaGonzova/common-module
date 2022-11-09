package core.api.repository;

import core.model.LogException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogExceptionRepository extends JpaRepository<LogException, UUID> {
}
