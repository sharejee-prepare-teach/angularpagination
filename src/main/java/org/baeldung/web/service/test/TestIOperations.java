package org.baeldung.web.service.test;

import org.springframework.data.domain.Page;

/**
 * Created by DELL on 10/31/2018.
 */
public interface TestIOperations<T>  {

    Page<T> findPaginated(final int page,final int size);
}
