package com.biolink.biometrics2;

import java.io.*;



/**
 * Represents BSDK Image object. Used for load, store and save BMP images data. 
 * The only supported format is 8bpp gray scale.
 */
public class Image extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateImage(Object cls);
	//bsdk6x_Image_SetBits
	private native int LoadImage(int pImage, byte[] buffer);
	private native int GetSizeImage(int pImage);
	private native int SaveImageToBuffer(int pImage, byte[] buffer);	
	private native int SaveImageToFile(int pImage, byte[] buffer);
	private native int ConvertTo24bit(int pImage, Object cls);
	private native int GetExpressQualityImage(int pImage, int score);
	private native int GetSizeWsqImage(int pImage, float bitrate);
	private native int ConvertToWSQ(int pImage, byte[] buffer, float bitrate);
	private native int LoadFromWsqImage(int pImage, byte[] buffer);
	private native int DrawQuality(int pImage, int quality);
	private native int DrawHistogram(int pImage);
	

	protected Image(int handle)
	{
		this._handle = handle;
	} 
	
	/**
	 * Initializes new instance of the Image (with empty image data). 
	 * @throws Exception
	 */
	public Image() throws Exception
	{
		Ref cls = new Ref();
		checkResult(CreateImage(cls));	
		this._handle = cls._handle;
	}
	
	/**
	 * Initializes new instance of the Image. Load bitmap data from the buffer containing .bmp image.
	 * @param buffer byte array containing .bmp image
	 * @throws Exception
	 */
	public Image(byte[] buffer) throws Exception
	{
		Ref cls = new Ref();
		checkResult(CreateImage(cls));
		this._handle = cls._handle;
		checkResult(LoadImage(this._handle, buffer));
	}
	
	/**
	 * Saves Image data in .bmp format to the buffer.
	 * @return the byte array containing .bmp image
	 * @throws Exception
	 */
	public byte[] save() throws Exception
	{	
		int size = GetSizeImage(this._handle);
		
		byte[] buffer = new byte[size];
		checkResult(SaveImageToBuffer(this._handle, buffer));
		return buffer;		
	}
	
	/**
	 * Saves Image data in .bmp format to the file. 
	 * @param path outPut file path
	 * @throws Exception
	 */
	public void save(String path) throws Exception
	{
		byte[] buffer = (path+'\0').getBytes();
		checkResult(SaveImageToFile(this._handle, buffer));	
	}
	
	/**
	 * Reads a block of bytes from the image and writes the data to buffer.
	 * @param buffer the buffer to write data to
	 * @param offset the byte offset in buffer at which to begin writing to this buffer
	 * @param count the maximum number of bytes to write
	 * @throws Exception
	 */
	public void save(byte[] buffer, int offset, int count) throws Exception
	{
		byte[] bufferImage = this.save();
		
		try
		{
			InputStream stream = new ByteArrayInputStream(bufferImage);
			stream.read(buffer, offset, count);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Writes the image data to stream.
	 * @param stream the Stream where the image data will be saved
	 * @throws Exception
	 */
	public void save(OutputStream stream) throws Exception
	{
		byte[] bufferImage = this.save(); 
		
		try
		{
			stream.write(bufferImage);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Creates new Image object with 24 bit bmp image.
	 * @return the newly created Image object that recieves 24 bit bmp image
	 * @throws Exception
	 */
	public Image convertTo24bit() throws Exception
	{
		Ref cls = new Ref();
		checkResult(ConvertTo24bit(this._handle, cls));	
		
		return new Image(cls._handle);
	}
	
	/**
	 * Returns image quality.
	 * @return image quality
	 */
	public int getExpressQuality() 
	{
		return GetExpressQualityImage(this._handle, 8);
	}
	
	/**
	 * Returns image quality. It is less accurate then the quality obtained when creating a template but several times faster. 
     * Use speed parameter to control the method execution speed.
	 * @param speed process speed (2 - 30) the higher the speed the poorer the quality is
	 * @return image quality
	 */
	public int getExpressQuality(int speed) 
	{
		return GetExpressQualityImage(this._handle, speed);
	}
	
	/**
	 * Saves Image data in WSQ format to the buffer.
	 * @param bitrate compression ratio. 0.1 - WSQ conversion minimal bitrate range. It provides best compression rate but lowest image quality.
     * 1 - WSQ conversion maximum bitrate range. It provides best image quality but minimal commpression rate.
     * (0.75 - WSQ conversion default bitrate range. It provides best integral value for image quality and compression rate (recommended by NIST))
	 * @return the byte array containing wsq-image
	 * @throws Exception
	 */
	public byte[] saveToWsq(float bitrate) throws Exception
	{	
		int size = GetSizeWsqImage(this._handle, bitrate); 
		
		byte[] buffer = new byte[size];		
		checkResult(ConvertToWSQ(this._handle, buffer, bitrate));
		return buffer;
	}
	
	/**
	 * Load bitmap data from the buffer containing WSQ image.
	 * @param buffer byte array containing wsq-image
	 * @throws Exception
	 */
	public void loadFromWsqImage(byte[] buffer) throws Exception
	{
		checkResult(LoadFromWsqImage(this._handle, buffer));
	}
	
	/**
	 * Draws quality scale on the image.
	 * @param quality quality
	 * @throws Exception
	 */
	public void drawQuality(int quality) throws Exception
	{
		checkResult(DrawQuality(this._handle, quality));
	}
	
	/**
	 * Draws histogram on the image.
	 * @throws Exception
	 */
	public void drawHistogram() throws Exception
	{
		checkResult(DrawHistogram(this._handle));
	}
}

