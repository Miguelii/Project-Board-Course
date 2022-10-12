package io.exemple.projectboard.web;

import io.exemple.projectboard.domain.ProjectTask;
import io.exemple.projectboard.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/board")
@RequestMapping(path = "api")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @RequestMapping(value = "", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {

        //Custom response if POST has error
        if(result.hasErrors()) {
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public Iterable<ProjectTask> getALllPT() throws Exception {

        return projectTaskService.findAll();
    }

    @GetMapping("⁄{pt_id}")
    public ResponseEntity<ProjectTask> getPTById(@PathVariable Long pt_id) {
        ProjectTask projectTask = projectTaskService.findById(pt_id);

        return new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id) {
        projectTaskService.delete(pt_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }
}
