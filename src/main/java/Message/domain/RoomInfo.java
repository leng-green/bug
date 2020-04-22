package Message.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;

@Document
public class RoomInfo {
    @Id
    private String id;

    private int orgId;
    private String roomNumber;
    private int type;
    private String data;
    private String des;
    private int subId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "id='" + id + '\'' +
                ", orgId=" + orgId +
                ", roomNumber='" + roomNumber + '\'' +
                ", type=" + type +
                ", data='" + data + '\'' +
                ", des='" + des + '\'' +
                ", subId=" + subId +
                '}';
    }
}
