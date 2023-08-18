package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.NoticeResponse;
import com.rbank.rbank.mapper.NoticeMapper;
import com.rbank.rbank.model.Notice;
import com.rbank.rbank.repository.NoticeRepository;
import com.rbank.rbank.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    @Override
    public ResponseEntity<List<NoticeResponse>> getNoticesDetails() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices.stream().map(noticeMapper).toList());
    }
}


