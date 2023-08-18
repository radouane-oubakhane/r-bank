package com.rbank.rbank.service;

import com.rbank.rbank.dto.NoticeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoticeService {
    ResponseEntity<List<NoticeResponse>> getNoticesDetails();
}
