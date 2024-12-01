package com.example.devguild_sv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.devguild_sv.dto.UserInfoDTO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.entity.UserInfo;
import com.example.devguild_sv.mapper.ProjectRowMapper;
import com.example.devguild_sv.mapper.UserInfoRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UserInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 登録ユーザー取得処理
	 * 
	 * @return ユーザー情報(ユーザーID,ユーザー名)
	 */
	public UserInfoDTO getRegisterdUser(UserInfo userInfo) {
		UserInfoDTO response = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    user_id, " );
			sb.append("    user_name ");
			sb.append("FROM ");
			sb.append("userinfo ");
			sb.append("WHERE ");
			sb.append("    email = ? ");
			sb.append("AND ");
			sb.append("    password = ? ");
			
			System.out.println(sb.toString());
			System.out.println("パラメータ：" + userInfo.Email + "," + userInfo.Password);
			// SQL発行と結果マッピング
			var selectedUser =  jdbcTemplate.query(sb.toString(), new UserInfoRowMapper(), userInfo.Email, userInfo.Password);
			for (UserInfoDTO user : selectedUser) {
				// 取得したユーザーを返却データとして追加
				response = user;
				break;
			}
			
		} catch (Exception e) {
			System.out.println("エラーが発生しました。" + e.getMessage());
		}
		return response;
	}

	/**
	 * 新規ユーザー追加処理
	 * @param userInfo
	 */
	public void regNewUser(UserInfo userInfo) {

		try {
			// SQL作成
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ");
			sb.append(" userinfo ( ");
			sb.append("    user_name, ");
			sb.append("    email, ");
			sb.append("    password ");
			sb.append(" ) ");
			sb.append("VALUES (?, ?, ?)");
			
			System.out.println(sb.toString());
			System.out.println("パラメータ：" + userInfo.Email + "," + userInfo.Password);
			
			// SQL発行と結果マッピング
			var response = jdbcTemplate.update(sb.toString(), userInfo.UserName, userInfo.Email, userInfo.Password);
			System.out.println(response);

		} catch (Exception e) {
			System.out.println("エラーが発生しました。" + e.getMessage());
		}

	}

}
