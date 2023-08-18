package com.rbank.rbank.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponse {
    private Long noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date noticeBegDt;
    private Date noticeEndDt;
    private Date createDt;
    private Date updateDt;
}
