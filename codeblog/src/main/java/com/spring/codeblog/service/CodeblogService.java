package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.Post;

///AQUI É ONDE SÃO DEFINIDOS OS METODOS E CRIAREMOS UM SERVICE IMPLEMENT para implementar os metodos
public interface CodeblogService {

	List<Post> findAll();

	Post findByid(long id);

	Post getOne(long id);

	Post save(Post post);

	void deleteById(long id);

	/*
	 * getOne ( ID id) Retorna uma referência à entidade com o identificador
	 * fornecido. Dependendo de como o provedor de persistência JPA é implementado,
	 * é muito provável que sempre retorne uma instância e lance um
	 * EntityNotFoundExceptionno primeiro acesso. Alguns deles rejeitarão
	 * identificadores inválidos imediatamente.
	 */
}
