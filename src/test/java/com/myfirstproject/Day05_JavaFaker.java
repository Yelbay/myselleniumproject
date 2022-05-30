package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    //fake data= Mock data is not real
//    fake data = mock data : data that is not real
//    fake ssn, fake name, fake address
//    we can use fake data to test
//    we can use java faker class to generate fake data
    /*
     * Where do you get your data?
     * 1. BA=business analyst
     * 2. Test Lead
     * 3. Manual Test- We have a manual tester that is in the project for a long time. he/she provides test data
     * 4. Tech Lead = Team Tech = Dev Lead
     * */

    @Test
    public void fakerTest(){
        //Create faker object
        Faker faker=new Faker();
        //Generate fake data
        String fName=faker.name().firstName();
        System.out.println(fName);
        String lName=faker.name().lastName();
        System.out.println(lName);

        String fullName=faker.name().fullName();
        System.out.println(fullName);

        String userName=faker.name().username();
        System.out.println(userName);

        String title=faker.name().title();
        System.out.println(title);

        String city=faker.address().city();
        System.out.println(city);

        String state=faker.address().state();
        System.out.println(state);

        String fullAddress=faker.address().fullAddress();
        System.out.println(fullAddress);

        String cellPhone=faker.phoneNumber().cellPhone();
        System.out.println(cellPhone);

        String email=faker.internet().emailAddress();
        System.out.println(email);
        String randomZipCode=faker.number().digits(5);
        System.out.println(randomZipCode);

       /*

        List<String> fake=new ArrayList<>();

        for (int i = 0; i <5 ; i++) {
      fake.add(faker.name().firstName());
   }
     System.out.println(fake);
        */


    }
}
