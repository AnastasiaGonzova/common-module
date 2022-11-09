package core.service;

import core.api.repository.LogDebugRepository;
import core.api.service.LogDebugService;
import core.model.LogDebug;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class LogDebugServiceImpl implements LogDebugService {

    private LogDebugRepository logDebugRepository;

    @Override
    public LogDebug get(UUID id) {
        return logDebugRepository.getById(id);
    }

    @Override
    public LogDebug getAndInitialize(UUID id) {
        LogDebug logDebug = logDebugRepository.getById(id);
        Hibernate.initialize(logDebug);
        return logDebug;
    }

    @Override
    public LogDebug create(LogDebug logDebug) {
        return logDebugRepository.saveAndFlush(logDebug);
    }
}
