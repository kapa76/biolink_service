package com.biolink.biometrics2;



/**
 * Represents collection of the BSDK Image objects. It should be used during template creation and can hold fingerprint images of
 * the same finger (different impressions of the same finger) as well as fingerprint images of different fingers. 
 */
public class ImageSet extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateImageSet(Object cls);
	private native int AddImageToImageSet(int pImageSet, int pImage, int finger);
	private native void ClearImageSet(int pImageSet);
	
	
	/**
	 * Initializes new instance of the ImageSet.
	 * @throws Exception
	 */
	public ImageSet() throws Exception
	{
		Ref cls = new Ref();
		checkResult(CreateImageSet(cls));
		this._handle = cls._handle;
	}
	
	private int fingerCode;
	/**
	 * Adds fingerprint image to the given ImageSet object.
	 * @param image the Image object with fingerprint image
	 * @param iFinger finger index
	 * @throws Exception
	 */
	public void addImage(Image image, FingerCode iFinger) throws Exception
	{
		switch (iFinger)
		{
			case Unknown:     fingerCode = 0; break;
			case RightThumb:  fingerCode = 1; break;
			case RightIndex:  fingerCode = 2; break;
			case RightMiddle: fingerCode = 3; break;
			case RightRing:   fingerCode = 4; break;
			case RightLittle: fingerCode = 5; break;
			case LeftThumb:   fingerCode = 6; break;
			case LeftIndex:   fingerCode = 7; break;
			case LeftMiddle:  fingerCode = 8; break;
			case LeftRing:    fingerCode = 9; break;
			case LeftLittle:  fingerCode = 10; break;
		}
		checkResult(AddImageToImageSet(this._handle, image._handle, fingerCode));
	}
	
	/**
	 * Removes all images from the given image set.
	 */
	public void clear()
	{
		ClearImageSet(this._handle);
	}	
}


