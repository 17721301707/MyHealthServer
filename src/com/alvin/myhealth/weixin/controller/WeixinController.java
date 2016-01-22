package com.alvin.myhealth.weixin.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alvin.myhealth.core.util.WeixinUtil;
import com.alvin.myhealth.weixin.model.Message;
import com.alvin.myhealth.weixin.model.Reply;
import com.alvin.myhealth.weixin.service.WeixinService;
@Controller()
public class WeixinController {
	private static final String TOKEN = "alvin";
	@Resource(name = "weixinService")
	private WeixinService weixinService;

	// 接收微信公众号接收的消息，处理后再做相应的回复
	@RequestMapping(value = "/weixin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String replyMessage(HttpServletRequest request) {
		System.out.println("weixin message get");
		// 仅处理微信服务端发的请求
		if (checkWeixinReques(request)) {
			Map<String, String> requestMap = WeixinUtil.parseXml(request);
			Message message = WeixinUtil.mapToMessage(requestMap);
			try {
				weixinService.addMessage(message);// 保存接受消息到数据库
				System.out.println("message add success");
				//拼装回复消息
				Reply reply = new Reply();
				reply.setToUserName(message.getFromUserName());
				reply.setFromUserName(message.getToUserName());
				reply.setCreateTime(new Date());
				reply.setMsgType(Reply.TEXT);
				reply.setContent("OK,消息已保存，我会告诉我姨的，祝你好运！");
				//将回复消息序列化为xml形式
				String back = WeixinUtil.replyToXml(reply);
				System.out.println(back);
				return back;
			} catch (Exception e) {
				System.out.println("message add fail");
				e.printStackTrace();
				return "error";
			}
		}else{
			return "error";
		}
	}
	
	//微信公众平台验证url是否有效使用的接口
	@RequestMapping(value="/weixin",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String initWeixinURL(HttpServletRequest request){
		System.out.println("weixin url check");
		String echostr = request.getParameter("echostr");
		if (checkWeixinReques(request) && echostr != null) {
			System.out.println("check success!"+echostr);
			return echostr;
		}else{
			System.out.println("check Fail!");
			return "error";
		}
	}

	/**
	 * 根据token计算signature验证是否为weixin服务端发送的消息
	 */
	private static boolean checkWeixinReques(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature != null && timestamp != null && nonce != null) {
			String[] strSet = new String[] { TOKEN, timestamp, nonce };
			java.util.Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = WeixinUtil.sha1(key);
			return pwd.equals(signature);
		} else {
			return false;
		}
	}
}
