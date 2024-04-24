package com.example.demo.Repository;

import com.example.demo.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {}
