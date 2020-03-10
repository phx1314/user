package com.example.user.model;

import javax.persistence.*;

@Table(name = "oa_software")
public class OaSoftware {
    @Id
    private String id;

    /**
     * 软件名s
     */
    private String name;

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
     * 获取软件名s
     *
     * @return name - 软件名s
     */
    public String getName() {
        return name;
    }

    /**
     * 设置软件名s
     *
     * @param name 软件名s
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}