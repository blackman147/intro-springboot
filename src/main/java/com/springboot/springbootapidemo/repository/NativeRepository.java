package com.springboot.springbootapidemo.repository;

import com.springboot.springbootapidemo.data.Native;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NativeRepository extends JpaRepository <Native, String> {

    Native findByEmail(String Email);
List<Native> findNativeByCohort(String cohort);

}
