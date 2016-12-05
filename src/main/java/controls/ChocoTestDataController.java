package controls;

import java.util.List;
import entities.*;

import drivers.*;

public class ChocoTestDataController {
    
    public ChocoTestDataController(){
    }
    
    public boolean addTestDataTo(BillableRepository billableRepository){
            
        // Format for setting data recorded value : yyyy-MM-dd'T'HH:mm:ssZ
        
        String[][] billableStringDataArray = new String[42][];

        // Test data for xxx :
        // Basic test data for creating date range selector in provider report:
        //                                {"Billable_ID","Member_ID","Provider_ID","Serv_ID","DateSrved", "Date_Served_Recorded", "Cost", "Comment"};
        billableStringDataArray[0] = new String[]{"1",   "111111111", "222222222", "111111", "1/27/2016", "2016-1-28T10:32:31Z", "23.12", "Provider Date Range Test Billable! #1.1"};
        billableStringDataArray[1] = new String[]{"2",   "222222222", "222222222", "222222", "2/13/2016", "2016-2-14T14:01:10Z", "32.15", "Provider Date Range Test Billable! #1.2"};
        billableStringDataArray[2] = new String[]{"3",   "333333333", "222222222", "333333", "3/24/2016", "2016-3-25T14:01:10Z", "32.15", "Provider Date Range Test Billable! #1.3"};
        billableStringDataArray[3] = new String[]{"4",   "444444444", "222222222", "444444", "6/24/2016", "2016-6-25T14:01:10Z", "42.15", "Provider Date Range Test Billable! #1.4"};
        billableStringDataArray[4] = new String[]{"5",   "555555555", "222222222", "555555", "12/3/2016", "2016-12-4T10:32:31Z", "53.15", "Provider Date Range Test Billable! #1.5"};
        
        
        // Second Test data for creating date range selector in provider report with no service provided in last week:
        //                                {"Billable_ID","Member_ID","Provider_ID","Serv_ID","DateSrved", "Date_Served_Recorded", "Cost", "Comment"};
        billableStringDataArray[5] = new String[]{"6",   "666666666", "333333333", "666666", "6/21/2016", "2016-6-22T10:32:31Z", "63.16", "Test Billable! #6"};
        billableStringDataArray[6] = new String[]{"7",   "777777777", "333333333", "777777", "7/4/2016", "2016-7-5T10:32:31Z", "73.17", "Test Billable! #7"};
        billableStringDataArray[7] = new String[]{"8",   "888888888", "333333333", "888888", "8/12/2016", "2016-8-13T10:32:31Z", "83.18", "Test Billable! #8"};
        billableStringDataArray[8] = new String[]{"9",   "999999999", "333333333", "999999", "9/30/2016", "2016-9-30T10:32:31Z", "93.19", "Test Billable! #9"};
        billableStringDataArray[9] = new String[]{"10",  "111111111", "333333333", "111111", "10/5/2016", "2016-10-6T10:32:31Z", "13.11", "Test Billable! #10"};


        billableStringDataArray[10] = new String[]{"11", "222222222", "999999999", "222222", "11/27/2016", "2016-11-26T10:32:31Z", "23.12", "Test Billable! #11"};
        billableStringDataArray[11] = new String[]{"12", "222222222", "999999999", "222222", "11/27/2016", "2016-11-26T10:32:31Z", "23.12", "Test Billable! #12"};
        billableStringDataArray[12] = new String[]{"13", "333333333", "888888888", "333333", "1/27/2016", "2016-11-26T10:32:31Z", "33.13", "Test Billable! #13"};
        billableStringDataArray[13] = new String[]{"14", "333333333", "888888888", "333333", "2/27/2016", "2016-11-26T10:32:31Z", "33.13", "Test Billable! #14"};
        billableStringDataArray[14] = new String[]{"15", "444444444", "444444444", "444444", "3/27/2016", "2016-11-26T10:32:31Z", "43.14", "Test Billable! #15"};
        billableStringDataArray[15] = new String[]{"16", "444444444", "444444444", "444444", "4/27/2016", "2016-11-26T10:32:31Z", "43.14", "Test Billable! #16"};
        billableStringDataArray[16] = new String[]{"17", "555555555", "555555555", "555555", "5/27/2016", "2016-11-26T10:32:31Z", "53.15", "Test Billable! #17"};
        billableStringDataArray[17] = new String[]{"18", "555555555", "555555555", "555555", "6/27/2016", "2016-11-26T10:32:31Z", "53.15", "Test Billable! #18"};
        billableStringDataArray[18] = new String[]{"19", "666666666", "666666666", "666666", "7/27/2016", "2016-11-26T10:32:31Z", "63.16", "Test Billable! #19"};
        billableStringDataArray[19] = new String[]{"20", "666666666", "666666666", "666666", "8/27/2016", "2016-11-26T10:32:31Z", "63.16", "Test Billable! #20"};

        billableStringDataArray[20] = new String[]{"21", "777777777", "777777777", "777777", "9/27/2016", "2016-11-26T10:32:31Z", "73.17", "Test Billable! #21"};
        billableStringDataArray[21] = new String[]{"22", "777777777", "777777777", "777777", "10/27/2016", "2016-11-26T10:32:31Z", "73.17", "Test Billable! #22"};
        billableStringDataArray[22] = new String[]{"23", "888888888", "888888888", "888888", "11/27/2016", "2016-11-26T10:32:31Z", "83.18", "Test Billable! #23"};
        billableStringDataArray[23] = new String[]{"24", "888888888", "888888888", "888888", "11/27/2016", "2016-11-26T10:32:31Z", "83.18", "Test Billable! #24"};
        billableStringDataArray[24] = new String[]{"25", "999999999", "999999999", "999999", "1/27/2016", "2016-11-26T10:32:31Z", "93.19", "Test Billable! #25"};
        billableStringDataArray[25] = new String[]{"26", "999999999", "999999999", "999999", "2/27/2016", "2016-11-26T10:32:31Z", "93.19", "Test Billable! #26"};

        // Test data for testing edge cases on reports, (edge is Friday at 9pm) :
        //                                {"Billable_ID","Member_ID","Provider_ID","Serv_ID","DateSrved", "Date_Served_Recorded", "Cost", "Comment"};
        billableStringDataArray[26] = new String[]{"27",   "111111111", "111111111", "111111", "8/25/2016", "2016-8-26T20:59:31Z", "43.62", "Edge Test Billable! #1.1 - FRONT"};
        billableStringDataArray[27] = new String[]{"28",   "222222222", "111111111", "111111", "8/26/2016", "2016-8-26T21:00:01Z", "99.99", "Edge Test Billable! #1.2 - REAR"};
        billableStringDataArray[28] = new String[]{"29",   "444444444", "111111111", "111111", "9/8/2016", "2016-9-9T20:59:59Z", "13.52", "Edge Test Billable! #2.1 - FRONT"};
        billableStringDataArray[29] = new String[]{"30",   "333333333", "111111111", "111111", "9/9/2016", "2016-9-9T21:00:00Z", "45.56", "Edge Test Billable! #2.2 - FRONT"};

        billableStringDataArray[30] = new String[]{"31",   "222222222", "111111111", "222222", "9/9/2016", "2016-9-9T21:00:01Z", "100.23", "Edge Test Billable! #2.3 - REAR"};
        billableStringDataArray[31] = new String[]{"32",   "111111111", "111111111", "222222", "9/9/2016", "2016-9-9T21:00:31Z", "23.12", "Edge Test Billable! #2.4 - REAR"};
        billableStringDataArray[32] = new String[]{"33",   "111111111", "111111111", "333333", "10/12/2016", "2016-10-13T10:32:31Z", "100.52", "Random Test Billable! #3.0"};
        billableStringDataArray[33] = new String[]{"34",   "222222222", "111111111", "333333", "11/03/2016", "2016-11-4T20:59:31Z", "62.34", "Edge Test Billable! #4.1 - FRONT"};
        billableStringDataArray[34] = new String[]{"35",   "111111111", "111111111", "999999", "11/4/2016", "2016-11-4T20:59:59Z", "123.43", "Edge Test Billable! #4.2 - FRONT"};
        billableStringDataArray[35] = new String[]{"36",   "333333333", "111111111", "333333", "11/4/2016", "2016-11-4T21:00:00Z", "123.42", "Edge Test Billable! #4.3 - FRONT"};
        billableStringDataArray[36] = new String[]{"37",   "111111111", "111111111", "111111", "11/4/2016", "2016-11-4T21:00:01Z", "323.52", "Edge Test Billable! #4.4 - REAR"};
        billableStringDataArray[37] = new String[]{"38",   "777777777", "111111111", "444444", "11/4/2016", "2016-11-4T21:01:01Z", "193.15", "Edge Test Billable! #4.5 - REAR"};
        billableStringDataArray[38] = new String[]{"39",   "888888888", "111111111", "111111", "12/1/2016", "2016-12-2T10:32:31Z", "123.12", "Edge Test Billable! #5.1 - FRONT"};
        billableStringDataArray[39] = new String[]{"40",   "999999999", "111111111", "444444", "12/1/2016", "2016-12-2T20:59:59Z", "213.15", "Edge Test Billable! #5.2 - FRONT"};

        billableStringDataArray[40] = new String[]{"39",   "888888888", "111111111", "111111", "12/2/2016", "2016-12-2T21:00:00Z", "134.43", "Edge Test Billable! #5.3 - FRONT"};
        billableStringDataArray[41] = new String[]{"40",   "999999999", "111111111", "444444", "12/2/2016", "2016-12-2T21:00:01Z", "163.67", "Edge Test Billable! #5.4 - REAR"};


        if (billableRepository.findAll().size() > 0){
            return false;
        }
        
        for (int i = 0; i < billableStringDataArray.length; i++){
            Billable billableTestData = new Billable();
            
            billableTestData.setEntityBillableIdNumber(billableStringDataArray[i][0]);
            billableTestData.setMemberNumberService(billableStringDataArray[i][1]);
            billableTestData.setProviderNumberServicing(billableStringDataArray[i][2]);
            billableTestData.setServiceNumberServiced(billableStringDataArray[i][3]);
            billableTestData.setDateServiced(billableStringDataArray[i][4]);
            billableTestData.setDateServicedRecorded(billableStringDataArray[i][5]);
            billableTestData.setServiceCost(Double.parseDouble(billableStringDataArray[i][6]));
            billableTestData.setServiceComment(billableStringDataArray[i][7]);

            billableRepository.save(billableTestData);
        }
        return true;
    }
    
