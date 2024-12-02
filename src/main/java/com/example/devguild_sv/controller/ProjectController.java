package com.example.devguild_sv.controller;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.service.ProjectInfoService;

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
    @Autowired
    private ProjectInfoService projectInfoService;

    // プロジェクト一覧取得用エンドポイント
    @RequestMapping("/project/search")
    public ResponseEntity<List<ProjectInfo>> getAllProjects() {
        try {
        	// 全プロジェクト情報の取得
        	var response = projectInfoService.getProject();
            // フロントに返却
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/project/create")
    /**
     * プロジェクト登録用エンドポイント
     * @param projectInfo 登録プロジェクト情報
     * @return　
     */
    public void createProject(@RequestBody ProjectInfo projectInfo) {
        try {
        	// プロジェクト情報の保存
        	projectInfoService.regProject(projectInfo);
            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}