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
public class Data {

    private boolean hasMore;
    private int totalCount;
    private List<Records> records;
    public void setHasMore(boolean hasMore) {
         this.hasMore = hasMore;
     }
     public boolean getHasMore() {
         return hasMore;
     }

    public void setTotalCount(int totalCount) {
         this.totalCount = totalCount;
     }
     public int getTotalCount() {
         return totalCount;
     }

    public void setRecords(List<Records> records) {
         this.records = records;
     }
     public List<Records> getRecords() {
         return records;
     }

}