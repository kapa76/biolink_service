package com.biolink.biometrics2;

/**
* There are several license types depending on the platform.
*/
public enum LicenseType 
{
	/**
	 * License installed to U-Match scanner (license embedded in the U-Match scanner, allows BSDK operations on the computer, to which this scanner is attached)
	 */
	FUTRONIC,
	
	/**
	 * License installed to sentinel USB dongle (license embedded in the Sentinel USB dongle, can be of two types: local (for one computer, which this dongle is attached to) 
     * and network (one computer in the local network serves as a license server and distributes the license to other computers (number of allowed simultaneous connections and other restrictions/permissions are stated in the BSDK EULA for particular customer)
	 */
    RAINBOW,
	
	/**
	 * License installed to PC (license generated for the computer, on which BSDK applications will be launched. 
     * This license uses this computers' hardware identifier to generate the license, thus this license is valid only for the computer, which hardware id was used to generate this license
	 */
    HARDWARE,
	
	/**
	 * License installed to sentinel SHK USB dongle (license embedded in the Sentinel SHK USB dongle
	 */
    SENTINEL_SHK,
	
	/**
	 * Any license source
	 */
    ALL;
}
