package com.example.devguild_sv.controller;

import com.example.devguild_sv.model.ProjectInfo;
import com.example.devguild_sv.service.ProjectService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // プロジェクト一覧取得用エンドポイント
    @GetMapping
    public ResponseEntity<List<ProjectInfo>> getAllProjects() {
        try {
        	System.out.print("プロジェクト取得を開始します。");
            List<ProjectInfo> projects = projectService.getAllProjects();
            
        	System.out.print("プロジェクト取得を終了します。");
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // プロジェクト登録用エンドポイント
    @PostMapping("/create")
    public ResponseEntity<ProjectInfo> createProject(@RequestBody ProjectInfo projectInfo) {
        try {
        	System.out.print("プロジェクト登録を開始します。");
        	// プロジェクト情報の保存処理
            ProjectInfo savedProject = projectService.saveProject(projectInfo);
            
            System.out.print("プロジェック登録を終了します。");
            
            // フロントに返却
            return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}