package com.menu.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.util.DataUtils;
import com.util.JsonUtils;

import jdk.nashorn.internal.parser.JSONParser;

@Controller
public class ExchangeController {
	protected org.slf4j.Logger logger = LoggerFactory.getLogger(ExchangeController.class);	
	
	@RequestMapping(value = {"/exchange"} , method = RequestMethod.GET)
	public String api(HttpServletRequest request, Model model) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> input = new HashMap<String, Object>();
		String api_url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=RcWai80HVNmVPXkCSjfPLzSK6cBivhtI&data=AP01&searchdate=";
		
		//현재날짜
		LocalDate now = LocalDate.now();
		//포맷정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		//포맷적용
		String searchdate = now.format(formatter);
		
		try {
				JsonUtils jsonUtil = new JsonUtils();
				JSONArray getAttendees = DataUtils.getHttpData(api_url+searchdate, false);
				result = jsonUtil.getListMapFromJsonArray(getAttendees);
				for(int i = 0 ; i < result.size(); i++) {
					result.get(i);
					System.out.println(result.get(i));
				}
				model.addAttribute("data", result);
		} catch (Exception e) {
			model.addAttribute("result", "fail");
			model.addAttribute("msg","api 연동 실패");
		}
		return "exchange/today";
		
	}
	
	/**
	 * API연동
	 * 
	 * @param session
	 * @param param
	 * @return
	 */
	@RequestMapping(value = {"/exchange/listCall"} , method = RequestMethod.POST)
	public Map<String,Object> exchangeCall(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> input = new HashMap<String, Object>();
		String api_url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=RcWai80HVNmVPXkCSjfPLzSK6cBivhtI&data=AP01&searchdate=";
		
		//현재날짜
		LocalDate now = LocalDate.now();
		//포맷정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		//포맷적용
		String searchdate = now.format(formatter);
		
		try {
				JsonUtils jsonUtil = new JsonUtils();
				JSONArray getAttendees = DataUtils.getHttpData(api_url+searchdate, false);
				result = jsonUtil.getListMapFromJsonArray(getAttendees);
				for(int i = 0 ; i < result.size(); i++) {
					
					result.get(i);
				}
				input.put("result", "success");
				input.put("data", result);
		} catch (Exception e) {
			input.put("result", "fail");
			input.put("msg","api 연동 실패");
		}
		return input;
	}
}
