package com.shopping.vo;

import java.util.Date;

public class BoardVo {

    private Long sn;
    private String title;
    private String cn;
    private Date modifyDate;
    private Long fileSn;
    
    public BoardVo(Long sn, String title, String cn, Date modifyDate, Long fileSn) {
        super();
        this.sn = sn;
        this.title = title;
        this.cn = cn;
        this.modifyDate = modifyDate;
        this.fileSn = fileSn;
    }
    public Long getSn() {
        return sn;
    }
    public void setSn(Long sn) {
        this.sn = sn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCn() {
        return cn;
    }
    public void setCn(String cn) {
        this.cn = cn;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public Long getFileSn() {
        return fileSn;
    }
    public void setFileSn(Long fileSn) {
        this.fileSn = fileSn;
    }
    
    @Override
    public String toString() {
        return "BoardVo [sn=" + sn + ", title=" + title + ", cn=" + cn + ", modifyDate=" + modifyDate + ", fileSn="
                + fileSn + "]";
    }
}
