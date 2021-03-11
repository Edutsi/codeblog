package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

///CONTROLLER VAI receber as requisições dos clientes
@Controller
public class CodeblogController {

	@Autowired
	CodeblogService codeblogService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET) // mapeando a URL que o cliente vai acessar
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);// o div class card do posts.hmtl busca este obj th:each
		return mv;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET) // mapeando a URL que o cliente vai acessar
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.findByid(id);
		mv.addObject("post", post);// o div class card do posts.hmtl busca este obj th:each
		return mv;
	}

	/// metodo para criar um novo post e redirecionar para o formulário postform
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	// @valid vai fazer as validacoes do post como a @Blank
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		codeblogService.save(post);
		return "redirect:/posts";
	}

	/*
	 * @DeleteMapping("/deletarpost") public void delete(@PathVariable("id") long
	 * id) { //Long postId = Long.parseLong (id); codeblogService.deleteById(id);
	 * 
	 * }
	 */
	@GetMapping("/alterarPost/{id}")
	public ModelAndView alterarPost(@PathVariable("id") Long id) {

		ModelAndView mv = new ModelAndView();
		//mv.setViewName(getPostForm());
		//Post post = codeblogService.findByid(id);
		mv.setViewName("alterarPost");//requisita a pagina alterarPost.html
		Post post = codeblogService.findByid(id);
		mv.addObject("post", post);
		post.setData(LocalDate.now());
		/// 9:25min da aula #13 Curso Spring Boot: Método Editar e Excluir Aluno
		return mv;

	}

	@PostMapping("/alterarPost/{id}")
	// conceito de sobrescrita do metodo alterar
	public ModelAndView alterarPost(Post post) {

		ModelAndView mv = new ModelAndView();
		codeblogService.save(post);
		mv.setViewName("redirect:/posts");
		post.setData(LocalDate.now());
		/// 9:25min da aula #13 Curso Spring Boot: Método Editar e Excluir Aluno
		return mv;

	}

	@GetMapping("/excluir/{id}")
	public String deletePost(@PathVariable("id") Long id) {

		codeblogService.deleteById(id);

		return "redirect:/posts";

	}

}
