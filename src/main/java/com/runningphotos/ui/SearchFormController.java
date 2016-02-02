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
		return searchRace(raceName.toLowerCase());
	}


	@RequestMapping(value = "/checkRaceAndNumber", method = RequestMethod.GET)
	public @ResponseBody
	String checkRaceAndNumber(@RequestParam("race") String raceName, @RequestParam("number") String number )
	{
		Race race = null;
		List<Race> raceArr = searchRace(raceName);
		if(raceArr.size() == 1){
			race = raceArr.get(0);
		}
		else {
			return "";
		}
		if(resultDao.selectResultByRaseAndNamber(race,number) != null) {
			return race.getName();
		}
		else {
			return "";
		}
	}


	private List<Race> searchRace(String raceName)
	{
		List<String> result = new ArrayList<String>();
		String raceCriteria[] = raceName.split("\\W");
		for(String criteria : raceCriteria ){
			result.add("%"+criteria+"%");
		}
		return raceDao.searchContainsName(result);
	}

}
