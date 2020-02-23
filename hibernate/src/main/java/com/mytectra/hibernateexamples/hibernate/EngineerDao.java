package com.mytectra.hibernateexamples.hibernate;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerDao extends PagingAndSortingRepository<Engineer, Integer>{
	
	public Page<Engineer> findEnggByName(String name , Pageable page);

}
