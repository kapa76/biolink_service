package com.biolink.biometrics2;

import java.io.*;

/**
 * Template is a set of finger templates (maximum finger templates amount is limited to 10). 
 * Each finger template represents extracted fingerprint features that are used during comparison. 
 * A Template object is a list of Finger objects, which in its turn is a list of Impression objects
 */
public class Template extends Ref 
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateTemplate(Object cls, int mathType);
	private native int LoadTemplate(int pTemplate, byte[] buffer);
	private native int SaveTemplate(int pTemplate, byte[] buffer, int size);
	private native int GetQualityTemplate(int pTemplate);	
	private native int GetSizeTemplate(int pTemplate);	
	private native int AddTemplate(int pDstTemplate, int pSrcTemplate);
	private native int GetFingerCount(int pTemplate);
	private native int GetFinger(Object cls, int pTemplate, int index);	
	private native int DeleteFinger(int pTemplate, int index);
	
	
	protected Template(int handle)
	{
		this._handle = handle;
	} 
	
	/**
	 * Initializes new instance of the Template.
	 * @throws Exception
	 */
	public Template() throws Exception
	{	
		Ref cls = new Ref();
		checkResult(CreateTemplate(cls, 0));
		this._handle = cls._handle;
	}
	
	private int mathType;
	/**
	 * Initializes new instance of the Template according to the asked math type.
	 * @param type type of the template to be created
	 * @throws Exception
	 */
	public Template(MathType type) throws Exception
	{
		switch (type) 
		{
			case BIOLINK:   mathType = 0; break;
			case INCITS378: mathType = 1; break;			
		}
		Ref cls = new Ref();
		checkResult(CreateTemplate(cls, mathType));
		this._handle = cls._handle;
	}
	
	/**
	 * Initializes a new instance of the Template based on the specified byte array.
	 * @param data input buffer
	 * @throws Exception
	 */
	public Template(byte[] data) throws Exception
	{
		Ref cls = new Ref();
		checkResult(CreateTemplate(cls, 0));
		this._handle = cls._handle;
		
		this.load(data);
	}
	
	/**
	 * Initializes a new instance of the Template based on the specified byte array according to the asked math type.
	 * @param type type of the template to be created 
	 * @param data input buffer
	 * @throws Exception
	 */
	public Template(MathType type, byte[] data) throws Exception
	{
		switch (type) 
		{
			case BIOLINK:   mathType = 0; break;
			case INCITS378: mathType = 1; break;			
		}
		Ref cls = new Ref();
		checkResult(CreateTemplate(cls, mathType));
		this._handle = cls._handle;
		
		this.load(data);
	}
	
	/**
	 * Load Template object data from the buffer.
	 * @param buffer input buffer
	 * @throws Exception
	 */
	public void load(byte[] buffer) throws Exception
	{
		checkResult(LoadTemplate(this._handle, buffer));
	}
	
	/**
	 * Write Template data to the buffer.
	 * @return the byte array containing template data
	 * @throws Exception
	 */
	public byte[] toArray() throws Exception
	{
		int size = GetSizeTemplate(this._handle);
		byte[] buffer = new byte[size]; 
		checkResult(SaveTemplate(this._handle, buffer, size));
		return buffer;
	}
	
	/**
	 * Reads a block of bytes from the template and writes the data to buffer.
	 * @param buffer the buffer to write data to
	 * @param offset the byte offset in buffer at which to begin writing to this buffer
	 * @param count the maximum number of bytes to write
	 * @throws Exception
	 */
	public void save(byte[] buffer, int offset, int count) throws Exception
	{
		byte[] bufferTemplate = this.toArray();
		
		try
		{
			InputStream stream = new ByteArrayInputStream(bufferTemplate);
			stream.read(buffer, offset, count);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Returns integrated template quality.
	 * @return integrated template quality
	 */
	public int getQuality()
	{
		return GetQualityTemplate(this._handle);
	}
	
	/**
	 * Returns sise of the Template object.
	 * @return sise of the Template object
	 */
	public int getSize()
	{
		return GetSizeTemplate(this._handle);
	}
	
	/**
	 * Merges two templates.
	 * @param sourceTemplate the template, from where finger templates will be copied
	 * @throws Exception
	 */
	public void addTemplate(Template sourceTemplate) throws Exception
	{
		checkResult(AddTemplate(this._handle, sourceTemplate._handle));
	} 
	
	/**
	 * Returns number of Finger objects in a Template object.
	 * @return number of Finger objects in a Template object
	 */
	public int getFingerCount()
	{
		return GetFingerCount(this._handle);
	}
	
	/**
	 * Returns a Finger object from a Template object.
	 * @param index number of finger templates
	 * @return Finger object
	 */
	public Finger getFinger(int index) throws Exception {
		Ref cls = new Ref();
		GetFinger(cls, this._handle, index);
		
		if (cls._handle == 0)
			throw new Exception("Finger does not exist");
		else
			return new Finger(cls._handle); 		
	}
		
	private int fingerCode;
	/**
	 * Deletes finger template from template by its index.
	 * @param finger index of the finger template to be deleted
	 * @throws Exception
	 */
	public void deleteFinger(FingerCode finger) throws Exception
	{
		switch (finger)
		{
			case Unknown:      fingerCode = 0;  break;
			case RightThumb:   fingerCode = 1;  break;
			case RightIndex:   fingerCode = 2;  break;
			case RightMiddle:  fingerCode = 3;  break;
			case RightRing:    fingerCode = 4;  break;
			case RightLittle:  fingerCode = 5;  break;
			case LeftThumb:    fingerCode = 6;  break;
			case LeftIndex:    fingerCode = 7;  break;
			case LeftMiddle:   fingerCode = 8;  break;
			case LeftRing:     fingerCode = 9;  break;
			case LeftLittle:   fingerCode = 10; break;
		}
		
		checkResult(DeleteFinger(this._handle, fingerCode));
	}	
}

