package com.spring.codeblog.repository;


import com.spring.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
///COM ESSA INTERFACE TEMOS ACESSO AOS METODOS PRONTOS DO SPRINGDADATA COMO O SAVE POR EXEMPLO 
public interface CodeblogRepository extends JpaRepository<Post, Long>{

	
	
}
