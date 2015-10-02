package com.biolink.biometrics2;



/**
 * Represents list of the descriptors of scanner devices connected to PC. 
 * It is possible to enumerate either all devices or only specified types.
 */
public class DeviceList extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateDeviceList(Object cls, int deviceType);
	private native int GetSizeDeviceList(int pDeviceList);
	private native int GetDeviceDescriptor(Object cls, int pDeviceList, int deviceListIndex);
	
	
	/**
	 * Initializes list of devices.
	 * @throws Exception
	 */
	public DeviceList() throws Exception
	{	
		Ref cls = new Ref();		
		checkResult(CreateDeviceList(cls, 0x0000));
		this._handle = cls._handle; 
	}	
	
	private int deviceType; 
	/**
	 * Initializes list of devices of the specified type.
	 * @param type type of devices to be enumerated. It can be any combination of DeviceType enumerator values 
	 * @throws Exception
	 */
	public DeviceList(DeviceType type) throws Exception
	{	
		switch (type)
		{
			case AnyDevice:   	deviceType = 0x0000; break;
			case AnyScanner: 	deviceType = 0x0100; break;
			case UmatchScanner: deviceType = 0x0101; break;	
			case Upek: 			deviceType = 0x0102; break;
			case CrossMatch: 	deviceType = 0x0103; break;
		}
		Ref cls = new Ref();		
		checkResult(CreateDeviceList(cls, deviceType));
		this._handle = cls._handle; 
	}
	
	/**
	 * Returns number of devices in the list.
	 * @return number of devices in the list
	 */
	public int getSize()
	{
		return GetSizeDeviceList(this._handle);
	}
	
	/**
	 * Returns device descriptor from the list.
	 * @param deviceListIndex item index
	 * @return device descriptor from the list
	 */
	public DeviceDescriptor getDeviceDescriptor(int deviceListIndex)
	{
		Ref cls = new Ref();
		GetDeviceDescriptor(cls, this._handle, deviceListIndex);
		return new DeviceDescriptor(cls._handle); 	
	}

}
