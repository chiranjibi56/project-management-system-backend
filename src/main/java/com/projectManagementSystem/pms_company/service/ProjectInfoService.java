package com.projectManagementSystem.pms_company.service;


import com.projectManagementSystem.pms_company.Entity.ProjectInfo;
import com.projectManagementSystem.pms_company.Entity.User1;
import com.projectManagementSystem.pms_company.repository.ProjectInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectInfoService {

    private final ProjectInfoRepository projectInfoRepository;

    public ProjectInfoService(ProjectInfoRepository projectInfoRepository) {
        this.projectInfoRepository = projectInfoRepository;
    }

    //Saving project and returning project
//    public ProjectInfo saveProjectInfo(ProjectInfo projectInfo){
//        return projectInfoRepository.save(projectInfo);
//    }

    //saving project and returning success message
    public String saveProjectInfo(ProjectInfo projectInfo){
        ProjectInfo saveNewProjectInfo = this.projectInfoRepository.save(projectInfo);
        if(saveNewProjectInfo !=null){
            return "success";
        }else {
            return "failed";
        }
    }


    //Getting project info
    public ProjectInfo getProjectInfo(Long projectId){
        return projectInfoRepository.findById(projectId).get();
    }

    //Getting all project info
    public List<ProjectInfo> getAllProjectInfo(){
        List<ProjectInfo> allProjectInfo=projectInfoRepository.findAll();
        return allProjectInfo;
    }

    //Delete project info
    public String deleteProjectInfo(Long projectId){
        Optional<ProjectInfo> projectInfoOptional = projectInfoRepository.findById(projectId);
        if (projectInfoOptional.isPresent()){
            projectInfoRepository.deleteById(projectId);
            return "success";
        }
        return "failed";
    }

    //full update project
    public String updateFullProjectInfo(Long projectId, ProjectInfo projectInfo) {
        Optional<ProjectInfo> optionalProjectInfo= projectInfoRepository.findById(projectId);
        if (optionalProjectInfo.isPresent()){
            ProjectInfo existingProject = optionalProjectInfo.get();
            if(projectInfo.getProjectName() != null){
                existingProject.setProjectName(projectInfo.getProjectName());
                existingProject.setProjectBudget(projectInfo.getProjectBudget());
                existingProject.setProjectManager(projectInfo.getProjectManager());
                existingProject.setStartDate(projectInfo.getStartDate());
                existingProject.setEndDate(projectInfo.getEndDate());
                existingProject.setProjectStatus(projectInfo.getProjectStatus());
                projectInfoRepository.save(existingProject);
                return "Project id number "+projectId+ " is updated";
            }
        }
        return "Project id number "+projectId+ " is not found";
    }

    public String updateProjectInfo(Long projectid, ProjectInfo projectInfo){
        Optional<ProjectInfo> projectInfoOptional=projectInfoRepository.findById(projectid);

        if(projectInfoOptional.isPresent()){
            ProjectInfo existingProject = projectInfoOptional.get();

            if(projectInfo.getProjectName() != null){
                existingProject.setProjectName(projectInfo.getProjectName());
            }
            if(projectInfo.getProjectStatus() != null){
                existingProject.setProjectStatus(projectInfo.getProjectStatus());
            }
            if(projectInfo.getProjectBudget() != null){
                existingProject.setProjectBudget(projectInfo.getProjectBudget());
            }
            if(projectInfo.getStartDate() != null){
                existingProject.setStartDate(projectInfo.getStartDate());
            }
            if(projectInfo.getEndDate() != null){
                existingProject.setEndDate(projectInfo.getEndDate());
            }
            projectInfoRepository.save(existingProject);
            return "Project Id number "+projectid+ " updated successfully";

        }
        return "Project Id number "+projectid +" is not found";
    }
}
