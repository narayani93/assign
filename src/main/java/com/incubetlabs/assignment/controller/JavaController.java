package com.incubetlabs.assignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.incubetlabs.assignment.model.Hotel;

import com.incubetlabs.assignment.operations.DBFunctions;

import java.util.List;

@Controller
public class JavaController {
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView getResultsEntry(@ModelAttribute("hotel") Hotel hotel) {
		boolean x = DBFunctions.saveToDatabase(hotel);
		String s = new String();
		if(x) {
			s = "The data was successfully recorded";
		}
		else {
			s = "There was an error";
		}
		return new ModelAndView("result", "result", s);
	}
	
	@RequestMapping(value = "/hotel-entry")
	public String goHotelEntry() {
		return "hotel-entry";
	}
	
	@RequestMapping(value = "/hotel-search")
	public ModelAndView goSearchHotel(HttpServletRequest request) {
		List<Hotel> ll = null;
		String s = request.getParameter("city");
		if(s!=null && !s.isEmpty()) {
			ll = (List<Hotel>) DBFunctions.getSearchDetails(request.getParameter("city"));
		}
		else {
			ll = DBFunctions.getSearchDetails("1");
		}
		return new ModelAndView("hotel-search", "result", ll);
	}
}
