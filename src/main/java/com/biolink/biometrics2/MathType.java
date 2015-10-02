package com.biolink.biometrics2;

/**
* Maths types supported by BSDK. 
* Please note, that Template, ImageProcessor, Matcher, TemplateSet work correctly only within one math type. 
* For example, do not use Incits378 template with BioLink matcher and so on.
*/
public enum MathType
{
	/**
	 * Base BioLink algorithm. It provides best accuracy and matching speed for PC plathform
	 */
	BIOLINK,
	
	/**
	 * BioLink INCITS 378 implementation algorithm. It provides the same accuracy as BioLink base algorithm but has low matching speed
	 */
    INCITS378;
}

