package com.example.devguild_sv.mapper;
import org.springframework.jdbc.core.RowMapper;

import com.example.devguild_sv.entity.ProjectInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * プロジェクト情報用SQL結果取得
 */
public class ProjectInfoMapper implements RowMapper<ProjectInfo> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ProjectInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setProjectId(rs.getLong("project_id"));             // プロジェクトID
        projectInfo.setProjectName(rs.getString("project_name"));       // プロジェクト名
        projectInfo.setRecruiteNumber(rs.getString("recruite_number")); // 募集人数
        projectInfo.setDueDate(rs.getString("duedate"));                // 期限日
        projectInfo.setDescription(rs.getString("description"));        // 必要事項

        // JSON型をArrayList<String>に変換
        String requirementsJson = rs.getString("requirements");
        try {
            ArrayList<String> requirementsToArray = objectMapper.readValue(requirementsJson, ArrayList.class);
            projectInfo.setRequirements(requirementsToArray);
        } catch (Exception e) {
            throw new SQLException("リスト変換に失敗しました: " + requirementsJson, e);
        }

        return projectInfo;
    }
}
