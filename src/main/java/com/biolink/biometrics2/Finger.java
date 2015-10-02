package com.biolink.biometrics2;

/**
 * Represents finger template.
 */
public class Finger extends Ref 
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int GetIndex(int pFinger);
	private native int GetImpressionCount(int pFinger);
	private native int GetImpression(Object cls, int pFinger, int index);
	private native int GetTemplateSize(int pFinger);
	private native int SaveTemplate(int pFinger, byte[] buffer, int size);
	
	
	protected Finger(int handle)
	{
		this._handle = handle;
	}
	
	/**
	 * Returns finger index.
	 * @return finger index
	 */
	public FingerCode getIndex()
	{
		int fingerCode = GetIndex(this._handle);		
		
		if (fingerCode == 1)
			return FingerCode.RightThumb;
		if (fingerCode == 2)
			return FingerCode.RightIndex;
		if (fingerCode == 3)
			return FingerCode.RightMiddle;
		if (fingerCode == 4)
			return FingerCode.RightRing;
		if (fingerCode == 5)
			return FingerCode.RightLittle;
		if (fingerCode == 6)
			return FingerCode.LeftThumb;
		if (fingerCode == 7)
			return FingerCode.LeftIndex;
		if (fingerCode == 8)
			return FingerCode.LeftMiddle;
		if (fingerCode == 9)
			return FingerCode.LeftRing;
		if (fingerCode == 10)
			return FingerCode.LeftLittle;
		else
			return FingerCode.Unknown;
	}
	
	/**
	 * Returns number of impressions in finger template.
	 * @return number of impressions in finger template
	 */
	public int getImpressionCount()
	{
		return GetImpressionCount(this._handle);
	}
	
/*	public Impression GetImpression(int index)
	{
		Ref cls = new Ref();
		GetImpression(cls, this._handle, index);
		return new Impression(cls._handle); 
	} */
	
	/**
	 * Writes finger template to the buffer.
	 * @return the byte array containing template data. 
	 */
	public byte[] saveTemplate() throws Exception
	{
		int size = GetTemplateSize(this._handle);
		byte[] buffer = new byte[size]; 
		checkResult(SaveTemplate(this._handle, buffer, size));
		return buffer;
	}
	
	public void dispose()
	{
	}
}
