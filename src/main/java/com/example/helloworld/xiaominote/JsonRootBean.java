package com.example.helloworld.xiaominote;

public class JsonRootBean {

    private String snippet;
    private long modifyDate;
    private int colorId;
    private String subject;
    private int alertDate;
    private String type;
    private int folderId;
    private int alertTag;
    private String id;
    private String tag;
    private long createDate;
    private String status;

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setAlertDate(int alertDate) {
        this.alertDate = alertDate;
    }

    public int getAlertDate() {
        return alertDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setAlertTag(int alertTag) {
        this.alertTag = alertTag;
    }

    public int getAlertTag() {
        return alertTag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "snippet='" + snippet + '\'' +
                ", modifyDate=" + modifyDate +
                ", colorId=" + colorId +
                ", subject='" + subject + '\'' +
                ", alertDate=" + alertDate +
                ", type='" + type + '\'' +
                ", folderId=" + folderId +
                ", alertTag=" + alertTag +
                ", id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}