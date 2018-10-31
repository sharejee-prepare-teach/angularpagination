package org.baeldung.web.dao;

import org.baeldung.web.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 10/31/2018.
 */
public interface TestStudentRepository extends JpaRepository<Student,Long> {
}
