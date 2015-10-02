package com.biolink.biometrics2;

/**
 * Represents device descriptor that is unique for every devices. 
 * It is used to create and open a particular device.
 */
public class DeviceDescriptor extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int GetDeviceType(int pDeviceDescriptor);
	private native String GetDeviceInstanceId(int pDeviceDescriptor);
	
	
	protected DeviceDescriptor(int handle)
	{
		this._handle = handle;
	}
	
	/**
	 * Returns device type.
	 * @return device type
	 */
	public DeviceType getDeviceType()
	{
		int deviceType = GetDeviceType(this._handle);

		if (deviceType == 0x0100)
			return DeviceType.AnyScanner;
		if (deviceType == 0x0101)
			return DeviceType.UmatchScanner;
		if (deviceType == 0x0102)
			return DeviceType.Upek;
		if (deviceType == 0x0103)
			return DeviceType.CrossMatch;
		else return DeviceType.AnyDevice;
	}
	
	/**
	 * Returns device instance identifier.
	 * @return device instance identifier
	 */
	public String getDeviceInstanceId()
	{
		return GetDeviceInstanceId(this._handle);
	}	
	
	public void dispose()
	{		
	}
	
}
