package com.rbank.rbank.service;

import com.rbank.rbank.dto.NoticeResponse;

import java.util.List;

public interface NoticeService {
    List<NoticeResponse> getNoticesDetails();
}
