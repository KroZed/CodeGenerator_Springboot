package com.prj.quartz;
import com.prj.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableScheduling
public class QuartzSimpleJob {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Scheduled(cron = "0 0/1 * * * ?") // 每分钟执行一次
    public void work() throws Exception {
        logger.info(ProjectConfig.getProjectName() + "定时任务：每分钟执行一次。");
    }
}
