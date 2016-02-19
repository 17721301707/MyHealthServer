package com.alvin.myhealth.heart.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alvin.myhealth.core.model.ResultModel;
import com.alvin.myhealth.heart.model.HeartBeat;
import com.alvin.myhealth.heart.service.HeartBeatService;

@Controller
@RequestMapping(value = "/heart")
public class HeartBeatController {
	@Resource(name = "HeartBeatService")
	private HeartBeatService service;

	@RequestMapping(value = "/beat")
	public @ResponseBody ResultModel verifyPhone(
			@RequestBody List<HeartBeat> datas) {
		System.out.println("/heart/beat");
		ResultModel resultModel = new ResultModel();
		if (datas != null && datas.size() > 0) {
			for (int i = 0; i < datas.size(); i++) {
				try {
					service.insertBeat(datas.get(i));
				} catch (Exception e) {
					resultModel.setFlag(false);
					resultModel.setContent("数据插入失败");
					e.printStackTrace();
					break;
				}
			}
			resultModel.setFlag(true);
			resultModel.setContent("数据写入成功");
		} else {
			resultModel.setFlag(false);
			resultModel.setContent("没有接收到数据");
			System.out.println("no datas");
		}

		return resultModel;
	}
}
