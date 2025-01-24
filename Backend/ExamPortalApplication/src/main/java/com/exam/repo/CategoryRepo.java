package com.exam.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>  {

	public Optional<Category> findById(Long id);
	
}
