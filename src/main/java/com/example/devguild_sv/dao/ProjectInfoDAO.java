package com.example.devguild_sv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.devguild_sv.dto.UserInfoDTO;
import com.example.devguild_sv.entity.ProjectInfo;
import com.example.devguild_sv.mapper.ProjectRowMapper;
import com.example.devguild_sv.mapper.UserInfoRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Repository
public class ProjectInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 全プロジェクト情報取得
	 * @return プロジェクト情報リスト
	 */
	public List<ProjectInfo> selectAllProject() {
		// SQL作成
        String sql = "SELECT "
                   + " project_id, "
                   + " project_name, "
                   + " recruite_number, "
                   + " duedate, "
                   + " description, "
                   + " requirements "
                   + "FROM projectinfo";

        // SQL発行と結果マッピング
        return jdbcTemplate.query(sql,new ProjectRowMapper());
	}
	
	/**
	 * プロジェクト取得処理
	 * @param cond 検索条件
	 * @return プロジェクト情報
	 */
	public List<ProjectInfo> selectAllProject(Map<String, Object> cond) {
		// 戻り値
		List<ProjectInfo> response = new ArrayList<ProjectInfo>();
		
		try {
			// SQL作成
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("    project_id, ");
			sb.append("    project_name, ");
			sb.append("    recruite_number, ");
			sb.append("    duedate, ");
			sb.append("    duedate, ");
			sb.append("    description, ");
			sb.append("    requirements ");
			sb.append("FROM projectinfo ");
			sb.append("WHERE ");
			sb.append("    create_user = ? ");
			
			// パラメータ取得
			String param1 = (String) cond.get("UserId"); // ユーザーID
			
			System.out.println(sb.toString());
			System.out.println(param1);
			
			// SQL発行と結果マッピング
			response =  jdbcTemplate.query(sb.toString(), new ProjectRowMapper(), param1);
			
			
		} catch (Exception e) {
			System.out.println("エラーが発生しました。" + e.getMessage());
		}
		return response;
	}

	/**
	 * プロジェクト情報の保存
	 * @param projectInfo 保存プロジェクト情報
	 */
	public void insertProject(ProjectInfo projectInfo) {
		// SQL作成
		String sql = "INSERT INTO projectinfo " 
				+ " ( " 
				+ " project_name, " 
				+ " recruite_number, " 
				+ " duedate, "
				+ " description, " 
				+ " requirements " 
				+ " ) " 
				+ " VALUES (?, ?, ?, ?, CAST(? AS JSON))";

		// SQL発行
		jdbcTemplate.update(sql, 
				projectInfo.getProjectName(),         // プロジェクト名
				projectInfo.getRecruiteNumber(),      // 募集人数
				projectInfo.getDueDate(),             // 期限日
				projectInfo.getDescription(),         // 説明
				toJson(projectInfo.getRequirements()) // 求めるスキル
		);
	}

	/**
	 * JSON型への変換処理
	 * 
	 * @param list 求めるスキル(文字列配列)
	 * @return 求めるスキル(JSON型)
	 */
	private String toJson(List<String> list) {
		try {
			var mapper = new ObjectMapper();
			return mapper.writeValueAsString(list);
		} catch (Exception e) {
			throw new RuntimeException("リストをJSONに変換できません", e);
		}
	}
}
