package com.biolink.biometrics2;

/**
 * Types of devices.
 */
public enum DeviceType
{
	/**
	 * Any devices (not only scanner, added for future usage)
	 */
	AnyDevice,
	
	/**
	 * Any of the supported scanner devices
	 */
    AnyScanner,
	
	/**
	 * U-Match 3.5 scanner device
	 */
    UmatchScanner,
	
	/**
	 * Upeck scanner device
	 */
    Upek,
	
	/**
	 * CrossMatch scanner device
	 */
    CrossMatch;
}

