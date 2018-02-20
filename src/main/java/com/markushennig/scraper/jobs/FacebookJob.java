package com.markushennig.scraper.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class FacebookJob {

    final static Logger logger = LoggerFactory.getLogger(FacebookJob.class);

    @Scheduled(fixedRate = 5000)
    public boolean checkOnlineStatus() {
        logger.info("Checking Online Status.");
        return false;
    }
}
