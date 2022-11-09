package core.api.service;

import core.model.LogDebug;

import java.util.UUID;

public interface LogDebugService {
    LogDebug get(UUID id);
    LogDebug getAndInitialize(UUID id);
    LogDebug create(LogDebug logDebug);
}
