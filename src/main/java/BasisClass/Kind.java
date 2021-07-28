package BasisClass;

public class Kind {

    private int kindId;
    private String kindName;
    private String kindDescription;
    private double kindRatio;

    public Kind() {
    }

    public Kind(int kindId, String kindName, String kindDescription, double kindRatio) {
        this.kindId = kindId;
        this.kindName = kindName;
        this.kindDescription = kindDescription;
        this.kindRatio = kindRatio;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindDescription() {
        return kindDescription;
    }

    public void setKindDescription(String kindDescription) {
        this.kindDescription = kindDescription;
    }

    public double getKindRatio() {
        return kindRatio;
    }

    public void setKindRatio(double kindRatio) {
        this.kindRatio = kindRatio;
    }
}
