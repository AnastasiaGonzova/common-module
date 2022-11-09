package core.service;

import core.api.repository.LogExceptionRepository;
import core.api.service.LogExceptionService;
import core.model.LogDebug;
import core.model.LogException;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class LogExceptionServiceImpl implements LogExceptionService {

    private LogExceptionRepository logExceptionRepository;

    @Override
    public LogException get(UUID id) {
        return logExceptionRepository.getById(id);
    }

    @Override
    public LogException getAndInitialize(UUID id) {
        LogException logException = logExceptionRepository.getById(id);
        Hibernate.initialize(logException);
        return logException;
    }

    @Override
    public LogException create(LogException logException) {
        return logExceptionRepository.saveAndFlush(logException);
    }
}
