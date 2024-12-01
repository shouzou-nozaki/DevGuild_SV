package com.example.devguild_sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.dao.UserInfoDAO;
import com.example.devguild_sv.dto.UserInfoDTO;
import com.example.devguild_sv.entity.UserInfo;

/*
 * ユーザ―情報用サービスクラス
 */
@Service
public class UserInfoService {
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	/**
	 * ログインユーザー情報取得
	 * @param userInfo ユーザー情報
	 * @return ユーザー情報(ユーザーID, ユーザー名)
	 */
	public UserInfoDTO userLogin(UserInfo userInfo) {
		// ユーザー名が入力されている場合は、新規登録
		if(!userInfo.UserName.equals("")) userInfoDAO.regNewUser(userInfo);
		// ユーザー情報取得
		return userInfoDAO.getRegisterdUser(userInfo);
	}
}
