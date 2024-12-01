package com.example.devguild_sv.controller;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.dao.UserInfoDAO;
import com.example.devguild_sv.dto.UserInfoDTO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.entity.UserInfo;
import com.example.devguild_sv.service.UserInfoService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * ユーザー情報用コントローラ
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;

    // プロジェクト一覧取得用エンドポイント
    @PostMapping("/user/login")
    public ResponseEntity<UserInfoDTO> getUser(@RequestBody UserInfo userInfo) {
        try {
        	// ユーザーログイン処理
        	var response = userInfoService.userLogin(userInfo);
            // フロントに返却
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}