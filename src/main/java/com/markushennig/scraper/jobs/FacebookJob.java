package com.markushennig.scraper.jobs;

import com.markushennig.scraper.services.FacebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class FacebookJob {

    final static Logger logger = LoggerFactory.getLogger(FacebookJob.class);

    @Autowired
    FacebookService service;

    private static final String NAME = "Aya";

    @Scheduled(fixedRate = 5000)
    public boolean checkOnlineStatus() {
        logger.info("Checking Online Status.");
        return service.isOnline(NAME);
    }
}