    public boolean addTestDataTo(ProviderRepository providerRepository){

        String[][] providerStringDataArray = new String[9][];

        providerStringDataArray[0] = new String[]{"111111111", "providerOne@providers.com", "Provider One", "1 S. Provider St.", "Provider Town", "WI", "12345", "true", "false", "false"};
        providerStringDataArray[1] = new String[]{"222222222", "providerTwo@providers.com", "Provider Two", "2 S. Provider St.", "Provider City", "WI", "54321", "false", "true", "false"};
        providerStringDataArray[2] = new String[]{"333333333", "providerThree@providers.com", "Provider Three", "3 S. Provider St.", "ProviderVille", "WI", "11223", "false", "false", "true"};
        providerStringDataArray[3] = new String[]{"444444444", "providerFour@providers.com", "Provider Four", "4 S. Provider St.", "Provider Village", "WI", "22334", "true", "true", "false"};
        providerStringDataArray[4] = new String[]{"555555555", "providerFive@providers.com", "Provider Five", "5 S. Provider St.", "Provider Glen", "WI", "78945", "true", "false", "true"};
        providerStringDataArray[5] = new String[]{"666666666", "providerSix@providers.com", "Provider Six", "6 S. Provider St.", "Provider Place", "WI", "65432", "false", "true", "true"};
        providerStringDataArray[6] = new String[]{"777777777", "providerSeven@providers.com", "Provider Seven", "7 S. Provider St.", "Provider Metro", "WI", "45678", "true", "true", "true"};
        providerStringDataArray[7] = new String[]{"888888888", "providerEight@providers.com", "Provider Eight", "8 S. Provider St.", "Provider Wonder Land", "WI", "11224", "false", "false", "false"};
        providerStringDataArray[8] = new String[]{"999999999", "providerNine@providers.com", "Provider Nine", "9 S. Provider St.", "Provider Zoo", "WI", "66655", "true", "false", "false"};

        if (providerRepository.findAll().size() > 0){
            return false;
        }

        for (int i = 0; i < providerStringDataArray.length; i++){
            Provider providerTestData = new Provider();

            providerTestData.setEntityProviderIdNumber(providerStringDataArray[i][0]);
            providerTestData.setEntityProviderEmailAddress(providerStringDataArray[i][1]);
            providerTestData.setProviderName(providerStringDataArray[i][2]);
            providerTestData.setProviderStreetAddress(providerStringDataArray[i][3]);
            providerTestData.setProviderCity(providerStringDataArray[i][4]);
            providerTestData.setProviderState(providerStringDataArray[i][5]);
            providerTestData.setProviderZip(Long.parseLong(providerStringDataArray[i][6]));
            providerTestData.setIsDietitian(Boolean.parseBoolean(providerStringDataArray[i][7]));
            providerTestData.setIsExerciseExpert(Boolean.parseBoolean(providerStringDataArray[i][8]));
            providerTestData.setIsInternist(Boolean.parseBoolean(providerStringDataArray[i][9]));

            providerRepository.save(providerTestData);
        }
        return true;
    }
    
