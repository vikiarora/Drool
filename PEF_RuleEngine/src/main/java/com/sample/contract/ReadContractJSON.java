package com.sample.contract;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadContractJSON {

	private ArrayList<Contract> contractList = new ArrayList<Contract>();
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
    	ReadContractJSON rcj = new ReadContractJSON();
    	rcj.readJSONFile();
    }
 
    public void readJSONFile() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Contracts.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray contractList = (JSONArray) obj;
            //System.out.println(contractList);
             
            //Iterate over contract array
            contractList.forEach( con -> parseContractObject( (JSONObject) con ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
    }
    private void parseContractObject(JSONObject contract) 
    {
        //Get contract object within list
        JSONObject jsonObject = (JSONObject) contract.get("contract");
        //Get contract first name
        String contractId = (String) jsonObject.get("contractId");    
        Float capacity = Float.valueOf((String)jsonObject.get("capacity")); 
        Float price = Float.valueOf((String) jsonObject.get("price"));
        String city = (String) jsonObject.get("city");
        Contract e = new Contract(contractId, capacity,price, city);
        contractList.add(e);
        //System.out.println(e);
    }
    
    public ArrayList<Contract> getContractList(){
    	return contractList;
    	
    }
}
