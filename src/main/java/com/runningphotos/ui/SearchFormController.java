package com.runningphotos.ui;

import com.runningphotos.bom.Race;
import com.runningphotos.dao.RaceDao;
import com.runningphotos.dao.ResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SearchFormController
{

	@Autowired
	ResultDao resultDao;

	@Autowired
	RaceDao raceDao;

	@RequestMapping(value = "/getRace", method = RequestMethod.GET)
	public @ResponseBody
	List<Race> getRace(@RequestParam String raceName)
	{
		return raceDao.searchContainsName("%"+raceName+"%");
	}


	@RequestMapping(value = "/checkRaceAndNumber", method = RequestMethod.GET)
	public @ResponseBody
	String checkRaceAndNumber(@RequestParam("race") String raceName, @RequestParam("number") String number )
	{
		Race race = raceDao.selectByName(raceName);
		if(resultDao.selectResultByRaceAndNumber(race,number) != null) {
			return race.getName();}
		else {
			return "";
		}
	}

}