    public boolean addTestDataTo(ServiceRepository serviceRepository){

        String[][] serviceStringDataArray = new String[9][];
        
        serviceStringDataArray[0] = new String[]{"111111", "Provided Service One", "true", "false", "false"};
        serviceStringDataArray[1] = new String[]{"222222", "Provided Service Two", "false", "true", "false"};
        serviceStringDataArray[2] = new String[]{"333333", "Provided Service Three", "false", "false", "true"};
        serviceStringDataArray[3] = new String[]{"444444", "Provided Service Four", "true", "true", "false"};
        serviceStringDataArray[4] = new String[]{"555555", "Provided Service Five", "true", "false", "true"};
        serviceStringDataArray[5] = new String[]{"666666", "Provided Service Six", "false", "true", "true"};
        serviceStringDataArray[6] = new String[]{"777777", "Provided Service Seven", "true", "true", "true"};
        serviceStringDataArray[7] = new String[]{"888888", "Provided Service Eight", "false", "false", "false"};
        serviceStringDataArray[8] = new String[]{"999999", "Provided Service Nine", "true", "false", "false"};

        if (serviceRepository.findAll().size() > 0){
            return false;
        }
        
        for (int i = 0; i < serviceStringDataArray.length; i++){
            Service serviceTestData = new Service();
            
            serviceTestData.setEntityServiceIdNumber(serviceStringDataArray[i][0]);
            serviceTestData.setProvidableServiceDescription(serviceStringDataArray[i][1]);
            serviceTestData.setIsProvidableByDietitian(Boolean.parseBoolean(serviceStringDataArray[i][2]));
            serviceTestData.setIsProvidableByExerciseExpert(Boolean.parseBoolean(serviceStringDataArray[i][3]));
            serviceTestData.setIsProvidableByInternist(Boolean.parseBoolean(serviceStringDataArray[i][4]));
            
            serviceRepository.save(serviceTestData);
        }
        return true;
    }
    
