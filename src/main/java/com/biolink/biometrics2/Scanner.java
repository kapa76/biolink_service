package com.biolink.biometrics2;

import org.eclipse.swt.*;

/**
 * Represents scanner device that is used to capture fingerprint images.
 */
public class Scanner extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateScanner(Object cls, int pDeviceDescriptor);
	private native int GetDeviceInfo(Object cls, int pScanner);
	private native int AcquireImage(int pScanner, Object cls);
	private native int AcquireFinger(int pScanner, int pImage, int timeOut);
	
	
	/**
	 * Intializes new instance of the scanner based on the given descriptor.
	 * @param deviceDescriptor the DeviceDescriptor object
	 * @throws SWTException
	 */
	public Scanner(DeviceDescriptor deviceDescriptor)throws SWTException
	{			
		Ref cls = new Ref();
		checkResult(CreateScanner(cls, deviceDescriptor._handle));
		this._handle = cls._handle;
	}
	
	/**
	 * Returns device info.
	 * @return device info
	 */
	public DeviceInfo getDeviceInfo()
	{
		Ref cls = new Ref();
		GetDeviceInfo(cls, this._handle);
		return new DeviceInfo(cls._handle); 
	}
	
	/**
	 * Returns scanned bmp image (8bit gray scale).
	 * @return scanned bmp image
	 * @throws SWTException
	 */
	public Image acquireImage() throws SWTException
	{		
		Ref cls = new Ref();
		checkResult(AcquireImage(this._handle, cls));	
		
		return new Image(cls._handle);
	}	

	/**
	 * Not supported.
	 */
	public void acquireFinger(Image image, int timeOut) throws SWTException
	{
		checkResult(AcquireFinger(this._handle, image._handle, timeOut));
	}	
}

