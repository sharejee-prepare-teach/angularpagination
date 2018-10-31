package org.baeldung.web.service.test;

import org.baeldung.web.dao.TestStudentRepository;
import org.baeldung.web.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by DELL on 10/31/2018.
 */
@Service
@Transactional
public class TestStudentServiceImpl implements TestStudentService {
    @Autowired
    private TestStudentRepository testStudentRepository;

    @Override
    public Page<Student> findPaginated(int page, int size) {
        return testStudentRepository.findAll(new PageRequest(page,size));
    }
}
