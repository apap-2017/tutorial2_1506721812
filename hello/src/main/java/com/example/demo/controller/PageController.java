package com.example.demo.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index(){
		return "hello";
	}

	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false, 
	defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String multiplication(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b",
	required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("number1", a);
		model.addAttribute("number2", b);
		
		int result = a * b;
		model.addAttribute("number3", result);
		
		return "multiplication";
	}
}
	

/**LATIHAN
1. Tidak terjadi compile error. Apabila @requestmapping diganti menjadi hello123, maka pada 
laman localhost:8080/hello akan menampilkan error karena tidak memanggil
 apapun di pagecontroller.java, jadi harusnya localhost:8080/hello123. 

2. Tidak terjadi compile error. karena yang localhost:8080/hello 
awalnya udah sama. abis itu dia masuk ke method hello(). karena di method hello() itu
return "hello" yang merefer ke hello.html maka dia jalan. 

3. - Error resolving template "hello123", template might not exist or might not 
be accessible by any of the configured Template Resolvers
 - 
**/