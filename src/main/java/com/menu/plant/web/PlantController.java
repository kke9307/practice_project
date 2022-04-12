package com.menu.plant.web;

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
import org.json.simple.parser.JSONParser;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.menu.plant.model.PlantVo;
import com.util.DataUtils;
import com.util.JsonUtils;


@Controller
public class PlantController {
	protected org.slf4j.Logger logger = LoggerFactory.getLogger(PlantController.class);	
	
	
	
	@RequestMapping(value = {"/plant"} , method = RequestMethod.GET)
	public String api(HttpServletRequest request, Model model , PlantVo plantVo) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> input = new HashMap<String, Object>();
		int firstIndex = 1;
		int lastIndex = 10;
		String api_url = "https://api.odcloud.kr/api/15077852/v1/uddi:2b0d4f52-3009-44f2-9ea5-ed827d8ad217?page="+firstIndex+"&perPage="+lastIndex+"&serviceKey=SDjGa32JnwdtPGetOx2JNBCSn6bnSOc9Z3jTlTt4rHgYOhW9ACwSs%2By%2FV1a%2Bs5Ew0T0OAbgv%2FI18igjfdGQnzQ%3D%3D";
		
		try {
				JsonUtils jsonUtil = new JsonUtils();
				JSONObject plant = DataUtils.getHttpJson(api_url);
				JSONParser jp = new JSONParser();
				input = jsonUtil.getMapFromJsonObject(plant);
				List<Map<String, Object>> map = (List<Map<String, Object>>) input.get("data");
				HashMap<String,Object> plant_col = new HashMap<>();
				plant_col.putAll(map.get(0));
				plantVo.set적재년월일(String.valueOf(plant_col.get("적재년월일")));
				System.out.println(plantVo.get적재년월일());
				model.addAttribute("data", map);
		} catch (Exception e) {
			model.addAttribute("result", "fail");
			model.addAttribute("msg","api 연동 실패");
		}
		return "plant/plant_home";
		
	}
	
	/**
	 * API연동
	 * 
	 * @param session
	 * @param param
	 * @return
	 */
	@RequestMapping(value = {"/plant/listCall"} , method = RequestMethod.POST)
	public Map<String,Object> plantCall(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> input = new HashMap<String, Object>();
		String api_url = "https://api.odcloud.kr/api/15077852/v1/uddi:2b0d4f52-3009-44f2-9ea5-ed827d8ad217?page=1&perPage=100&serviceKey=SDjGa32JnwdtPGetOx2JNBCSn6bnSOc9Z3jTlTt4rHgYOhW9ACwSs%2By%2FV1a%2Bs5Ew0T0OAbgv%2FI18igjfdGQnzQ%3D%3D";
		
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
