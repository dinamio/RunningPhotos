package com.runningphotos.service;

import com.runningphotos.bom.Distance;
import com.runningphotos.bom.Result;
import com.runningphotos.bom.Runner;
import com.runningphotos.bom.Time;
import com.runningphotos.dao.ResultDao;
import com.runningphotos.dao.RunnerDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ������� on 27.12.2015.
 */

@Component
public class TopRunnersParser {
    private static Log log = LogFactory.getLog(TopRunnersParser.class);

    @Autowired
    RunnerDao runnerDao;
    @Autowired
    ResultDao resultDao;

    private static final String DQ = "DQ";

    private static String path = "http://toprunners.org/event-28-11-2015.html";

    public List<Result> parse()
    {
        List<Result> resultList = new ArrayList<Result>();
        Document doc  = null;
        try {
            doc = Jsoup.connect(path).get();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            String resultData = rows.get(i).text();
            try {
                Result result = parseResultRow(resultData);
                Runner runner = runnerDao.findRunner(result.getRunner());
                if(runner!=null) {
                    result.setRunner(runner);
                }
                resultList.add(result);
            }catch (IllegalArgumentException e){
                log.info(e.getMessage());
            }
        }
        return resultList;
}


    public Result parseResultRow(String runnerData){
        Runner runner = new Runner();

        Result result = new Result();

        StringTokenizer token = new StringTokenizer (runnerData);

        Distance distance = new Distance();

        Time time = new Time();
        String flag = token.nextToken();
        if(flag.equals(DQ))throw new IllegalArgumentException("Runner is DQ");

        runner.setName(token.nextToken());
        runner.setSurname(token.nextToken());
        result.setNumber(token.nextToken());
        StringTokenizer timeToken = new StringTokenizer(token.nextToken(),":,; ");
        time.setHours(Integer.valueOf(timeToken.nextToken()));
        time.setMinutes(Integer.valueOf(timeToken.nextToken()));
        time.setSeconds(Integer.valueOf(timeToken.nextToken()));
        result.setTime(time);
        result.setRunner(runner);
        return result;

        }

    public void parseAndInsert(){
        Runner runner = new Runner();
        List<Result> resultList = parse();
        for(int i=0;i<resultList.size();i++) {
            if (resultList.get(i).getRunner().getId()!=null)
                continue;
            else {
                runnerDao.insert(resultList.get(i).getRunner());
            }
            resultDao.insert(resultList.get(i));
        }
    }

}

