package com.example.user.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "oa_relation")
@Data
public class OaRelation {
    @Id
    private String id;

    private String uid;

    private String sid;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public OaRelation(String id, String uid, String sid) {
        this.id = id;
        this.uid = uid;
        this.sid = sid;
    }
}