package com.rbank.rbank.repository;

import com.rbank.rbank.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query(value = "from Notice n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
    List<Notice> findAllActiveNotices();
}
