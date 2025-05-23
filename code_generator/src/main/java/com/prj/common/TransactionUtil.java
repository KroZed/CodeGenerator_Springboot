package com.prj.common;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TransactionUtil {
    @Transactional(rollbackFor = RuntimeException.class)
    public <E extends Throwable> void scope(RunnableException<E> runnable) throws E {
        scope(() -> {
            runnable.run();
            return null;
        });
    }
    @Transactional(rollbackFor = RuntimeException.class)
    public <T, E extends Throwable> T scope(SupplierException<T, E> supplier) throws E {
        return supplier.get();
    }
    @FunctionalInterface
    public interface RunnableException<E extends Throwable> {
        void run() throws E;
    }
    @FunctionalInterface
    public interface SupplierException<T, E extends Throwable> {
        T get() throws E;
    }
}
