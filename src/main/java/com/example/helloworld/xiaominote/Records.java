/**
  * Copyright 2024 bejson.com 
  */
package com.example.helloworld.xiaominote;
import java.util.List;

/**
 * Auto-generated: 2024-03-18 18:10:30
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Records {

    private String recordId;
    private String groupGuid;
    private String rawTitle;
    private String rawText;
    private long version;
    private int status;
    private List<String> attachments;
    private long createTime;
    private long updateTime;
    private int topTime;
    private int recycleTime;
    private int alarmTime;
    private int deleteTime;
    private String skinId;
    private String extra;
    public void setRecordId(String recordId) {
         this.recordId = recordId;
     }
     public String getRecordId() {
         return recordId;
     }

    public void setGroupGuid(String groupGuid) {
         this.groupGuid = groupGuid;
     }
     public String getGroupGuid() {
         return groupGuid;
     }

    public void setRawTitle(String rawTitle) {
         this.rawTitle = rawTitle;
     }
     public String getRawTitle() {
         return rawTitle;
     }

    public void setRawText(String rawText) {
         this.rawText = rawText;
     }
     public String getRawText() {
         return rawText;
     }

    public void setVersion(long version) {
         this.version = version;
     }
     public long getVersion() {
         return version;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setAttachments(List<String> attachments) {
         this.attachments = attachments;
     }
     public List<String> getAttachments() {
         return attachments;
     }

    public void setCreateTime(long createTime) {
         this.createTime = createTime;
     }
     public long getCreateTime() {
         return createTime;
     }

    public void setUpdateTime(long updateTime) {
         this.updateTime = updateTime;
     }
     public long getUpdateTime() {
         return updateTime;
     }

    public void setTopTime(int topTime) {
         this.topTime = topTime;
     }
     public int getTopTime() {
         return topTime;
     }

    public void setRecycleTime(int recycleTime) {
         this.recycleTime = recycleTime;
     }
     public int getRecycleTime() {
         return recycleTime;
     }

    public void setAlarmTime(int alarmTime) {
         this.alarmTime = alarmTime;
     }
     public int getAlarmTime() {
         return alarmTime;
     }

    public void setDeleteTime(int deleteTime) {
         this.deleteTime = deleteTime;
     }
     public int getDeleteTime() {
         return deleteTime;
     }

    public void setSkinId(String skinId) {
         this.skinId = skinId;
     }
     public String getSkinId() {
         return skinId;
     }

    public void setExtra(String extra) {
         this.extra = extra;
     }
     public String getExtra() {
         return extra;
     }

    @Override
    public String toString() {
        return "Records{" +
                "recordId='" + recordId + '\'' +
                ", groupGuid='" + groupGuid + '\'' +
                ", rawTitle='" + rawTitle + '\'' +
                ", rawText='" + rawText + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", attachments=" + attachments +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", topTime=" + topTime +
                ", recycleTime=" + recycleTime +
                ", alarmTime=" + alarmTime +
                ", deleteTime=" + deleteTime +
                ", skinId='" + skinId + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}