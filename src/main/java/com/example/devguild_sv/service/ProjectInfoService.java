package com.example.devguild_sv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devguild_sv.dao.ProjectInfoDAO;
import com.example.devguild_sv.entity.ProjectInfo;

@Service
public class ProjectInfoService {
	@Autowired
	private ProjectInfoDAO projectInfoDAO;
	
	/**
	 * プロジェクトリストの取得
	 * @return 全プロジェクト情報
	 */
	public List<ProjectInfo> getProject(){
		return projectInfoDAO.selectAllProject();
	}
	
	/**
	 * プロジェクトの登録
	 */
	public void regProject(ProjectInfo projectInfo) {
		projectInfoDAO.insertProject(projectInfo);
	}
}
