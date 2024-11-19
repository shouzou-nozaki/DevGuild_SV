package com.example.devguild_sv.service;

import com.example.devguild_sv.model.ProjectInfo;
import com.example.devguild_sv.repository.ProjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	/**
	 * プロジェクト一覧取得
	 * @return
	 */
    public List<ProjectInfo> getAllProjects() {
        return projectRepository.findAll();
    }
	/**
	 * プロジェクト情報保存処理
	 * @param projectInfo
	 * @return
	 */
	public ProjectInfo saveProject(ProjectInfo projectInfo) {
		return projectRepository.save(projectInfo);
	}
}
