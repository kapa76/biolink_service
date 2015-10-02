package com.biolink.biometrics2;

import org.eclipse.swt.*;

/**
 * Represents all functionality that is neccesary to compare templates. 
 * Use Compare method to perform one-to-one mathing. It is better to use Idenify method to compare within large number of templates since 
 * it can be configured to use all CPU cores simultaneously. 
 */
public class Matcher extends Ref
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateMatcher(Object cls, int mathType, int threadCount);
	private native int CompareTemplates(Object cls, int pMatcher, int pTemplate1, int pTemplate2);	
	private native int Identify(Object cls, int pMatcher, int pTemplate, int pTemplateSet, int minScore);
	
	
	/**
	 * Initializes new instance of a Matcher object based on the BIOLINK math type.
	 * @throws SWTException
	 */
	public Matcher() throws SWTException
	{	
		Ref cls = new Ref();
		checkResult(CreateMatcher(cls, 0, 0));
		this._handle = cls._handle;
	}
	
	private int mathType;
	/**
	 * Initializes new instance of a Matcher object based on the given math type.
	 * @param type type of the matcher to be created
	 * @throws SWTException
	 */
	public Matcher(MathType type) throws SWTException
	{	
		switch (type)
		{
			case BIOLINK:   mathType = 0; break;
			case INCITS378: mathType = 1; break;			
		}
		Ref cls = new Ref();
		checkResult(CreateMatcher(cls, mathType, 0));
		this._handle = cls._handle;
	}
	
	/**
	 * Initializes new instance of a Matcher object based on the given math type.
	 * @param type type of the matcher to be created
	 * @param threadCount number of threads to be used for simultaneous comparison in the Identify method (if 0, thread count equals number of processors)
	 * @throws SWTException
	 */
	public Matcher(MathType type, int threadCount) throws SWTException
	{	
		switch (type)
		{
			case BIOLINK:   mathType = 0; break;
			case INCITS378: mathType = 1; break;			
		}
		Ref cls = new Ref();
		checkResult(CreateMatcher(cls, mathType, threadCount));
		this._handle = cls._handle;
	}
	
	/**
	 * Performs matching of the two templates. Score value range depends on the math type.
	 * @param template1 the first Template object
	 * @param template2 the second Template object
	 * @return score value
	 * @throws SWTException
	 */
	public int compare(Template template1, Template template2) throws SWTException
	{
		Ref cls = new Ref();
		checkResult(CompareTemplates(cls, this._handle, template1._handle, template2._handle));
		return cls._score;
	}
	
	/**
	 * Performs template identification within given TemplateSet. 
     * The result will be IdentifyInfoSet objects, which will contain matching results with scores higher than given minimal score.
	 * @param template the Template object
	 * @param templateSet the TemplateSet object
	 * @param minScore minimal score
	 * @return IdentifyInfoSet objects, which will contain matching results with scores higher than given minimal score
	 * @throws SWTException
	 */
	public IdentifyInfoSet identify(Template template, TemplateSet templateSet, int minScore) throws SWTException
	{
		Ref cls = new Ref();
		checkResult(Identify(cls, this._handle, template._handle, templateSet._handle, minScore));
		return new IdentifyInfoSet(cls._handle); 
	}

}

