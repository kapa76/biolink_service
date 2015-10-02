package com.biolink.biometrics2;

/**
 * Returns results of the one-to-one matching.
 */
public class IdentifyInfo extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int GetScore(int pInfo);
	private native int GetId(int pInfo);
	private native String GetNumber(int pInfo);
	
	
	protected IdentifyInfo(int handle)
	{
		this._handle = handle;
	} 
	
	/**
	 * Returns score of identifying.
	 * @return score of identifying
	 */
	public int getScore() 
	{	
		return GetScore(this._handle);
	}
	
	/**
	 * Returns template id in container.
	 * @return template id in container
	 */
	public int getId()
	{			
		return GetId(this._handle);
	}
	
	/**
	 * Returns template number in container.
	 * @return template number in container
	 */
	public String getNumber() 
	{			
		return GetNumber(this._handle);
	}
}
