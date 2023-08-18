package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.NoticesController;
import com.rbank.rbank.dto.NoticeResponse;
import com.rbank.rbank.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticesControllerImpl implements NoticesController {

    private final NoticeService noticeService;

    @Override
    @GetMapping
    public ResponseEntity<List<NoticeResponse>> getNoticesDetails() {
        return noticeService.getNoticesDetails();
    }

}

