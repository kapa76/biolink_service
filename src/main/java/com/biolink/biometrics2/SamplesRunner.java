package com.biolink.biometrics2;

import java.io.*;

public class SamplesRunner
{
	static Image ScanImage(Scanner scanner)
	{
		System.out.println("Press your finger to the scanner");
		try
	    {
	        Thread.sleep (2000);
	    }
	    catch  (InterruptedException e) { }

        Image image = null;
        int expressQuality = 0;
        System.out.println("Scanning...");

        while (expressQuality < 20)
        {
            if (image != null)
                image.dispose();

            image = scanner.acquireImage();
            expressQuality = image.getExpressQuality();
        }

        //getting image quality
        System.out.println("Scanned image quality " + image.getExpressQuality());

        System.out.println("Remove your finger to the scanner");
        try
	    {
	        Thread.sleep (2000);
	    }
	    catch  (InterruptedException e) { }

        return image;
	}
	
	static void ViewComment()
	{         
         System.out.println("\n" + "Samples:");        
		 System.out.println("1. Common");
		 System.out.println("2. WSQ");
		 System.out.println("3. Using Recordset");
		 System.out.println("4. MultiFinger");
		 System.out.print("Enter sample number: ");
         try
         {
        	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        	 int scenario = Integer.parseInt(in.readLine());
             System.out.println("");

             if ((scenario > 0) && (scenario < 5))
                 RunSample(scenario);
             else throw new Exception(); 
         }
         catch(Exception ex)
         {
        	 System.out.print("\n" + "Bad sample number" + "\n");
         }
	}
	
	static void RunSample(int scenario)
	{
		if (scenario == 1)
        {
        	Common commonSample = new Common();
        	commonSample.RunSample();
        }
        if (scenario == 2)
        {
        	Wsq wsqSample = new Wsq();
        	wsqSample.RunSample();
        }
        if (scenario == 3)
        {
        	UsingRecordSet usingRecordSetSample = new UsingRecordSet();
        	usingRecordSetSample.RunSample();
        }
        if (scenario == 4)
        {
        	MultiFinger multiFingerSample = new MultiFinger();
        	multiFingerSample.RunSample();
        }
	}
	
	public static void main(String[] args)
	{
        int scenario;
        try
        {
            scenario = Integer.parseInt(args[0]);
            if ((scenario > 0) && (scenario < 5))
                RunSample(scenario);
            else throw new Exception();
        }
        catch (Exception ex)
        {
            ViewComment();
        }
	}
}
