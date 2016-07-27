package com.trip.multipart;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class FileUploadProgressListener implements ProgressListener {

    /**
     * 上传进度状态字段
     */
    public static final String UP_PROGRESS_FEIED = "up_progress_status";

    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        Progress status = new Progress();
        session.setAttribute(UP_PROGRESS_FEIED, status);
    }

    /**
     *
     * @param bytesRead     到目前为止读取文件的字节数
     * @param contentLength 文件总大小
     * @param items         目前正在读取第几个文件
     */
    @Override
    public void update(long bytesRead, long contentLength, int items) {
        Progress status = (Progress) session.getAttribute(UP_PROGRESS_FEIED);
        status.setBytesRead(bytesRead);
        status.setContentLength(contentLength);
        status.setItems(items);
    }

}