package com.logmonitor.service;


import com.logmonitor.model.LogEntry;
import com.logmonitor.model.LogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    //private final LogRepository logRepository;
    @Autowired
    private AlertService alertService;

    public void processLog(LogRequest logRequest) {
        LogEntry entry = LogEntry.builder()
                .message(logRequest.getMessage())
                .severity(LogEntry.Severity.valueOf(logRequest.getLevel())).build();

        // TODO: store entry into DB
        if (alertService.matchesAlertRule(entry)) {
            alertService.sendAlert(entry);
        }
    }
}