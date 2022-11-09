package core.api.repository;

import core.model.LogDebug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogDebugRepository extends JpaRepository<LogDebug, UUID> {
}
