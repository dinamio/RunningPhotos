package com.runningphotos.testdata;


import com.runningphotos.bom.Role;
import com.runningphotos.bom.Sex;
import com.runningphotos.bom.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jimmy on 14.12.2015.
 */
public class TestData {

    public static final String USERNAME = "Ivan";

    public static final String USER_SURNAME = "Ivanov";

    public static final String USER_LOGIN = "ivani";

    public static final String USER_CITY = "Kharkiv";

    public static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static final Date USER_BIRTHDAY = new Date();

    public static final String USER_MAIL = "ivani@ukr.net";


//
    public static final String USERNAME_UPDATE = "Andrey";

    public static final String USER_SURNAME_UPDATE = "Stepanov";

    public static final String USER_LOGIN_UPDATE = "Andri";

    public static final String USER_CITY_UPDATE = "Kherson";




    public static final Date USER_BIRTHDAY_UPDATE = new Date();

    public static final String USER_MAIL_UPDATE = "andri@ukr.net";

    public static final String RUNNER_NAME = "Anton";

    public static final String RUNNER_SURNAME = "Ivanchenko";

    public static final Sex RUNNER_SEX = Sex.MALE;

    public static final String RUNNER_NAME_UPDATE = "Michael";

    public static final String RUNNER_SURNAME_UPDATE = "Dobrynin";

    public static final Sex RUNNER_SEX_UPDATE = Sex.MALE;

    public static final String RACE_PHOTO_PATH = "race://photo/path";

    public static final String RACE_PHOTO_PATH_UPDATE = "race://photo/path2";

    public static final Date RACE_DATE = new Date();

    public static final String RACE_CITY = "Kharkiv";

    public static final String RACE_NAME = "Happy start";

    public static final Date RACE_DATE_UPDATE = new Date();

    public static final String RACE_CITY_UPDATE = "Lviv";

    public static final String RACE_NAME_UPDATE = "Worry start";

    public static final Time RESULT_TIME = new Time(11,22,33);

    public static final String RESULT_NUMBER = "1";

    public static final Time RESULT_TIME_UPDATE = new Time(10,20,30);

    public static final String RESULT_NUMBER_UPDATE = "7";

    public static final String DISTANCE_NAME = "Dummy distance";

    public static final Double DISTANCE_LENGHT = 0.5 ;

}
