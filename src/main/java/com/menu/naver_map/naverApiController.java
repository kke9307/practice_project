package com.menu.naver_map;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.JsonUtils;

import net.sf.json.JSONArray;

@Controller
public class naverApiController {

	@RequestMapping(value = "/naver_map", method = RequestMethod.GET)
	public String naver_map(HttpServletRequest request, Model model) {
		return "naver/naver_map";
	}
	@RequestMapping(value = "/naver_location", method = RequestMethod.GET)
	public String naver_location(HttpServletRequest request, Model model) {
		return "naver/naver_location";
	}
	@RequestMapping(value = "/naver_location_proc", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public @ResponseBody String naver_location_proc(HttpServletRequest request, Model model,@RequestParam(value = "searchAddr") String searchAddr) {
		StringBuilder urlBuilder = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode");
		URL src;
		HttpURLConnection con = null;
		OutputStreamWriter wr = null;
		InputStream is = null;
		JSONObject location = null;
		try {
			urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=" +URLEncoder.encode(searchAddr,"UTF-8")); /*search addr*/
			urlBuilder.append("&" + URLEncoder.encode("X-NCP-APIGW-API-KEY-ID", "UTF-8") + "="	+ URLEncoder.encode("vtw8zgwrd6", "UTF-8")); /* 네이버 client key */
			urlBuilder.append("&" + URLEncoder.encode("X-NCP-APIGW-API-KEY", "UTF-8") + "=" + URLEncoder.encode("NIg6GmAPmS8QnGWCdBcwXldjNgAvQSpLcq12S9X3", "UTF-8")); /* 네이버 secret key */
			String url = String.valueOf(urlBuilder);
			boolean ispost = false;// GET
	

			src = new URL(url);
			con = (HttpURLConnection) src.openConnection();

			if (ispost) {
				con.setRequestMethod("POST");
				con.setDoInput(true);
				con.setDoOutput(true);
				// con.setUseCaches(false);
				// con.setDefaultUseCaches(false);
				// Request Body에 Data를 담기위해 OutputStream 객체를 생성.
				OutputStream os = con.getOutputStream();
				// Request Body에 Data 셋팅.
				os.flush();
				os.close();
				// wr = new OutputStreamWriter(con.getOutputStream());
				// wr.write(data);
				// wr.flush();
			} else {
				con.setRequestMethod("GET");
				con.setDoOutput(false);
			}
			if (con.getResponseCode() == con.HTTP_OK || con.getResponseCode() == con.HTTP_CREATED) {
				JSONParser parser = new JSONParser();
				location = (JSONObject) parser.parse(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				is = con.getInputStream();
				StringBuffer sb = new StringBuffer();
				byte[] b = new byte[4096];
				for (int n; (n = is.read(b)) != -1;) {
					sb.append(new String(b, 0, n));
				}
				sb.toString();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (wr != null) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				con.disconnect();
			}
		}
		JsonUtils jsonUtil = new JsonUtils();
		Map<String,Object> loadMap = new HashMap<>();
		loadMap = jsonUtil.getMapFromJsonObject(location);
		
		System.out.println("location: "+ location.get("addresses"));
		return JSONArray.fromObject(location.get("addresses")).toString();
	}
	@RequestMapping(value = "/naver_map_example", method = RequestMethod.GET)
	public String naver_map_example(HttpServletRequest request, Model model) {
		return "naver/naver_map_example";
	}
}
