package com.vmo.nopcommerce.interfaces;

import org.openqa.selenium.WebDriver;

public class RegistrationPageUI {
    public static final String TITLE = "//div[@class='page-title']/h1";
    public static String GENDER_FEMALE = "//input[@id='gender-female']";
    public static String FIRST_NAME_INPUT = "//input[@id='FirstName']";
    public static String LAST_NAME_INPUT = "//input[@id='LastName']";
    public static String PASSWORD_INPUT = "//input[@id='Password']";
    public static String CONFIRM_PASSWORD_INPUT = "//input[@id='ConfirmPassword']";
    public static String SELECT_DAY = "//select[@name='DateOfBirthDay']";
    public static String SELECT_MONTH = "//select[@name='DateOfBirthMonth']";
    public static String SELECT_YEAR = "//select[@name='DateOfBirthYear']";
    public static String EMAIL_INPUT = "//input[@id='Email']";
    public static String REGISTER_BTN = "//button[@id='register-button']";
    public static String REGISTRATION_MESSAGE = "//div[@class='result']";
}
