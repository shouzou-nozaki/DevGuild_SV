package com.example.devguild_sv.repository;

import com.example.devguild_sv.model.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectInfo, Long> {
}