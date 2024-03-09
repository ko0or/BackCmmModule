package back.cmm.module.cmm.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class SchedulerServiceImpl {

    /* 프로젝트 실행시 최초 실행 */
    @PostConstruct
    public void init() {
        executeTask();
    }

     /* 실행후, 매일 0시에 실행 */
//    @Scheduled(fixedRate = 10_000L)
    @Scheduled(cron = "0 0 0 * * *")
    public void executeDailyTask() {
        executeTask();
    }

     /* 실행될 내용 */
    private void executeTask() {
        log.info("=============== $#$# ===============> 작업이 실행됩니다: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

    }

}