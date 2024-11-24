package com.example.devguild_sv.controller;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.model.ProjectInfo;
//import com.example.devguild_sv.service.ProjectService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectInfoDAO projectInfoDAO;

    // プロジェクト一覧取得用エンドポイント
    @RequestMapping("/api")
    public ResponseEntity<List<ProjectInfo>> getAllProjects() {
        try {
        	// 全プロジェクト情報の取得
        	List<ProjectInfo> projectInfoList = projectInfoDAO.getAllProjectInfo();
        	
            // フロントに返却
            return new ResponseEntity<>(projectInfoList, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    /**
     * プロジェクト登録用エンドポイント
     * @param projectInfo 登録プロジェクト情報
     * @return　
     */
    public ResponseEntity<ProjectInfo> createProject(@RequestBody ProjectInfo projectInfo) {
        try {
        	// プロジェクト情報の保存
        	projectInfoDAO.saveProject(projectInfo);
        	
            // フロントに返却
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}