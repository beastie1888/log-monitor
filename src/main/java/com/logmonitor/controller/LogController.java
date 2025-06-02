package com.logmonitor.controller;

import com.logmonitor.model.LogRequest;
import com.logmonitor.service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<Void> ingestLog(@Valid @RequestBody LogRequest log) {
        logService.processLog(log);
        return ResponseEntity.ok().build();
    }
}