package core.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.service.LogDebugService;
import core.api.service.LogExceptionService;
import core.model.LogDebug;
import core.model.LogException;
import core.service.LogDebugServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@AllArgsConstructor
public class LoggingAdvise {

    private LogDebugService logDebugService;
    private LogExceptionService logExceptionService;

    @Pointcut("@annotation(core.annotation.dbLog)")
    public void loggableMethods(){}

    @Around("loggableMethods()")
    public Object projectLogger(ProceedingJoinPoint point) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String methodName = point.getSignature().getName();
        String className = point.getTarget().getClass().getName();
        Object[] array = point.getArgs();

        LogDebug logDebug = new LogDebug();
        logDebug.setParams("Params: " + objectMapper.writeValueAsString(array) + ", Method Name " + methodName + ", class " + className);
        logDebugService.create(logDebug);

        log.info("Метод " + methodName + " из класса " + className + " с параметрами " + objectMapper.writeValueAsString(array));

        Object object = null;

        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            LogException logException = new LogException();
            logException.setParams("Params: " + objectMapper.writeValueAsString(array) + ", Method Name " + methodName + ", class " + className);
            logExceptionService.create(logException);
            throwable.printStackTrace();
        }

        log.info("Метод " + methodName + " из класса " + className + " выполнен. Response: " + objectMapper.writeValueAsString(object));

        return object;
    }
}
