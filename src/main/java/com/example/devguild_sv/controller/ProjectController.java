package com.example.devguild_sv.controller;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.service.ProjectInfoService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

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
    
    @RequestMapping("/project/myproject")
    /**
     * プロジェクト検索用エンドポイント
     * @param body 検索条件
     * @return プロジェクト情報
     */
    public ResponseEntity<List<ProjectInfo>> getMyProject(@RequestBody Map<String, Object>  body){
    	try {
    		body.forEach((key, value) -> System.out.println(key + ":" + value));
    		
    		// searchCondの取り出し
    		Map<String, Object> searchCond = (Map<String, Object>) body.get("searchCond");
//    		String userId = (String) searchCond.get("UserId");
    		List<ProjectInfo> response = projectInfoService.getProject(searchCond);
    		
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("エラー: " + e.getMessage());
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