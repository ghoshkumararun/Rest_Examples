package com.ubs.arun.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ubs.arun.fileread.TabSeparatedFileReader;
import com.ubs.arun.test.Item;
import com.ubs.arun.vo.BusinessVO;

public class Calclate_Average_GroupBy {

    public static void main(String[] args) {
    	//TabSeparatedFileReader.ReadDataFromFile();
    	start_here();
    }
    
    public static void start_here()
    {    	
    	
    	ArrayList<BusinessVO> businessData= (ArrayList)TabSeparatedFileReader.ReadDataFromFile();
    	List<BusinessVO> items= businessData;
    	
       Map<String, Double> average = items.stream().collect(
                 Collectors.groupingBy(BusinessVO::getCountry, Collectors.averagingDouble(BusinessVO::getAmount)));
    	 
    	 System.out.println(average);

    }
}