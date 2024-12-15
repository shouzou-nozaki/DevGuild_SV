package com.example.devguild_sv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.entity.ProjectInfo;

@Service
public class ProjectInfoService {
	@Autowired
	private ProjectInfoDAO projectInfoDAO;
	
	/**
	 * プロジェクト取得処理
	 * @return 全プロジェクト情報
	 */
	public List<ProjectInfo> getProject(){
		return projectInfoDAO.selectAllProject();
	}
	
	/**
	 * プロジェクト検索処理
	 * @param cond 検索条件
	 * @return プロジェクトリスト
	 */
	public List<ProjectInfo> getProject(Map<String, Object> cond) {
		return projectInfoDAO.selectAllProjectByUserId(cond);
	}
	
	/**
	 * プロジェクト登録処理
	 */
	public void regProject(ProjectInfo projectInfo) {
		projectInfoDAO.insertProject(projectInfo);
	}
	
	/**
	 * プロジェクト更新処理
	 * @param param
	 */
	public void updateProject(ProjectInfo projectInfo) {
		projectInfoDAO.updateProject(projectInfo);
	}
	
	/**
	 * プロジェクト更新処理
	 * @param projectId
	 */
	public void deleteProject(String projectId) {
		projectInfoDAO.deleteProject(projectId);
	}

}
