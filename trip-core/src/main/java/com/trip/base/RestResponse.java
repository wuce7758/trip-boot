package com.trip.base;

/**
 * rest返回对象
 *
 * @param <T>
 */
public class RestResponse<T> {

    /**
     * 服务器响应数据
     */
    private T payload;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 错误信息
     */
    private RestError error;

    /**
     * 服务器响应时间
     */
    private long timestamp;

    public RestResponse() {
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public RestResponse(T payload) {
        this.success = true;
        this.payload = payload;
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public RestResponse(boolean success) {
        this.success = success;
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public RestResponse(RestError error) {
        this.success = false;
        this.error = error;
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(RestError error) {
        this.success = false;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public RestError getError() {
        return error;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.setPayload(payload, true);
    }

    public void setPayload(T payload, boolean success) {
        this.payload = payload;
        this.success = success;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "payload=" + payload +
                ", success=" + success +
                ", error=" + error +
                ", timestamp=" + timestamp +
                '}';
    }
}
