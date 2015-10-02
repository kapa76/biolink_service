package com.biolink.biometrics2;


/**
 * Represents a collection of IdentifyInfo objects.
 */
public class IdentifyInfoSet extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int GetSize(int pIdentifyInfoSet);
	private native int GetItem(Object cls, int pIdentifyInfoSet, int index);
	
		
	protected IdentifyInfoSet(int handle)
	{
		this._handle = handle;
	}
	
	/**
	 * Returns number of items in the set.
	 * @return number of items in the set
	 */
	public int getSize() 
	{	
		return GetSize(this._handle);
	}
	
	/**
	 * Returns item from the set.
	 * @param index item index
	 * @return item from the set
	 * @throws Exception
	 */
	public IdentifyInfo getItem(int index) throws Exception
	{	
		Ref cls = new Ref();
		checkResult(GetItem(cls, this._handle, index));
		return new IdentifyInfo(cls._handle); 
	}
}
