package com.unipay.dsf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unipay.dsf.service.MobileLocationService;

@Controller
@RequestMapping("/mobile")
public class MobileLocalRestController {
	@Autowired
	MobileLocationService mobileLocationService;
	
	
	@RequestMapping(value="/mobileLocal/{mobileNo}", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String checkMobileLocal(HttpServletRequest httpRequest, HttpServletResponse response,@PathVariable("mobileNo") String mobileNo){
		//JSONObject result = new JSONObject();
		String result = mobileLocationService.checkMobileLocal(mobileNo, genReqSeq("999999"), "000001");
		System.out.println(result);
		
		return result;
	}

	/**生成流水
	 * @param appID
	 * @return
	 */
	public String genReqSeq(String appID){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = sdf.format(new Date());
		return time + (new Random().nextInt(99) + 10)+appID;
	}
}
