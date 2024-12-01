package com.example.devguild_sv.mapper;
import org.springframework.jdbc.core.RowMapper;

import com.example.devguild_sv.entity.ProjectInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * プロジェクト情報用SQL結果取得
 */
public class ProjectRowMapper implements RowMapper<ProjectInfo> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ProjectInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectInfo project = new ProjectInfo();
        project.setProjectId(rs.getLong("project_id"));          // プロジェクトID
        project.setProjectName(rs.getString("project_name"));    // プロジェクト名
        project.setRecruiteNumber(rs.getInt("recruite_number")); // 募集人数
        project.setDueDate(rs.getDate("duedate").toLocalDate()); // 期限日
        project.setDescription(rs.getString("description"));     // 必要事項

        // JSON型をList<String>に変換
        String requirementsJson = rs.getString("requirements");
        try {
            List<String> requirements = objectMapper.readValue(requirementsJson, List.class);
            project.setRequirements(requirements);
        } catch (Exception e) {
            throw new SQLException("JSONのパースに失敗しました: " + requirementsJson, e);
        }

        return project;
    }
}
