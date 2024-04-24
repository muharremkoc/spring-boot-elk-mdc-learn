package com.spring.dummyservice.repository;

import com.spring.dummyservice.domain.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DummyRepository extends JpaRepository<Dummy,Integer> {

   Dummy findByUserId(int userId);
}
