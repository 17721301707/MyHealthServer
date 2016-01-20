package com.alvin.myhealth.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alvin.myhealth.core.model.ResultModel;
import com.alvin.myhealth.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource(name="UserService")
	private UserService service;
	
	@RequestMapping(value = "/isExistUserName")
	public @ResponseBody ResultModel isExistUserInfoByUserName(@RequestBody String userName){
		ResultModel result = service.isExistUserInfoByUserName(userName);
		if (result.getFlag()) {
			System.out.println("YES " + result.getContent());
		} else {
			System.out.println("NO " + result.getContent());
		}
		return result;
	}
	
	@RequestMapping(value ="/login" ,method = RequestMethod.POST)
    public ModelAndView checkSignature(String phone, HttpServletResponse response) throws Exception {
        System.out.println("Input:"+phone);
        ResultModel result = service.isExistUserInfoByUserName(phone);
		if (result.getFlag()) {
			System.out.println("YES " + result.getContent());
		} else {
			System.out.println("NO " + result.getContent());
		}
		ModelAndView mv=new ModelAndView("");
		mv.setViewName("redirect:/jump.jsp");
		return mv;
    }
}
