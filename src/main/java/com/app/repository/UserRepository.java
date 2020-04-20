package com.app.repository;

import java.util.List;

import com.app.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByOrderByLastNameAscFirstNameAsc();

}
