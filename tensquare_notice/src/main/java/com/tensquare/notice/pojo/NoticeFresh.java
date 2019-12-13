package com.tensquare.notice.pojo;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/13 10:18
 * @Version: 0.0.1
 **/
@TableName("tb_notice_fresh")
public class NoticeFresh {
    private String userId;
    private String noticeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }
}
