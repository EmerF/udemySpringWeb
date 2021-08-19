package com.aula.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.model.Login;

@Repository
@Qualifier("LoginRepository")
public interface LoginRepository extends JpaRepository<Login, Long> {

}
