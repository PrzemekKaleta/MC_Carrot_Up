package BasisClass;

public class Tag {

    private int tagId;
    private String tagName;
    private String tagDescription;
    private boolean tagActive;

    public Tag() {}

    public Tag(int tagId, String tagName, String tagDescription, boolean tagActive) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.tagActive = tagActive;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public boolean isTagActive() {
        return tagActive;
    }

    public void setTagActive(boolean tagActive) {
        this.tagActive = tagActive;
    }
}
