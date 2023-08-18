package com.rbank.rbank.mapper;

import com.rbank.rbank.dto.NoticeResponse;
import com.rbank.rbank.model.Notice;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class NoticeMapper implements Function<Notice, NoticeResponse> {

    @Override
    public NoticeResponse apply(Notice notice) {
        return NoticeResponse.builder()
                .noticeId(notice.getNoticeId())
                .noticeSummary(notice.getNoticeSummary())
                .noticeDetails(notice.getNoticeDetails())
                .noticeBegDt(notice.getNoticeBegDt())
                .noticeEndDt(notice.getNoticeEndDt())
                .createDt(notice.getCreateDt())
                .updateDt(notice.getUpdateDt())
                .build();
    }

}
