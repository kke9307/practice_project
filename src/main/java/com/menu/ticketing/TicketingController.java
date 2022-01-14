package com.menu.ticketing;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketingController {

	private static final Logger logger = LoggerFactory.getLogger(TicketingController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	
	@RequestMapping(value = "/ticket/search", method = RequestMethod.GET)
	public String search(Model model) throws Exception {
		String URL = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=01&amp;theatercode=0013&amp;date=20210713";
		
		/*		try {
					Desktop.getDesktop().browse(new URI("http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=01&amp;theatercode=0013&amp;date=20210713"));
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		try {
			ArrayList<String> movie = new ArrayList<String>(); 
			Document doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("div[class=\"col-times\"]");
			for(Element element: elem) {
				if(element.hasText()) {
					movie.add( element.text());
				}
			 }
			model.addAttribute("movieList", movie);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ticketing/search";
	}
	
	@RequestMapping(value = "/ticket/list", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) throws Exception {
		String val = ServletRequestUtils.getStringParameter(request, "searchVal");
		String URL = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=01&theatercode=0013&date="+val;
		
		try {														
			Desktop.getDesktop().browse(new URI("http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=01&theatercode=0013&date="+val));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> movie = new ArrayList<String>(); 
			ArrayList<String[]> movieList = new ArrayList<String[]>(); 
			Document doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("div[class=\"col-times\"]");
			for(Element element: elem) {
				if(element.hasText()) {
					movie.add( element.text());
				}
			 }
			for(int i = 0 ; i < movie.size(); i ++) {
				String[] movieListTmp = movie.get(i).split("/");
				movieList.add(movieListTmp);
			}
			model.addAttribute("searchDate", val);
			model.addAttribute("movieList", movieList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ticketing/list";
	}
	
	
}
