package com.d3d4project.hogwarts.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HogwartsControllerAdvice
{
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e)
	{
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("name", e.getClass().getSimpleName());
		modelAndView.addObject("message", e.getMessage());
		
		return modelAndView;
	}
}
