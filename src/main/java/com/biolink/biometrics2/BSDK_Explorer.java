package com.biolink.biometrics2;

import com.biolink.biometrics2.*;

public class BSDK_Explorer
{
    static Form _form = null;
    
	public static void main(String[] args)
	{	
		License license = null;
		try
		{
			license = new License();
		
			_form = new Form();
			_form.Initilization();	
			_form.Open();   
		}
		finally
		{
			if (_form != null)
				_form.Dispose();
			if (license != null)
				license.dispose();
		}
	} 
	
}
