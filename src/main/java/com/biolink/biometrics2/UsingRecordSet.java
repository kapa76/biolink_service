package com.biolink.biometrics2;



public class UsingRecordSet
{
	public UsingRecordSet()
	{
	}
	
	public void RunSample()
	{	
		License license = null;
		DeviceList deviceList = null;
		DeviceDescriptor deviceDescriptor = null;
		Scanner scanner = null;
		Image image1 = null;
		Template template1 = null;
		ImageSet imageSet = null;
		ImageProcessor imgPrc = null;
		TemplateSet templateSet = null;
		Image image2 = null;
		Template template2 = null;
		Matcher matcher = null;
		IdentifyInfoSet infoSet = null;
		IdentifyInfo identifyInfo = null;
		try
		{
			license = new License();
			
			deviceList = new DeviceList(DeviceType.AnyScanner);
			if (deviceList.getSize() == 0)
                throw new Exception("Scanner was not found");
			
			deviceDescriptor = deviceList.getDeviceDescriptor(0);
			scanner = new Scanner(deviceDescriptor);
			
			System.out.println("-----Scan first finger-----");
            image1 = SamplesRunner.ScanImage(scanner);

            imageSet = new ImageSet();            
            imageSet.addImage(image1, FingerCode.Unknown);

            System.out.println("\n" + "Creation template from scaned image");
            imgPrc = new ImageProcessor(); 
            template1 = imgPrc.createTemplate(imageSet);                

            System.out.println("Addition template to templateSet");
            templateSet = new TemplateSet();
            templateSet.addTemplate(template1, 1, "template1");


            System.out.println("\n" + "-----Scan second finger-----");
            image2 = SamplesRunner.ScanImage(scanner);

            imageSet.clear();
            imageSet.addImage(image2, FingerCode.Unknown);

            System.out.println("\n" + "Creation template from scaned image");                    
            template2 = imgPrc.createTemplate(imageSet);

            System.out.println("Addition template to templateSet");
            templateSet.addTemplate(template2, 2, "template2");
            

            System.out.println("\n" + "Identification second template result:");
            matcher = new Matcher();
            infoSet = matcher.identify(template2, templateSet, 600);
            for (int i = 0; i < infoSet.getSize(); i++)
            {
				if (identifyInfo != null)
					identifyInfo.dispose();	

            	identifyInfo = infoSet.getItem(i);               

            	System.out.println("Template id " + identifyInfo.getId() + 
            					   ", number " + identifyInfo.getNumber() +
            					   ", score " + identifyInfo.getScore());
             }
            
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if (identifyInfo != null)
				identifyInfo.dispose();	
			if (infoSet != null)
				infoSet.dispose();
			if (matcher != null)
				matcher.dispose();
			if (template2 != null)
				template2.dispose();
			if (image2 != null)
				image2.dispose();
			if (templateSet != null)
				templateSet.dispose();
			if (imgPrc != null)
				imgPrc.dispose();
			if (imageSet != null)
				imageSet.dispose();
			if (template1 != null)
				template1.dispose();
			if (image1 != null)
				image1.dispose();
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
