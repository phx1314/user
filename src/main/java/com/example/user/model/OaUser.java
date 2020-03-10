package com.example.user.model;

import javax.persistence.*;

@Table(name = "oa_user")
public class OaUser {
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    @Column(name = "job_number")
    private String jobNumber;

    /**
     * 部门
     */
    private String department;

    /**
     * 办公软件id
     */
    @Column(name = "oa_ids")
    private String oaIds;

    /**
     * 其他软件
     */
    @Column(name = "other_oa")
    private String otherOa;

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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取工号
     *
     * @return job_number - 工号
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * 设置工号
     *
     * @param jobNumber 工号
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    /**
     * 获取部门
     *
     * @return department - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 获取办公软件id
     *
     * @return oa_ids - 办公软件id
     */
    public String getOaIds() {
        return oaIds;
    }

    /**
     * 设置办公软件id
     *
     * @param oaIds 办公软件id
     */
    public void setOaIds(String oaIds) {
        this.oaIds = oaIds == null ? null : oaIds.trim();
    }

    /**
     * 获取其他软件
     *
     * @return other_oa - 其他软件
     */
    public String getOtherOa() {
        return otherOa;
    }

    /**
     * 设置其他软件
     *
     * @param otherOa 其他软件
     */
    public void setOtherOa(String otherOa) {
        this.otherOa = otherOa == null ? null : otherOa.trim();
    }
}