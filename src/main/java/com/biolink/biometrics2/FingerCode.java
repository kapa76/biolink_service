package com.biolink.biometrics2;

/**
* Types of the fingerprint indexes. 
* Every fingerprint index in the template should be equal to one of the described types. 
* Math compares fingerprints with the same index only.
* Please note, that FingerCode Unknown has a special meaning. 
* Fingerprint with such index will be compared against fingerprint with any index.
*/
public enum FingerCode
{	
	/**
	 * Unknown finger
	 */
	Unknown,
	
	/**
	 * Right hand thumb finger 
	 */
    RightThumb,
	
	/**
	 * Right hand index finger 
	 */
    RightIndex,
	
	/**
	 * Right hand middle finger
	 */
    RightMiddle,
	
	/**
	 * Right hand ring finger
	 */
    RightRing,
	
	/**
	 * Right hand little finger
	 */
    RightLittle,
	
	/**
	 * Left hand thumb finger
	 */
    LeftThumb,
	
	/**
	 * Left hand index finger
	 */
    LeftIndex,
	
	/**
	 * Left hand middle finger
	 */
    LeftMiddle,
	
	/**
	 * Left hand ring finger
	 */
    LeftRing,
	
	/**
	 * Left hand little finger
	 */
    LeftLittle;
}