    public boolean addTestDataTo(UserRepository userRepository){

        String[][] userStringDataArray = new String[9][];
        
        userStringDataArray[0] = new String[]{"111111111", "userOne@users.com", "User One", "1 N. User Drive", "Userville", "IL", "43454", "1/12/2017"};
        userStringDataArray[1] = new String[]{"222222222", "userTwo@users.com", "User Two", "2 N. User Drive", "User Town", "WI", "43454", "12/20/2016"};
        userStringDataArray[2] = new String[]{"333333333", "userThree@users.com", "User Three", "3 N. User Drive", "User City", "OH", "43454", "12/19/2016"};
        userStringDataArray[3] = new String[]{"444444444", "userFour@users.com", "User Four", "4 N. User Drive", "User Village", "WI", "43454", "12/30/2016"};
        userStringDataArray[4] = new String[]{"555555555", "userFive@users.com", "User Five", "5 N. User Drive", "User Borg", "MN", "43454", "12/17/2016"};
        userStringDataArray[5] = new String[]{"666666666", "userSix@users.com", "User Six", "6 N. User Drive", "User Place", "TX", "43454", "12/20/2016"};
        userStringDataArray[6] = new String[]{"777777777", "userSeven@users.com", "User Seven", "7 N. User Drive", "User Dong", "NY", "43454", "12/26/2016"};
        userStringDataArray[7] = new String[]{"888888888", "userEight@users.com", "User Eight", "8 N. User Drive", "User Bay", "IL", "43454", "1/1/2017"};
        userStringDataArray[8] = new String[]{"999999999", "userNine@users.com", "User Nine", "9 N. User Drive", "User Inc", "IL", "43454", "10/6/2016"};

        if (userRepository.findAll().size() > 0){
            return false;
        }
        
        for (int i = 0; i < userStringDataArray.length; i++){
            User userTestData = new User();
            
            userTestData.setEntityUserIdNumber(userStringDataArray[i][0]);
            userTestData.setEntityUserEmailAddress(userStringDataArray[i][1]);
            userTestData.setMemberName(userStringDataArray[i][2]);
            userTestData.setMemberStreetAddress(userStringDataArray[i][3]);
            userTestData.setMemberCity(userStringDataArray[i][4]);
            userTestData.setMemberState(userStringDataArray[i][5]);
            userTestData.setMemberZip(Long.parseLong(userStringDataArray[i][6]));
            userTestData.setMemberValidThrough(userStringDataArray[i][7]);            
            
            userRepository.save(userTestData);
        }
        return true;
    }
} // ChocoTestDataController coded by Benjamin Haos 12/3/16