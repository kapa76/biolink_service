package com.biolink.biometrics2;

/**
 * Initializes available BSDK license. Must be created before any of the BSDK objects. 
 * Otherwise no protected operations will work.
 */
public class License extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}	
	
	private native int CreateLicense(int licenseType);
	private native void CloseLicense();
	private native int CheckLicense(int productId, int featureId);
	
	
	private int FUTRONIC     = 0x00000001;
    private int RAINBOW      = 0x00000002;
    private int HARDWARE     = 0x00000004;
    private int SENTINEL_SHK = 0x00000008;
    private int ALL 		 = 0x000000FF;	
	
    /**
     * Initializes License object.
     * @throws Exception
     */
	public License() throws Exception
	{	
		checkResult(CreateLicense(ALL));
	}
	
	private int licenseType;
	/**
	 * Initializes License object.
	 * @param type type of license to be enumerated. It can be any combination of LicenseType enumerator values.
	 * @throws Exception
	 */
	public License(LicenseType type) throws Exception
	{		
		switch (type)
		{
			case FUTRONIC:   	licenseType = FUTRONIC; 	break;
			case RAINBOW:   	licenseType = RAINBOW; 		break;
			case HARDWARE:   	licenseType = HARDWARE; 	break;
			case SENTINEL_SHK:  licenseType = SENTINEL_SHK; break;
			case ALL:   		licenseType = ALL; 			break;					
		}
		checkResult(CreateLicense(licenseType));
	}
	
	/**
	 * Check granted permissions.
	 * @param featureId license feature
	 * @return true if the license is available; false if the license is not available
	 * @throws Exception
	 */
	public boolean check(FeatureId featureId) throws Exception
	{
		return check(ProductId.General, featureId);
	}
	
	private int productId;
	private int featureId;
	/**
	 * Check granted permissions.
	 * @param productId license product type
	 * @param featureId license feature
	 * @return true if the license is available; false if the license is not available
	 * @throws Exception
	 */
	public boolean check(ProductId productId, FeatureId featureId) throws Exception
    {
		switch (productId)
		{
			case General:   this.productId = 0; break;			
		}		
		
		switch (featureId)
		{
			case ScanApi:          this.featureId = 0; break;
			case MatcherApi:       this.featureId = 1; break;
			case ImageProcApi:     this.featureId = 2; break;	
			case WSQApi:           this.featureId = 3; break;
			case FingerPassIC_Api: this.featureId = 4; break;
		}
		
		int res = checkResultLicense(CheckLicense(this.productId, this.featureId));
        if (res == -12)
            return false;
        else return true;
    }
	
	/**
	 * Destroys license object.
	 */
	public void dispose()
	{		
		CloseLicense();
	}
}


