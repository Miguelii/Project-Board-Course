package io.exemple.projectboard.service;

import io.exemple.projectboard.domain.ProjectTask;
import io.exemple.projectboard.repository.ProjectTaskRE;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRE projectTaskRE;


    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {

        if(projectTask.getStatus() == null || projectTask.getStatus()=="") {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRE.save(projectTask);
    }

    public Iterable<ProjectTask> findAll() throws Exception {

        return projectTaskRE.findAll();

    }

    public ProjectTask findById(Long id) {
        return projectTaskRE.getById(id);
    }

    public void delete(Long id) {
        ProjectTask projectTask = findById(id);
        projectTaskRE.delete(projectTask);
    }


}
