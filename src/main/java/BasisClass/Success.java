package BasisClass;

public class Success {

    private int successID;
    private int bufferID;
    private int kindID;
    private String successDescription;

    public Success() {
    }

    public Success(int bufferID, int kindID, String successDescription) {
        this.bufferID = bufferID;
        this.kindID = kindID;
        this.successDescription = successDescription;
    }

    public int getSuccessID() {
        return successID;
    }

    public void setSuccessID(int successID) {
        this.successID = successID;
    }

    public int getBufferID() {
        return bufferID;
    }

    public void setBufferID(int bufferID) {
        this.bufferID = bufferID;
    }

    public int getKindID() {
        return kindID;
    }

    public void setKindID(int kindID) {
        this.kindID = kindID;
    }

    public String getSuccessDescription() {
        return successDescription;
    }

    public void setSuccessDescription(String successDescription) {
        this.successDescription = successDescription;
    }
}
