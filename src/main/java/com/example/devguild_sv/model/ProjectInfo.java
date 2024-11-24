package com.example.devguild_sv.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projectinfo")
public class ProjectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProjectId;

    // プロジェクト名
    @Column(name = "project_name", nullable = false)
    private String ProjectName;

    // 募集人数
    @Column(name = "recruite_number", nullable = false)
    private int RecruiteNumber;

    // 期限日
    @Column(name = "duedate", nullable = false)
    private LocalDate DueDate;

    // 説明
    @Column(name = "description", length = 1000)
    private String Description;

    // 求めるスキル（JSON形式で保存）
    @Column(name = "requirements", columnDefinition = "json")
    private List<String> Requirements;

    // プロジェクトID
    public Long getProjectId() {
        return ProjectId;
    }
    // プロジェクト名
    public String getProjectName() {
        return ProjectName;
    }
    // 募集人数
    public int getRecruiteNumber() {
        return RecruiteNumber;
    }
    // 期限日
    public LocalDate getDueDate() {
        return DueDate;
    }
    // 説明
    public String getDescription() {
        return Description;
    }
    // 求めるスキル
    public List<String> getRequirements() {
        return Requirements;
    }

    // プロジェクトID
    public void setProjectId(Long projectId) {
        this.ProjectId = projectId;
    }
    // プロジェクト名
    public void setProjectName(String projectName) {
        this.ProjectName = projectName;
    }
    // 募集人数
    public void setRecruiteNumber(int recruiteNumber) {
        this.RecruiteNumber = recruiteNumber;
    }
    // 期限日
    public void setDueDate(LocalDate dueDate) {
        this.DueDate = dueDate;
    }
    // 説明
    public void setDescription(String description) {
        this.Description = description;
    }
    // 求めるスキル
    public void setRequirements(List<String> requirements) {
        this.Requirements = requirements;
    }
}
