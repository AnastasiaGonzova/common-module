package core.api.service;

import core.model.LogException;

import java.util.UUID;

public interface LogExceptionService {
    LogException get(UUID id);
    LogException getAndInitialize(UUID id);
    LogException create(LogException logException);
}
