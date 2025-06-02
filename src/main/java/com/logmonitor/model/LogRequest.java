package com.logmonitor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogRequest {

    @NotNull
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @NotBlank
    @JsonProperty("level")
    private String level; // e.g. INFO, WARN, ERROR

    @NotBlank
    @JsonProperty("message")
    private String message;

    @JsonProperty("service")
    private String service; // optional, e.g. "auth-service"

    @JsonProperty("host")
    private String host; // optional, e.g. "server-1"
}
