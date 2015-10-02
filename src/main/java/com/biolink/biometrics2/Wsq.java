package com.biolink.biometrics2;

public class Wsq
{
	public Wsq()
	{
	}
	
	public void RunSample()
	{	
		License license = null;
		DeviceList deviceList = null;
		DeviceDescriptor deviceDescriptor = null;
		Scanner scanner = null;
		Image image = null;
        Image imageFromWsq = null;
        ImageSet imageSet = null;
        ImageProcessor imgPrc = null;
        Template template = null;
		try
		{
			license = new License();
			
			deviceList = new DeviceList(DeviceType.AnyScanner);
			if (deviceList.getSize() == 0)
                throw new Exception("Scanner was not found");
			
			deviceDescriptor = deviceList.getDeviceDescriptor(0);
			scanner = new Scanner(deviceDescriptor);			
			
			image = SamplesRunner.ScanImage(scanner);
			
			System.out.println("Conversion scaned image to wsq image");
            byte[] wsqImage = image.saveToWsq(0.75F);
            
            System.out.println("Conversion wsq image to bmp image");
            imageFromWsq = new Image();
            imageFromWsq.loadFromWsqImage(wsqImage);

            int expressQuality = imageFromWsq.getExpressQuality();
            System.out.println("Converted image quality " + expressQuality);

            System.out.println("Creation template from converted image");
            imageSet = new ImageSet();            
            imageSet.addImage(imageFromWsq, FingerCode.Unknown);

            imgPrc = new ImageProcessor();            
            template = imgPrc.createTemplate(imageSet);
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if (template != null)
				template.dispose();
			if (imgPrc != null)
				imgPrc.dispose();
			if (imageSet != null)
				imageSet.dispose();
			if (imageFromWsq != null)
				imageFromWsq.dispose();
			if (image != null)
				image.dispose();
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
