package com.example.helloworld;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.JSONException;

import java.io.Serializable;
import java.util.List;

/**
 * @author 马克
 * @since 2023/11/10
 */
public class JSONDemo {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"resultCode\": \"6000802001001\",\n" +
                "    \"resultMsg\": \"校验签名: 校验签名失败, 请检查入参和签名[sign]字段\",\n" +
                "    \"sign\": \"p9vhsMuNnd770X0isXXMpi8NZEKCS6lpvdUx75roMYmdV/hBqh/aFjFECm+pMffA4lBMF2EJ3hLEnusV0kDygI/6wDE1QqVEJ/P8IkN7Zt90HD6y7BdhNNnVylLMAQDHdSi+U8SjqOpoyOvr4mZbfc38idmM3GDDcEQ5k+w5/Bc=\"\n" +
                "}";

        JSONObject entries = JSONUtil.parseObj(json);
        System.out.println(entries.get("resultMsg"));
    }

    static class DrugEventResponse implements Serializable {
        private static final long serialVersionUID = -344714425277878339L;
        private String eventId;
        private Integer eventType;
        private String dpDrugCode;
        private Boolean result;
        private String msg;

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public Integer getEventType() {
            return eventType;
        }

        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }

        public String getDpDrugCode() {
            return dpDrugCode;
        }

        public void setDpDrugCode(String dpDrugCode) {
            this.dpDrugCode = dpDrugCode;
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DrugEventResponseResult{");
            sb.append("eventId='").append(eventId).append('\'');
            sb.append(", eventType=").append(eventType);
            sb.append(", dpDrugCode='").append(dpDrugCode).append('\'');
            sb.append(", result=").append(result);
            sb.append(", msg='").append(msg).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
