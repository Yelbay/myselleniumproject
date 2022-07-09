package com.myfirstproject;

public class Day13_InterviewQuestions {
/*
 * Interview Questions
 Tell me 5 exception that you get.
 What type of exceptions do you get in selenium?
 What is your solution?
 What type of waits do you use?
 Which wait do you prefer?
 Why do you prefer that wait?
How to you resolve synchronization issue?*/
//Tell me 5 exception that you get/What type of exceptions do you get in selenium?
//    Null pointer, no such element, time out, slate element reference, web driver
//    What is your solution?
//    Read the error message and learn what is the error and where it is.
//    In general, error happens because of the timing issue, wrong locator, or iframe/windows/alerts
//    Each error has specific solutions but in general, I debug my code, and do some research then execute the code one more time after the fix.
//    What type of waits do you use?
//    I use implicit or explicit wait
//    Which wait do you prefer?
//    Explicit wait works better in some cases. When I use explicit wait, and still see timeout exception, then then there can be other issues such as incorrect locators.
//            Why do you prefer that wait?
//    I prefer explicit wait when I need to use an expected condition such as element is not visible.
//    How do you resolve synronization issue?
//    I use implicit or explicit wait. In my driver class, I already have implicit wait, that handles most of the wait issues, but when it is not enough than I use explicit wait.
    /* Interview Questions
    Tell me 5 exception that you get?  What type of exceptions do you get in selenium?
            * NullPointerException, TimeOutException, StaleElementReferenceException, NoSuchElementException, WebDriverException
    *
            * What is your solution?
            * We can read the console, read error message, try to understand what the problem is.
            * Check locator, Do manual test, Add wait, Search the problem
    *
    What type of waits do you use?
            * We can use implicit and explicit wait
    *
            *
    Which wait do you prefer?
    Why do you prefer that wait?
            * In depends on the case
            *
            * I prefer implicitly wait first, if it is not enough, I will try explicit wait
    *
            * I also use implicitly wait in my test base class, if it works I will use it.
            * If I need more, I will add explicit wait
    *
            * As a last solution we might try Thread.sleep()
            *
    How to you resolve synchronization issue?
            *  We can use different wait types for solving synchronization issues*/
}
