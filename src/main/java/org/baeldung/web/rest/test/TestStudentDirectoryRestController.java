package org.baeldung.web.rest.test;

import org.baeldung.web.entity.Student;
import org.baeldung.web.exception.MyResourceNotFoundException;
import org.baeldung.web.service.test.TestStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DELL on 10/31/2018.
 */
@Controller
public class TestStudentDirectoryRestController {
    @Autowired
    private TestStudentService studentService;

    @RequestMapping(
            value = "/teststudent/get"
            , params = {"page", "size"}
            , method = RequestMethod.GET
            , produces = "application/json"
    )
    @ResponseBody
    public Page<Student> findPaginatedTest(
            @RequestParam("page") int page,
            @RequestParam("size") int size
            ){
        Page<Student> resultPage = studentService.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }
        return resultPage;
    }
}

