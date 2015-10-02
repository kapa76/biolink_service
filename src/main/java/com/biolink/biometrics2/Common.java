package com.biolink.biometrics2;

public class Common
{
	public Common()
	{
	}
	
	public void RunSample()
	{	
		License license = null;
		DeviceList deviceList = null;
		DeviceDescriptor deviceDescriptor = null;
		Scanner scanner = null;
		Image finger1Impression1 = null;
        Image finger1Impression2 = null;
        Image finger1Impression3 = null;
        ImageSet imageSet = null;
        ImageProcessor imgPrc = null;
        Template templ = null;
        Image finger2 = null;
        Template template1 = null;
        Template template2 = null;
        Matcher matcher = null;
		try
		{
			license = new License();
			
			deviceList = new DeviceList(DeviceType.AnyScanner);
			if (deviceList.getSize() == 0)
                throw new Exception("Scanner was not found");
			
			deviceDescriptor = deviceList.getDeviceDescriptor(0);
			scanner = new Scanner(deviceDescriptor);
			
			System.out.println("-----Scan first finger-----");
			//scanning first finger
            finger1Impression1 = SamplesRunner.ScanImage(scanner);
            finger1Impression2 = SamplesRunner.ScanImage(scanner);
            finger1Impression3 = SamplesRunner.ScanImage(scanner);  
            
            imageSet = new ImageSet(); 
            imageSet.addImage(finger1Impression1, FingerCode.Unknown);
            imageSet.addImage(finger1Impression2, FingerCode.Unknown);
            imageSet.addImage(finger1Impression3, FingerCode.Unknown);

            //creation template from first finger
            imgPrc = new ImageProcessor();               
            System.out.println("\n" + "Creation template from scaned images");
            templ = imgPrc.createTemplate(imageSet);
            //saving template to buffer
            byte[] bufferTemplate1 = templ.toArray();               
            
            
            System.out.println("\n" + "-----Scan second finger----");
            //scanning second finger
            finger2 = SamplesRunner.ScanImage(scanner);

            imageSet.clear();
            imageSet.addImage(finger2, FingerCode.Unknown);
            
            //creation template from second finger
            System.out.println("\n" + "Creation template from scaned images");
        	template2 = imgPrc.createTemplate(imageSet);
        	
        	//loading first template from buffer
            template1 = new Template();
            template1.load(bufferTemplate1);
            
            //matching templates
            matcher = new Matcher();
            System.out.println("\n" + "Matching templates");
            int score = matcher.compare(template1, template2);
            System.out.println("Matching score " + score);            
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if (matcher != null)
				matcher.dispose();
			if (template2 != null)
				template2.dispose();
			if (template1 != null)
				template1.dispose();
			if (finger2 != null)
				finger2.dispose();
			if (templ != null)
				templ.dispose();
			if (imgPrc != null)
				imgPrc.dispose();
			if (imageSet != null)
				imageSet.dispose();
			if (finger1Impression3 != null)
				finger1Impression3.dispose();
			if (finger1Impression2 != null)
				finger1Impression2.dispose();
			if (finger1Impression1 != null)
				finger1Impression1.dispose();
			if (scanner != null)
				scanner.dispose();
			if (deviceDescriptor != null)
				deviceDescriptor.dispose();
			if (deviceList != null)
				deviceList.dispose();
			if (license != null)
				license.dispose();
		}
	}
}
