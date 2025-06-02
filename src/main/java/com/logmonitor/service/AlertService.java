package com.logmonitor.service;

import com.logmonitor.model.LogEntry;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
    public boolean matchesAlertRule(LogEntry entry) {
        return entry.getSeverity().name().equals("ERROR") && entry.getMessage().contains("database");
    }

    public void sendAlert(LogEntry entry) {
        // Send email, Slack message, or webhook
    }
}