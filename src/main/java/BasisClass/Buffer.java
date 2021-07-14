package BasisClass;

import java.sql.Date;

public class Buffer {

    private int bufferId;
    private Date bufferDate;
    private double bufferUpload;
    private double bufferCarrots;

    public int getBufferId() {
        return bufferId;
    }

    public void setBufferId(int bufferId) {
        this.bufferId = bufferId;
    }

    public Date getBufferDate() {
        return bufferDate;
    }

    public void setBufferDate(Date bufferDate) {
        this.bufferDate = bufferDate;
    }

    public double getBufferUpload() {
        return bufferUpload;
    }

    public void setBufferUpload(double bufferUpload) {
        this.bufferUpload = bufferUpload;
    }

    public double getBufferCarrots() {
        return bufferCarrots;
    }

    public void setBufferCarrots(double bufferCarrots) {
        this.bufferCarrots = bufferCarrots;
    }
}
