package com.ubs.arun.fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.ubs.arun.vo.BusinessVO;

public class TabSeparatedFileReader {

	public static void main(String args[]) throws Exception {
		ReadDataFromFile();
	}

	public static ArrayList<Object> ReadDataFromFile() {
		ArrayList<Object> businessList = new ArrayList<>();

		try {

			/**
			 * Source file to read data from.
			 */
			String dataFileName = "resources/FILE.DAT";
			/**
			 * Creating a buffered reader to read the file
			 */
			BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));

			String line;
			int counter = 0;

			/**
			 * Looping the read block until all lines in the file are read.
			 */
			while ((line = bReader.readLine()) != null) {

				/**
				 * Splitting the content of tabbed separated line
				 */

				if (counter != 0) {
					String datavalue[] = line.split("\\t");
					int CompanyCode = Integer.parseInt(datavalue[0]);
					int Account = Integer.parseInt(datavalue[1]);
					String City = datavalue[2];
					String Country = datavalue[3];
					String CreditRating = datavalue[4];
					String Currency = datavalue[5];
					Double Amount = Double.parseDouble(datavalue[6]);

					System.out.println(CompanyCode + "-" + Account + "-" + City + "-" + Country + "-" + CreditRating
							+ "-" + Currency + "-" + Amount);
					BusinessVO vo=new BusinessVO(CompanyCode,Account,City,Country,CreditRating,Currency,Amount);
					
					businessList.add(vo);
				}
				counter++;

				/**
				 * Printing the value read from file to the console
				 */
			}

			bReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return businessList;
	}

}
