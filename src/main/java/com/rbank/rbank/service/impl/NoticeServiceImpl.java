package com.rbank.rbank.service.impl;

import com.rbank.rbank.dto.NoticeResponse;
import com.rbank.rbank.mapper.NoticeMapper;
import com.rbank.rbank.model.Notice;
import com.rbank.rbank.repository.NoticeRepository;
import com.rbank.rbank.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    @Override
    public List<NoticeResponse> getNoticesDetails() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        return (notices.stream().map(noticeMapper).toList());
    }
}


