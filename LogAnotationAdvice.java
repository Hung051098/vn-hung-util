@Slf4j
@Aspect
@Component
public class MeasureTimeAdvice {
    @Around("@annotation(com.package.ap.configuration.measuretime.MeasureTime)")
    public Object measureTime(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = point.proceed();
        stopWatch.stop();
        log.info("Time take by " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "() method is "
                + stopWatch.getTotalTimeMillis() + " ms");
        return object;
    }
}
 
 