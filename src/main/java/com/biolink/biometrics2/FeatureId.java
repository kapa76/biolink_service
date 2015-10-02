package com.biolink.biometrics2;

/**
 * Possible protected features. BSDK license is a set of these features.
 */
public enum FeatureId 
{
	/**
	 * Scanning API
	 */
	ScanApi,
	
	/**
	 * Comparing API 
	 */	
    MatcherApi, 
    

	/**
	 * Template creation API
	 */
    ImageProcApi,
    
    /**
	 * WSQ conversation API 
	 */	
    WSQApi, 
    
    /**
	 * FingerPassIC math API 
	 */	
    FingerPassIC_Api;
}
