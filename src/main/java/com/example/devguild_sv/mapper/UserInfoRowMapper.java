package com.example.devguild_sv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.example.devguild_sv.dto.UserInfoDTO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.entity.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ユーザー情報用マッパー
 */
public class UserInfoRowMapper implements RowMapper<UserInfoDTO> {
	 private final ObjectMapper objectMapper = new ObjectMapper();

	    @Override
	    public UserInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	// 戻り値
	    	UserInfoDTO dto = null;
	        
	    	try {
	        	// SQL結果からの値取得
	        	var userID = rs.getInt("user_id");   // ユーザーID
	        	var userName = rs.getString("user_name").toString(); // ユーザー名
	        	
	        	dto = new UserInfoDTO(userID, userName);
	            
	        } catch (Exception e) {
	        	System.out.println("エラーが発生しました。" + e);
	        }

	        return dto;
	    }
}
