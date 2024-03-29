package com.rbank.rbank.controller;

import com.rbank.rbank.dto.NoticeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoticesController {
    ResponseEntity<List<NoticeResponse>> getNoticesDetails();
}
