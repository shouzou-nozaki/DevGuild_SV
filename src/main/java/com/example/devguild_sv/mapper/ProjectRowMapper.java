package com.example.devguild_sv.mapper;
import org.springframework.jdbc.core.RowMapper;

import com.example.devguild_sv.model.ProjectInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProjectRowMapper implements RowMapper<ProjectInfo> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ProjectInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectInfo project = new ProjectInfo();
        project.setProjectId(rs.getLong("project_id"));
        project.setProjectName(rs.getString("project_name"));
        project.setRecruiteNumber(rs.getInt("recruite_number"));
        project.setDueDate(rs.getDate("duedate").toLocalDate());
        project.setDescription(rs.getString("description"));

        // JSON文字列をList<String>に変換
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
