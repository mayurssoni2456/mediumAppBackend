package com.ms.mediumblog.mediumapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.mediumblog.mediumapis.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
