package com.example.devguild_sv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.devguild_sv.mapper.ProjectRowMapper;
import com.example.devguild_sv.model.ProjectInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProjectInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 全プロジェクト情報取得
	 * @return プロジェクト情報リスト
	 */
	public List<ProjectInfo> getAllProjectInfo() {
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
	 * プロジェクト情報の保存
	 * 
	 * @param projectInfo 保存プロジェクト情報
	 */
	public void saveProject(ProjectInfo projectInfo) {
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
