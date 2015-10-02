package com.biolink.biometrics2;

public class MultiFinger
{
	public MultiFinger()
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
		Image image2 = null;
		Template template2 = null;
		Finger finger = null;
		Matcher matcher = null;
		try
		{
			license = new License();
			
			deviceList = new DeviceList(DeviceType.AnyScanner);
			if (deviceList.getSize() == 0)
                throw new Exception("Scanner was not found");
			
			deviceDescriptor = deviceList.getDeviceDescriptor(0);
			scanner = new Scanner(deviceDescriptor);
			
			System.out.println("-----Scan finger with fingerCode leftIndex-----");
            image1 = SamplesRunner.ScanImage(scanner);

            imageSet = new ImageSet();
            imageSet.addImage(image1, FingerCode.LeftIndex);

            System.out.println("\n" + "Creation template from scaned image");
            imgPrc = new ImageProcessor();                
            template1 = imgPrc.createTemplate(imageSet);
            
            
            System.out.println("\n" + "-----Scan finger with fingerCode leftLittle-----");
            image1 = SamplesRunner.ScanImage(scanner);

            imageSet.clear();
            imageSet.addImage(image1, FingerCode.LeftLittle);

            System.out.println("\n" + "Creation template from scaned image");
            imgPrc = new ImageProcessor();                
            template2 = imgPrc.createTemplate(imageSet);
            
            
            System.out.println("\n" + "Creation multifinger template from both templates");
            template1.addTemplate(template2);

            int fingerCount = template1.getFingerCount();
            System.out.println("\n" + "Count of fingers in creates multifinger template - " + fingerCount);

            finger = template1.getFinger(1);
            System.out.println("Index of second finger in multifinger template - " + finger.getIndex());

            matcher = new Matcher();            
            int score = matcher.compare(template1, template2);
            System.out.println("Matching score multifinger template and second template - " + score);            

            System.out.println("Deleting finger with fingerCode leftLittle from multifinger template");
            template1.deleteFinger(FingerCode.LeftLittle);
            
            score = matcher.compare(template1, template2);
            System.out.println("Matching score multifinger template and second template after deleting - " + score);                      
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if (matcher != null)
				matcher.dispose();
			if (finger != null)
				finger.dispose();
			if (template2 != null)
				template2.dispose();
			if (image2 != null)
				image2.dispose();
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
