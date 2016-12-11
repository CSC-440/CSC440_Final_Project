package controls;

import java.util.List;
import entities.*;

import drivers.*;
import org.joda.time.*;
import org.joda.time.format.*;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChocoTestData {
    
    private Random rand = new Random(); 
    HashMap<String,String> settings;
    ArrayList<String> firstNames; 
	ArrayList<String> lastNames; 
	ArrayList<String> serviceNames;
	ArrayList<String> memberIDs; 
	ArrayList<String> providerIDs; 
	ArrayList<String> serviceIDs;
	ArrayList<String> cities;
	ArrayList<String> states;
	ArrayList<String> streetNames;
	ArrayList<String> streetTypes;
	
	String folder;
	
    
    public ChocoTestData(){
        init();
    }
    
    public void init(){
        settings = getSettings("settings.ini");
        folder = "."+ File.separator + settings.get("fileFolder") + File.separator;
        firstNames = getNames(folder + settings.get("firstNameFile"));
		lastNames = getNames(folder + settings.get("lastNameFile"));
		serviceNames = getNames(folder + settings.get("serviceNamesFile"));
		memberIDs = getNumberList(Integer.parseInt(settings.get("numberOfMembers")), Integer.parseInt(settings.get("memberIDlength")));
		providerIDs = getNumberList(Integer.parseInt(settings.get("numberOfProviders")), Integer.parseInt(settings.get("providerIDlength")));
		serviceIDs = getNumberList(Integer.parseInt(settings.get("numberOfServices")), Integer.parseInt(settings.get("serviceIDlength")));
		cities = getNames(folder + settings.get("citiesFile"));
    	states = getNames(folder + settings.get("statesFile"));
    	streetNames = getNames(folder + settings.get("streetNames"));
        streetTypes = getNames(folder + settings.get("streetTypes"));
    }
    
    public boolean addTestDataTo(BillableRepository billableRepository){
        
        if (billableRepository.findAll().size() > 0) return false;
        
        //init();
        
        ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
        DateTimeFormatter timeFormat = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime min = timeFormat.parseDateTime(settings.get("billableMinDate"));
        DateTime max = timeFormat.parseDateTime(settings.get("billableMaxDate"));


        
        if(Integer.parseInt(settings.get("loadBillables"))== 1){
            //System.out.println("loading billables from file ...");
			records = getRecordsFromFile(folder + settings.get("billablesFile"));
			for(ArrayList<String> cur : records){
				Billable billableTestData = new Billable();
            
                billableTestData.setEntityBillableIdNumber(cur.get(0));
                billableTestData.setMemberNumberService(cur.get(1));
                billableTestData.setProviderNumberServicing(cur.get(2));
                billableTestData.setServiceNumberServiced(cur.get(3));
                billableTestData.setDateServiced(cur.get(4));
                billableTestData.setDateServicedRecorded(cur.get(5));
                billableTestData.setServiceCost(Double.parseDouble(cur.get(6)));
                billableTestData.setServiceComment(cur.get(7));
                
                //System.out.printf(billableTestData + "\n");
                billableRepository.save(billableTestData);
			}
		}
		
		//yyyy-MM-dd'T'HH:mm:ssZ
		//System.out.println("generating additional billables ...");
		for (int i = 0; i < Integer.parseInt(settings.get("numberOfBillables")); i++){
		    Billable billableTestData = new Billable();
		    DateTime temp = createRandomDate(min,max);
		    
	        billableTestData.setEntityBillableIdNumber(Integer.toString(i));
            billableTestData.setMemberNumberService(memberIDs.get(rand.nextInt(memberIDs.size())));
            billableTestData.setProviderNumberServicing(providerIDs.get(rand.nextInt(providerIDs.size())));
            billableTestData.setServiceNumberServiced(serviceIDs.get(rand.nextInt(serviceIDs.size())));
            
            timeFormat = DateTimeFormat.forPattern("MM/dd/yyyy");
            billableTestData.setDateServiced(timeFormat.print(temp));
            
            timeFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            billableTestData.setDateServicedRecorded(timeFormat.print(temp.plusMinutes(createRandomInt(1,120))));
            
            billableTestData.setServiceCost(rand.nextDouble() * 100);
            billableTestData.setServiceComment("Randomly generated billable");
            
            //System.out.printf(billableTestData + "\n");
            billableRepository.save(billableTestData);
		} 
        return true;
    }
    
    public boolean addTestDataTo(ProviderRepository providerRepository){
        
        if (providerRepository.findAll().size() > 0) return false;
        
        //init();

        ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();

        if(Integer.parseInt(settings.get("loadProviders"))== 1){
            //System.out.println("loading providers from file ...");
			records = getRecordsFromFile(folder + settings.get("providersFile"));
			for(ArrayList<String> cur : records){
			    Provider providerTestData = new Provider();

                providerTestData.setEntityProviderIdNumber(cur.get(0));
                providerTestData.setEntityProviderEmailAddress(cur.get(1));
                providerTestData.setProviderName(cur.get(2));
                providerTestData.setProviderStreetAddress(cur.get(3));
                providerTestData.setProviderCity(cur.get(4));
                providerTestData.setProviderState(cur.get(5));
                providerTestData.setProviderZip(Long.parseLong(cur.get(6)));
                providerTestData.setIsDietitian(Boolean.parseBoolean(cur.get(7)));
                providerTestData.setIsExerciseExpert(Boolean.parseBoolean(cur.get(8)));
                providerTestData.setIsInternist(Boolean.parseBoolean(cur.get(9)));
    
                //System.out.printf(providerTestData + "\n");
                providerRepository.save(providerTestData);
			}
        }
        
        ArrayList<String> names = new ArrayList<String>();
        
        for(int i = 0; i < Integer.parseInt(settings.get("numberOfProviders")); i++){
			names.add(genName(firstNames,lastNames));
		}
        
        for (int i = 0; i < Integer.parseInt(settings.get("numberOfProviders")); i++){
        	Provider providerTestData = new Provider();

            String tempProv = providerIDs.get(rand.nextInt(providerIDs.size()));
            providerTestData.setEntityProviderIdNumber(tempProv);
            providerTestData.setEntityProviderEmailAddress(String.format("%s@%s.com",names.get(i),serviceNames.get(rand.nextInt(serviceNames.size()))));
            providerTestData.setProviderName(names.get(rand.nextInt(names.size())));
            providerTestData.setProviderStreetAddress(String.format("%d %s %s",rand.nextInt(9998)+1,streetNames.get(rand.nextInt(streetNames.size())),streetTypes.get(rand.nextInt(streetTypes.size()))));
            providerTestData.setProviderCity(cities.get(rand.nextInt(cities.size())));
            providerTestData.setProviderState(states.get(rand.nextInt(states.size())));
            providerTestData.setProviderZip(createRandomInt(00501,99950));
            providerTestData.setIsDietitian(rand.nextBoolean());
            providerTestData.setIsExerciseExpert(rand.nextBoolean());
            providerTestData.setIsInternist(rand.nextBoolean());

            //System.out.printf(providerTestData + "\n");
            providerRepository.save(providerTestData);
        }
        
        return true;
    }
    
    public boolean addTestDataTo(ServiceRepository serviceRepository){
        
        if (serviceRepository.findAll().size() > 0) return false;
        
        
        //init();
        
        ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
        
        if(Integer.parseInt(settings.get("loadServices"))== 1){
            //System.out.println("loading services from file ...");
			records = getRecordsFromFile(folder + settings.get("servicesFile"));
			for(ArrayList<String> cur : records){
			    Service serviceTestData = new Service();
            
                serviceTestData.setEntityServiceIdNumber(cur.get(0));
                serviceTestData.setProvidableServiceDescription(cur.get(1));
                serviceTestData.setIsProvidableByDietitian(Boolean.parseBoolean(cur.get(2)));
                serviceTestData.setIsProvidableByExerciseExpert(Boolean.parseBoolean(cur.get(3)));
                serviceTestData.setIsProvidableByInternist(Boolean.parseBoolean(cur.get(4)));
                
                //System.out.printf(serviceTestData + "\n");
                serviceRepository.save(serviceTestData);
			}
        }
        
        for (int i = 0; i < Integer.parseInt(settings.get("numberOfServices")); i++){
        	Service serviceTestData = new Service();
        
            serviceTestData.setEntityServiceIdNumber(serviceIDs.get(rand.nextInt(serviceIDs.size())));
            serviceTestData.setProvidableServiceDescription(String.format("Random service desicription #%d",i));
            serviceTestData.setIsProvidableByDietitian(rand.nextBoolean());
            serviceTestData.setIsProvidableByExerciseExpert(rand.nextBoolean());
            serviceTestData.setIsProvidableByInternist(rand.nextBoolean());
            
            //System.out.printf(serviceTestData + "\n");
            serviceRepository.save(serviceTestData);
        }
        
        return true;
    }
    
    public boolean addTestDataTo(UserRepository userRepository){
        
        if (userRepository.findAll().size() > 0) return false;
        
        //init();
        
        ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
        
        if(Integer.parseInt(settings.get("loadMembers"))== 1){
            //System.out.println("loading members from file ...");
			records = getRecordsFromFile(folder + settings.get("membersFile"));
			for(ArrayList<String> cur : records){
			    User userTestData = new User();
            
                userTestData.setEntityUserIdNumber(cur.get(0));
                userTestData.setEntityUserEmailAddress(cur.get(1));
                userTestData.setMemberName(cur.get(2));
                userTestData.setMemberStreetAddress(cur.get(3));
                userTestData.setMemberCity(cur.get(4));
                userTestData.setMemberState(cur.get(5));
                userTestData.setMemberZip(Long.parseLong(cur.get(6)));
                userTestData.setMemberValidThrough(cur.get(7));            
                
                //System.out.printf(userTestData + "\n");
                userRepository.save(userTestData);
			}
        }
        
        ArrayList<String> names = new ArrayList<String>();
        DateTimeFormatter timeFormat = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime min = timeFormat.parseDateTime(settings.get("billableMinDate"));
        DateTime max = timeFormat.parseDateTime(settings.get("billableMaxDate"));
        
        for(int i = 0; i < Integer.parseInt(settings.get("numberOfProviders")); i++){
			names.add(genName(firstNames,lastNames));
		}
        
        for (int i = 0; i < Integer.parseInt(settings.get("numberOfMembers")); i++){
        	User userTestData = new User();
        	DateTime temp = createRandomDate(min,max);
        
            String tempUser = memberIDs.get(rand.nextInt(memberIDs.size()));
            userTestData.setEntityUserIdNumber(tempUser);
            userTestData.setEntityUserEmailAddress(String.format("%s@%s.com",names.get(i),serviceNames.get(rand.nextInt(serviceNames.size()))));
            userTestData.setMemberName(names.get(rand.nextInt(names.size())));
            userTestData.setMemberStreetAddress(String.format("%d %s %s",rand.nextInt(9998)+1,streetNames.get(rand.nextInt(streetNames.size())),streetTypes.get(rand.nextInt(streetTypes.size()))));
            userTestData.setMemberCity(cities.get(rand.nextInt(cities.size())));
            userTestData.setMemberState(states.get(rand.nextInt(states.size())));
            userTestData.setMemberZip(createRandomInt(00501,99950));
            
            timeFormat = DateTimeFormat.forPattern("MM/dd/yyyy");
            userTestData.setMemberValidThrough(timeFormat.print(temp));            
            
            //System.out.printf(userTestData + "\n");
            userRepository.save(userTestData);
        }
        
        return true;
    }
    
    public DateTime createRandomDate(DateTime min, DateTime max){
        int year = rand.nextInt(max.getYear() - min.getYear()+1) + min.getYear();
        int dayOfYear = rand.nextInt(max.getDayOfYear() - min.getDayOfYear()+1) + min.getDayOfYear();
        int hour = rand.nextInt(max.getHourOfDay() - min.getHourOfDay()+1) + min.getHourOfDay();
        int minute = rand.nextInt(max.getMinuteOfHour() - min.getMinuteOfHour()+1) + min.getMinuteOfHour();
        int second = rand.nextInt(max.getSecondOfMinute() - min.getSecondOfMinute()+1) + min.getSecondOfMinute();
        int mills = rand.nextInt(999)+1;
        
        DateTime temp = new DateTime(year,1,1,hour,minute,second,mills);
        temp.plusDays(dayOfYear - 1);
        
        return temp;
    }
    
    public int createRandomInt(int min, int max){
        return rand.nextInt(max - min + 1) + min;
    }
    
    public HashMap<String,String> getSettings(String path){
        HashMap<String,String> settings = new HashMap<String,String>(); 
		Scanner input;
		try
		{
			input = new Scanner(new File(path));
			while(input.hasNext())
			{
            	String seg[] = input.nextLine().split("=");
            	if(seg.length > 1){
            		settings.put(seg[0],seg[1]);
            	}
			}
			if (input != null)
			{
				input.close();
			}
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.printf("%s not found.",path);
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File corrupt.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Cannot read from file.");
		}
        return settings;
    }
    
    public ArrayList<String> getNames(String path){
        ArrayList<String> names = new ArrayList<String>(); 
		Scanner input;
		try
		{
			input = new Scanner(new File(path));
			while(input.hasNext())
			{
            	names.add(input.nextLine().trim());
			}
			if (input != null)
			{
				input.close();
			}
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.printf("%s not found.",path);
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File corrupt.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Cannot read from file.");
		}
        return names;
    }
    
    public String genName(ArrayList<String> firstNames, ArrayList<String> lastNames){  	
    	String first = firstNames.get(rand.nextInt(firstNames.size()));
    	String last = lastNames.get(rand.nextInt(lastNames.size()));
    	return first + " " + last;
    }
    
    public ArrayList<String> getNumberList(int qty, int length){
    	HashSet<Integer> nums = new HashSet<Integer>();
    	ArrayList<String> numList = new ArrayList<String>();
    	int max = 0;
    	String temp = "";
    	
    	for(int i = 0; i < length; i++){
    		temp +="9";
    	}
    	
    	max = Integer.parseInt(temp);
    	
    	for(int i = 0; i < qty; i++){
    		boolean unique = false;
    		do{
    			int num = createRandomInt(1,max);
    			if (nums.contains(num)){
    				unique = false;
    			}
    			else{
    				unique = true;
    				nums.add(num);
    			}
    		}while(unique = false);
    	}
    	String format = String.format("%%0%dd",length);
    	for(int cur : nums){
    		numList.add(String.format(format,cur));
    	}
    	
    	return numList;
    }
    
    public ArrayList<ArrayList<String>> getRecordsFromFile(String path){
    	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		try
		{
			Scanner input = new Scanner(new File(path));
			while(input.hasNext())
			{
            	String seg[] = input.nextLine().split(",");
            	ArrayList<String> record = new ArrayList<String>();
            	for(String cur : seg){
            		record.add(cur.trim());
            	}
            	records.add(record);
			}
			if (input != null)
			{
				input.close();
			}
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.printf("%s not found.",path);
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File corrupt.");
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Cannot read from file.");
		}
    	return records;
    }

} // ChocoTestDataController coded by Benjamin Haos 12/3/16