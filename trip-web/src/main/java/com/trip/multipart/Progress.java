package com.trip.multipart;

import java.io.Serializable;

/**
 * 上传状态类
 */
public class Progress implements Serializable {

    /**
     * 已读字节
     */
    private long bytesRead = 0L;

    /**
     * 总长度
     */
    private long contentLength = 0L;

    /**
     * 当前读取个数
     */
    private int items;

    /**
     * 已读百分比
     */
    private String percent;

    public Progress() {
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}