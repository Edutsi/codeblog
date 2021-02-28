package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.Post;
///AQUI É ONDE SÃO DEFINIDOS OS METODOS E CRIAREMOS UM SERVICE IMPLEMENT para implementar os metodos
public interface CodeblogService {

	List<Post>findAll();
	Post findByid(long id);
	Post save(Post post);
	
}
