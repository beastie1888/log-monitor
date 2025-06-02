package com.logmonitor.controller;

import com.logmonitor.model.LogEntry;
import com.logmonitor.model.LogRequest;
import com.logmonitor.service.LogService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LogControllerTest {

    @Mock
    private LogService logService;

    @InjectMocks
    private LogController logController;

    public LogControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ingestLog_shouldCallProcessLogAndReturnOk() {
        LogRequest logRequest = new LogRequest();
        logRequest.setMessage("first message arrived");
        logRequest.setLevel(LogEntry.Severity.ERROR.name());

        ResponseEntity<Void> response = logController.ingestLog(logRequest);

        verify(logService, times(1)).processLog(logRequest);
        assertEquals(200, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
