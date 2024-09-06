package com.projectManagementSystem.pms_company.repository;

import com.projectManagementSystem.pms_company.Entity.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Long> {
}
