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
import com.alvin.myhealth.user.model.UserInfo;
import com.alvin.myhealth.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource(name="UserService")
	private UserService service;
	
	@RequestMapping(value = "/verifyPhone")
	public @ResponseBody ResultModel verifyPhone(@RequestBody String phone){
		System.out.println("infterface verifyPhone get:"+phone);
		UserInfo result = service.verifyPhone(phone);
		ResultModel resultModel = new ResultModel();
		if (result != null) {
			resultModel.setFlag(true);
			resultModel.setContent(phone + "该手机已存在");
		} else {
			resultModel.setFlag(false);
			resultModel.setContent(phone + "该手机未注册");
		}
		System.out.println(resultModel.toString());
		return resultModel;
	}
	
	@RequestMapping(value ="/test" ,method = RequestMethod.POST)
    public ModelAndView checkSignature(String phone,HttpServletResponse response) throws Exception {
        System.out.println("Input:"+phone);
        UserInfo result = service.verifyPhone(phone);
		if (result!=null) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		ModelAndView mv=new ModelAndView("");
		mv.setViewName("redirect:/jump.jsp");
		return mv;
    }
	
	@RequestMapping(value = "/login")
	public @ResponseBody UserInfo login(@RequestBody UserInfo userInfo){
		System.out.println("infterface login:"+userInfo.getPhone()+","+userInfo.getPassword());
		UserInfo result = service.selectUserInfo(userInfo);
		if(result!=null){
			System.out.println("Yes:"+result.getPhone());
		}else {
			System.out.println("No");
		}
		return result;
	}
	
	@RequestMapping(value = "/regist")
	public @ResponseBody ResultModel register(@RequestBody UserInfo userInfo){
		System.out.println("interface register:" + userInfo.getPhone() + ","
				+ userInfo.getPassword());
		ResultModel resultModel = new ResultModel();
		// 查询该手机是否注册过
		UserInfo user = service.verifyPhone(userInfo.getPhone());
		if (user != null) {
			resultModel.setFlag(false);
			resultModel.setContent("已注册");
		} else {
			try {
				service.insertUserInfo(userInfo);
				resultModel.setFlag(true);
				resultModel.setContent("成功");
			} catch (Exception e) {
				resultModel.setFlag(false);
				resultModel.setContent("失败");
				e.printStackTrace();
			}
		}
		return resultModel;
	}
}
