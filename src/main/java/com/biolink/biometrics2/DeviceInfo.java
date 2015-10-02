package com.biolink.biometrics2;

/**
 * Represents device information.
 */
public class DeviceInfo extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int GetDeviceType(int pDeviceInfo);
	private native String GetId(int pDeviceInfo);
	private native String GetVendor(int pDeviceInfo);
	private native String GetManufactureDate(int pDeviceInfo);
	private native String GetDeviceVersion(int pDeviceInfo);
	private native String GetEmbeddedSoftwareVersion(int pDeviceInfo);
	
	
	protected DeviceInfo(int handle)
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
	 * Returns device identifier.
	 * @return device identifier
	 */
	public String getId()
	{
		return GetId(this._handle);
	}
	
	/**
	 * Returns device vendor.
	 * @return device vendor
	 */
	public String getVendor()
	{
		return GetVendor(this._handle);
	}
	
	/**
	 * Returns device manufacture date.
	 * @return device manufacture date
	 */
	public String getManufactureDate()
	{
		return GetManufactureDate(this._handle);
	}
	
	/**
	 * Returns device version.
	 * @return device version
	 */
	public String getDeviceVersion()
	{
		return GetDeviceVersion(this._handle);
	}
	
	/**
	 * Returns device software version.
	 * @return device software version
	 */
	public String getEmbeddedSoftwareVersion()
	{
		return GetEmbeddedSoftwareVersion(this._handle);
	}
	
	public void dispose()
	{		
	}

}

