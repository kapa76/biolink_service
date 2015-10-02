package com.biolink.biometrics2;



/**
 * Represents collections of the templates where every template is assoctiated with some identifiers.
 */
public class TemplateSet extends Ref  
{
	static {System.loadLibrary("bsdk6x_jni");}
	
	private native int CreateTemplateSet(Object cls);
	private native int AddTemplate(int pTemplateSet, int pTemplate, int id, String number);
	private native int DeleteTemplate(int pTemplateSet, int id);
	private native int Clear(int pTemplateSet);
	
	/**
	 * Initializes new instance of a TemplateSet object.
	 * @throws Exception
	 */
	public TemplateSet() throws Exception
	{	
		Ref cls = new Ref();
		checkResult(CreateTemplateSet(cls));
		this._handle = cls._handle;
	}
	
	/**
	 * Adds template to a given TemplateSet object.
	 * @param template the template object with loaded data
	 * @param id template unique id
	 * @param number template number (can not be unique)
	 * @throws Exception
	 */
	public void addTemplate(Template template, int id, String number) throws Exception
	{		
		checkResult(AddTemplate(this._handle, template._handle, id, number));
	}
	
	/**
	 * Removes template from the given TemplateSet object by its id.
	 * @param id template id
	 * @throws Exception
	 */
	public void deleteTemplate(int id) throws Exception
	{		
		checkResult(DeleteTemplate(this._handle, id));
	}
	
	/**
	 * Removes all templates from the given TemplateSet object.
	 * @throws Exception
	 */
	public void clear() throws Exception
	{		
		checkResult(Clear(this._handle));
	}
}
