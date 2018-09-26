package com.ayt.entity;

import java.util.Date;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 00:06
 * @Description: Don't worry ,just try
 * 头条
 */
public class HeadLine {
    private Integer line_id;
    private String line_name;
    private String     line_link;
    private String line_img;
    private Integer priority;
    private Integer enable_status;
    private Date create_time;
    private Date last_edit_time;

    public Integer getLine_id() {
        return line_id;
    }

    public void setLine_id(Integer line_id) {
        this.line_id = line_id;
    }

    public String getLine_name() {
        return line_name;
    }

    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    public String getLine_link() {
        return line_link;
    }

    public void setLine_link(String line_link) {
        this.line_link = line_link;
    }

    public String getLine_img() {
        return line_img;
    }

    public void setLine_img(String line_img) {
        this.line_img = line_img;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnable_status() {
        return enable_status;
    }

    public void setEnable_status(Integer enable_status) {
        this.enable_status = enable_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_edit_time() {
        return last_edit_time;
    }

    public void setLast_edit_time(Date last_edit_time) {
        this.last_edit_time = last_edit_time;
    }


}
