package com.example.devguild_sv.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "projectinfo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ProjectId")
    private Long ProjectId;

    // 作成ユーザー
    @Column(name = "user_id", nullable = false)
    @JsonProperty("UserId")
    private String UserId;
    
    // プロジェクト名
    @Column(name = "project_name", nullable = false)
    @JsonProperty("ProjectName")
    private String ProjectName;

    // 募集人数
    @Column(name = "recruite_number", nullable = false)
    @JsonProperty("RecruiteNumber")
    private String RecruiteNumber;

    // 期限日
    @Column(name = "duedate", nullable = false)
    @JsonProperty("DueDate")
    private String DueDate;

    // 説明
    @Column(name = "description", length = 1000)
    @JsonProperty("Description")
    private String Description;

    // 求めるスキル（JSON形式で保存）
    @Column(name = "requirements", columnDefinition = "json")
    @JsonProperty("Requirements")
    private ArrayList<String> Requirements;

    // 参画ユーザー
    @Column(name = "project_member", columnDefinition = "json")
    @JsonProperty("ProjectMember")
    private ArrayList<String> ProjectMember;

    
    // プロジェクトID
    public Long getProjectId() {
        return ProjectId;
    }
    
    // ユーザーID
    public String getUserId() {
    	return UserId;
    }
    // プロジェクト名
    public String getProjectName() {
        return ProjectName;
    }
    // 募集人数
    public String getRecruiteNumber() {
        return RecruiteNumber;
    }
    // 期限日
    public String getDueDate() {
        return DueDate;
    }
    // 説明
    public String getDescription() {
        return Description;
    }
    // 求めるスキル
    public ArrayList<String> getRequirements() {
        return Requirements;
    }
    // 作成ユーザー
    public String getCreateUser() {
    	return UserId;
    }
    // 参画ユーザー
    public ArrayList<String> getJoiningUser() {
    	return ProjectMember;
    }

    
    
    // プロジェクトID
    public void setProjectId(Long projectId) {
        this.ProjectId = projectId;
    }
    // ユーザーID
    public void setUserId(String userId) {
    	this.UserId = userId;
    }
    // プロジェクト名
    public void setProjectName(String projectName) {
        this.ProjectName = projectName;
    }
    // 募集人数
    public void setRecruiteNumber(String recruiteNumber) {
        this.RecruiteNumber = recruiteNumber;
    }
    // 期限日
    public void setDueDate(String dueDate) {
        this.DueDate = dueDate;
    }
    // 説明
    public void setDescription(String description) {
        this.Description = description;
    }
    // 求めるスキル
    public void setRequirements(ArrayList<String> requirements) {
        this.Requirements = requirements;
    }
    
 // 求めるスキル
    public void setProjectMember(ArrayList<String> projectMember) {
        this.ProjectMember = projectMember;
    }
    
}
