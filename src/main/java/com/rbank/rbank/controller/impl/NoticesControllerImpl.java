package com.rbank.rbank.controller.impl;

import com.rbank.rbank.controller.NoticesController;
import com.rbank.rbank.dto.NoticeResponse;
import com.rbank.rbank.repository.AuthorityRepository;
import com.rbank.rbank.service.LoginService;
import com.rbank.rbank.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticesControllerImpl implements NoticesController {

    private final NoticeService noticeService;
    private final LoginService loginService;
    private final AuthorityRepository authorityRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<NoticeResponse>> getNoticesDetails() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticeService.getNoticesDetails());
    }

}

