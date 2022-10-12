package io.exemple.projectboard.repository;

import io.exemple.projectboard.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRE extends CrudRepository<ProjectTask,Long> {

    ProjectTask getById(Long id);

}
