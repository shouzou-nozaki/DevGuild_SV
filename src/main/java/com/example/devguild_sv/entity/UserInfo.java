package com.example.devguild_sv.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {
	// ユーザーID
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	
	// ユーザー名
	@Column(name = "user_name", nullable = false)
	public String UserName;

	// メールアドレス
	@Column(name = "email", nullable = false)
	public String Email;
	
	// パスワード
	@Column(name = "password", nullable = false)
	public String Password;
	
//	
//    // ユーザーID
//    public Long getUserId() {
//        return UserId;
//    }
//    // ユーザーID
//    public void setUserId(Long userId) {
//        this.UserId = userId;
//    }
//    
//    // ユーザー名
//    public String getUserName() {
//        return UserName;
//    }
//    // ユーザー名
//    public void setUserName(String userName) {
//        this.UserName = userName;
//    }
//    
//    // メールアドレス
//    public String getEmail() {
//        return Email;
//    }
//    // メールアドレス
//    public void setEmail(String email) {
//        this.Email = email;
//    }
//    
//    // パスワード
//    public String getPassword() {
//        return Password;
//    }
//    // パスワード
//    public void setPassword(String password) {
//        this.Password = password;
//    }
    
}
