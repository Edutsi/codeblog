package com.spring.codeblog.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.CodeblogService;

@Service//estereotipe do Spring que está classe será gerenciada por ele
public class CodeblogServiceImpl implements CodeblogService {

	@Autowired // ponto de injeção
	CodeblogRepository codeblogRepoitory;

	@Override // indica obrigação de implementar o metodo
	/// Os metodos já estão prontos no JPARepository - ssó iremos chama-los
	public List<Post> findAll() {

		return codeblogRepoitory.findAll();
	}

	@Override
	public Post findByid(long id) {

		return codeblogRepoitory.findById(id).get();
	}

	@Override
	public Post save(Post post) {

		return codeblogRepoitory.save(post);
	}

}
