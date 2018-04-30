package com.d3d4project.hogwarts.common.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.d3d4project.hogwarts.common.model.HogwartsResultsResponse;
import com.d3d4project.hogwarts.common.service.HogwartsService;
import com.d3d4project.hogwarts.common.service.HogwartsService.HogwartsRequest;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;
import com.d3d4project.hogwarts.tasks.model.HogwartsTask;

@Controller
@RequestMapping("/hogwarts")
@SessionAttributes("hogwartsController")
public class HogwartsController 
{	
	@Autowired
	@Qualifier("hogwartsService")
	public HogwartsService hogwartsService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String hogwartsHomePage()
	{		
		return "/home.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public HogwartsResultsResponseDTO retrieveResults(@RequestParam(required = true) final String team)
//	public HogwartsResultsResponseDTO retrieveResults()
	{
//		final String team = "Slytherin";
		final HogwartsRequest request = hogwartsService.forTeam(team);
		final HogwartsResultsResponse response = request.retrieveResults();
		
		return new HogwartsResultsResponseDTO(response);
	}
	
	@RequestMapping(value = "/saveDeveloper", method = RequestMethod.POST)
	public String saveDeveloper(@ModelAttribute("developer") HogwartsDeveloper developer, ModelMap model)
	{
		model.addAttribute("firstName", developer.getFirstName());
		model.addAttribute("lastName", developer.getLastName());
		model.addAttribute("nickname", developer.getNickname());
		model.addAttribute("primarySkill", developer.getPrimarySkill());
		model.addAttribute("level", developer.getLevel());
		
		return "hogwartsDeveloper";
	}
	
	@RequestMapping(value = "/task")
	// on some reason I can't import the annotation
//	public String task(@RequestAttribute("task") HogwartsTask task)
	public String task(HogwartsTask task)
	{
		task.setId("1");
		task.setPriority("2");
		task.setDescription("description for task 1");
		task.setEstimate("2");
		task.setSeverity("3");
		task.setType("bug");
		
		return "hogwartsTask";
	}
	
	@RequestMapping(value = "/home2.htm")
	public String helloCookie(@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,	HttpServletResponse response)
	{
		Cookie cookie = new Cookie("hitCounter", (hitCounter++).toString());
		response.addCookie(cookie);

		return "hello";
	}
	
	@RequestMapping(value = "/home3.htm")
	public String helloHeader(@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage, HttpServletResponse response)
	{
		System.out.println("accept: " + accept);
		System.out.println("acceptLanguage: " + acceptLanguage);
		
		return null;
	}
}
