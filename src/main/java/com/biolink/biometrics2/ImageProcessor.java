package com.biolink.biometrics2;

/**
 * Represents all functionality that is neccesary to create a Template object from images.
 */
public class ImageProcessor extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateImageProcessor(Object cls, int mathType);
	private native int CreateTemplateFromImageSet(Object cls, int pImageProcessor, int pImageSet);	
	
	
	/**
	 * Intializes new instance of the ImageProcessor object based on the BIOLINK math type.
	 * @throws Exception
	 */
	public ImageProcessor() throws Exception
	{	
		Ref cls = new Ref();
		checkResult(CreateImageProcessor(cls, 0));
		this._handle = cls._handle;
	}

	private int mathType;
	/**
	 * Intializes new instance of the ImageProcessor object based on the given math type.
	 * @param type type of the ImageProcessor object to be created
	 * @throws Exception
	 */
	public ImageProcessor(MathType type) throws Exception
	{	
		switch (type)
		{
			case BIOLINK:   mathType = 0; break;
			case INCITS378: mathType = 1; break;			
		}
		Ref cls = new Ref();
		checkResult(CreateImageProcessor(cls, mathType));
		this._handle = cls._handle;
	}
	
 	/**
 	 * Create fingerprint template from the given ImageSet object.
 	 * @param imageSet the ImageSet object with fingerprint images from which to create template
 	 * @return created template
 	 * @throws Exception
 	 */
	public Template createTemplate(ImageSet imageSet) throws Exception
	{
		Ref cls = new Ref();
		checkResult(CreateTemplateFromImageSet(cls, this._handle, imageSet._handle));
		return new Template(cls._handle); 		
	} 
}

