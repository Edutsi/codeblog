package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;
///CONTROLLER VAI receber as requisições dos clientes
@Controller
public class CodeblogController {

	
	@Autowired
	CodeblogService codeblogService;
	
	@RequestMapping(value="/posts", method = RequestMethod.GET)//mapeando a URL que o cliente vai acessar
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
}
