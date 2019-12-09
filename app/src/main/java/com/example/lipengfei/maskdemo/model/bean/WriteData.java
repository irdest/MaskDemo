package com.example.lipengfei.maskdemo.model.bean;


/**
 * Author: qzns木雨
 * Date:2018/12/4
 * Description: 便签数据
 */
public class WriteData {
    //存储的时间
    private long saveTime;

    //保存的字符串内容
    private String content;

    public void setSaveTime(long saveTime) {
        this.saveTime = saveTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSaveTime() {
        return saveTime;
    }

    public String getContent() {
        return content;
    }
}
