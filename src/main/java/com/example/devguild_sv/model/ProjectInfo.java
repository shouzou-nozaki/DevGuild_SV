package com.example.devguild_sv.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "projectInfo")
public class ProjectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // プロジェクト名
    @Column(nullable = false)
    private String ProjectName;       

    // 募集人数
    @Column(nullable = false)
    private int RecruiteNumber;

    // 期限日
    @Column(nullable = false)
    private LocalDate DueDate;

    // 説明
    @Column(length = 1000)
    private String Description;

    // ID取得
    public Long getId() {
        return Id;
    }

    // IDセット
    public void setId(Long id) {
        this.Id = id;
    }

    // プロジェクト名取得
    public String getName() {
        return ProjectName;
    }

    // プロジェクト名セット 
    public void setName(String projectName) {
        this.ProjectName = projectName;
    }
    
    // 募集人数取得
    public int getRecruiteNumber() {
        return RecruiteNumber;
    }
    // 募集人数セット
    public void setRecruiteNumber(int recruiteNumber) {
        this.RecruiteNumber = recruiteNumber;
    }
    
    // 期限日取得
    public LocalDate getDueDate() {
        return DueDate;
    }
    
    // 期限日セット
    public void setDueDate(LocalDate dueDate) {
        this.DueDate = dueDate;
    }

    // 説明取得
    public String getDescription() {
        return Description;
    }
    
    // 説明セット
    public void setDescription(String description) {
        this.Description = description;
    }
}
