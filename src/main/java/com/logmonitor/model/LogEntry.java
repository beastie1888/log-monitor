package com.logmonitor.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogEntry {
    public enum Severity {ERROR, INFO, DEBUG}

    private String message;
    private Severity severity;
}