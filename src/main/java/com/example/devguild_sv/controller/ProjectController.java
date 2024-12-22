package com.example.devguild_sv.controller;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.service.ProjectInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDateTime;
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
	public ResponseEntity<List<ProjectInfo>> getAllProjects(@RequestBody Map<String, Object> body) {
		try {
			// キー情報ログ出力
			outputHttpLog(body, "Search");

			// 全プロジェクト情報の取得
			var response = projectInfoService.getProject();
			// フロントに返却
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * プロジェクト登録用エンドポイント
	 * 
	 * @param projectInfo 登録プロジェクト情報
	 * @return
	 */
	@PostMapping("/project/create")
	public void createProject(@RequestBody Map<String, Object> body) {
		try {
			outputHttpLog(body, "Create");
			// パラメータ取得
			Map<String, Object> param = (Map<String, Object>) body.get("param");

			ProjectInfo projectInfo = new ObjectMapper().convertValue(param, ProjectInfo.class);

			// プロジェクト情報の保存
			projectInfoService.regProject(projectInfo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * プロジェクト検索用エンドポイント
	 * 
	 * @param body 検索条件
	 * @return プロジェクト情報
	 */
	@RequestMapping("/project/myproject")
	public ResponseEntity<List<ProjectInfo>> getMyProject(@RequestBody Map<String, Object> body) {
		try {
			// キー情報ログ出力
			outputHttpLog(body, "MyProject");
			// パラメータ取得
			String userid = (String) body.get("param");

			List<ProjectInfo> response = projectInfoService.getProject(userid);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("エラー: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * プロジェクト変更用エンドポイント
	 * @param projectInfo 登録プロジェクト情報
	 * @return
	 */
	@PostMapping("/project/update")
	public void updateProject(@RequestBody Map<String, Object> body) {
		try {
			outputHttpLog(body, "Update");
			// パラメータ取得
			Map<String, Object> param = (Map<String, Object>) body.get("param");

			ProjectInfo projectInfo = new ObjectMapper().convertValue(param, ProjectInfo.class);

			// プロジェクト情報の保存
			projectInfoService.updateProject(projectInfo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * プロジェクト変更用エンドポイント
	 * @param projectInfo 登録プロジェクト情報
	 * @return
	 */
	@PostMapping("/project/delete")
	public void deleteProject(@RequestBody Map<String, Object> body) {
		try {
			outputHttpLog(body, "Delete");
			// パラメータ取得
			String projectId =  body.get("param").toString();
			
			// プロジェクト情報の保存
			projectInfoService.deleteProject(projectId);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * HTTPログ出力処理
	 * @param body リクエストbody
	 */
	private static void outputHttpLog(Map<String, Object> body, String endPoint) {
		System.out.println("********************【 " + endPoint + " 】********************");
		body.forEach((key, value) -> System.out.println(key + ":" + value));
	}

}