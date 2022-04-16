package com.test.ua;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HomePageLogIn;
import pages.LogInPage;

import static constans.ConstantsData.EXPECTED_LOGIN_NAME;
import static org.testng.Assert.assertTrue;

import static constans.ConstantsData.LOGIN_AUTOMATIONPRACTICE;
import static constans.ConstantsData.PASSWORD_AUTOMATIONPRACTICE;

public class VerifyLoginTest extends BaseWebTest {

        @Test(priority = 4)
        @Description("Test to verify login functionality ")
        public void verifyLogin (){
            LogInPage logInPage = new HomePage(driver).clickToLogINButton();
            HomePageLogIn homePageLogIn = logInPage.
                    LogInToSystem(LOGIN_AUTOMATIONPRACTICE, PASSWORD_AUTOMATIONPRACTICE);
            assertTrue(homePageLogIn.getLogedInmessageText().contains(EXPECTED_LOGIN_NAME),
                    "Failed to login");
        }
    }

