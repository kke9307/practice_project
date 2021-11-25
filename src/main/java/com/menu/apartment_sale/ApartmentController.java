package com.menu.apartment_sale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.util.DataUtils;

@Controller
public class ApartmentController {
	
	@RequestMapping(value = "/apartment/trading" , method = RequestMethod.GET)
	public String apartment_trading(HttpServletRequest request, Model model) throws Exception{
    StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=SDjGa32JnwdtPGetOx2JNBCSn6bnSOc9Z3jTlTt4rHgYOhW9ACwSs%2By%2FV1a%2Bs5Ew0T0OAbgv%2FI18igjfdGQnzQ%3D%3D"); /*Service Key*/
//    urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SDjGa32JnwdtPGetOx2JNBCSn6bnSOc9Z3jTlTt4rHgYOhW9ACwSs+y/V1a+s5Ew0T0OAbgv/I18igjfdGQnzQ==", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
    urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("41173", "UTF-8")); /*지역코드*/
    urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202110", "UTF-8")); /*계약월*/
    String url= String.valueOf(urlBuilder);
    String data = DataUtils.getHttp(url, false);
    
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.parse(new InputSource(new StringReader(data)));
	NodeList list = doc.getElementsByTagName("items");
	List<HashMap<String,String>> itemList = new ArrayList<>();
	Node family = list.item(0);
	NodeList cList = family.getChildNodes();
	for(int i=0 ; i<cList.getLength() ; i++) {
		Node firstChild = cList.item(i);
		NodeList fcList = firstChild.getChildNodes();

		HashMap<String,String> hs = new HashMap<String, String>();
		for(int k = 0 ; k < fcList.getLength() ; k++) {
			Node secondChild = fcList.item(k);
			NodeList scList = secondChild.getChildNodes();
			hs.put(fcList.item(k).getNodeName(), scList.item(0).getNodeValue());
		}
		itemList.add(hs);
	}
	
    model.addAttribute("trading", itemList);
    return "/apartment/trading";
	}
	
	
	@RequestMapping(value = "/apartment/rent" , method = RequestMethod.GET)
	public String apartment_rent(HttpServletRequest request, Model model) throws Exception{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=SDjGa32JnwdtPGetOx2JNBCSn6bnSOc9Z3jTlTt4rHgYOhW9ACwSs%2By%2FV1a%2Bs5Ew0T0OAbgv%2FI18igjfdGQnzQ%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode("41173", "UTF-8")); /*지역코드*/
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202110", "UTF-8")); /*계약월*/
	    String url= String.valueOf(urlBuilder);
	    String data = DataUtils.getHttp(url, false);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(data)));
		NodeList list = doc.getElementsByTagName("items");
		List<HashMap<String,String>> itemList = new ArrayList<>();
		Node family = list.item(0);
		NodeList cList = family.getChildNodes();
		for(int i=0 ; i<cList.getLength() ; i++) {
			Node firstChild = cList.item(i);
			NodeList fcList = firstChild.getChildNodes();

			HashMap<String,String> hs = new HashMap<String, String>();
			for(int k = 0 ; k < fcList.getLength() ; k++) {
				Node secondChild = fcList.item(k);
				NodeList scList = secondChild.getChildNodes();
				hs.put(fcList.item(k).getNodeName(), scList.item(0).getNodeValue());
			}
			itemList.add(hs);
		}
		
		model.addAttribute("rent", itemList);
		return "/apartment/rent";
	}
}