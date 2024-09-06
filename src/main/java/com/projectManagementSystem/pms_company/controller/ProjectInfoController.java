package com.projectManagementSystem.pms_company.controller;


import com.projectManagementSystem.pms_company.Entity.ProjectInfo;
import com.projectManagementSystem.pms_company.service.ProjectInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/projectInfo")
public class ProjectInfoController {

    private final ProjectInfoService projectInfoService;
    public ProjectInfoController(ProjectInfoService projectInfoService){
        this.projectInfoService=projectInfoService;
    }

    //saving projectInfo
    //URL: http://localhost/4040/projectInfo

    //returning projectInfo
//    @PostMapping
//    public ResponseEntity<ProjectInfo> saveProjectInfo(@RequestBody ProjectInfo projectInfo){
//        ProjectInfo newProjectInfo =projectInfoService.saveProjectInfo(projectInfo);
//        return ResponseEntity.ok(newProjectInfo);
//    }

    //returning string success message
    @PostMapping
    public ResponseEntity<String> saveProject(@RequestBody ProjectInfo projectInfo){
        return ResponseEntity.ok(this.projectInfoService.saveProjectInfo(projectInfo));
    }

//getting specific project
    //URL: http://localhost/4040/projectInfo/2
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectInfo> getProjectInfoDetails(@PathVariable("projectId") Long projectId){
        return ResponseEntity.ok(this.projectInfoService.getProjectInfo(projectId));
    }

    //Getting all project
    //URL: http://localhost/4040/projectInfo
    @GetMapping()
    public ResponseEntity<List<ProjectInfo>> getAllProjectInfoDetails(){
        return ResponseEntity.ok(projectInfoService.getAllProjectInfo());
    }

    //deleting project
    //URL: http://localhost/4040/projectInfo/{3}
    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable("projectId") Long projectId){
        String result = projectInfoService.deleteProjectInfo(projectId);
        return ResponseEntity.ok(result);
    }

    //Full project info update (@PutMapping)
    //URL: http://localhost/4040/projectInfo/{}

    @PutMapping("/{projectId}")
    public ResponseEntity<String> updateFullProject(@PathVariable ("projectId")Long projectId, @RequestBody ProjectInfo projectInfo){
        return ResponseEntity.ok(projectInfoService.updateFullProjectInfo(projectId,projectInfo));
    }

    //patching project info (@PatchMapping)
    //URL: http://localhost/4040/projectInfo/{}
    @PatchMapping("/{projectId}")
    public ResponseEntity<String> updateProject(@PathVariable("projectId") Long projectId, @RequestBody ProjectInfo projectInfo ){
        return ResponseEntity.ok(projectInfoService.updateProjectInfo(projectId, projectInfo));
    }

}
