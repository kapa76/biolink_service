package com.biolink.biometrics2;

import java.io.*;

import com.biolink.biometrics2.*;

public class Form 
{
	/*
	Display _display 		  = null;
	Shell   _shell 			  = null; 
	Group   _groupMaths 	  = null;
	Combo   _comboBoxMaths    = null;
	Group   _groupScanners 	  = null;
	Combo   _comboBoxScanners = null;
	Button  _btnOpenDevice 	  = null;
	Group   _groupScanDevice  = null;
	Button  _btnAcquireImage  = null;
	Button  _checkBoxLoopScan = null;
	Slider _brightness        = null;
	Slider _contrast          = null;
	Slider _gain              = null;
	Group   _groupDeviceInfo  = null;
	Label _id                      = null;
	Label _vendor                  = null;
	Label _manufactureDate         = null;
	Label _deviceVersion 		   = null;
	Label _embeddedSoftwareVersion = null;
	Label _deviceType 			   = null;
	MessageBox _messageBox    = null;
	Group      _groupImage    = null;
	Canvas     _canvas        = null;
	Link 	   _linkSave      = null;
	Link       _linkLoad      = null;
	Link       _linkZoom      = null;
	Group _groupImageProcessor = null;
	Label _expressQuality      = null;
	Button _btnCreateTemplate  = null;
	Group _groupImageDrawer    = null;
	PaintListener _paintListener   = null;
	Button  _checkBoxDrawQualityEx = null;
	Button  _checkBoxDrawMinutiae  = null;
	Button  _checkBoxDrawDirectionField= null;
	Label _widthImage 	 = null;
	Label _heightImage 	 = null;
	Label _bppImage 	 = null;
	Label _hDpiImage 	 = null;
	Label _vDpiImage 	 = null;
	Label _lineSizeImage = null;
	Group _groupTemplate = null;	
	Label _fingerCode 	 = null;
	Label _minutiaeCount = null;
	Label _quality 	     = null;
	Label _area 	     = null;
	Label _location 	 = null;
	Label _deltaCent 	 = null;
	Label _imageTransform 	   = null;
	Label _asimmetry 	 = null;
	Label _deformation 	 = null;	
	Link  _linkSaveTemplate    = null;
	Link  _linkLoadTemplate    = null;
	Group _groupTemplateList   = null;
	Table _table         = null;
	Button _btnRemoveTemplate  = null;
	Button _btnAddTemplate     = null;
	Group  _groupMatcher       = null;
	Combo   _comboBoxSpeed     = null;
	Combo   _comboBoxSecurityLevel = null;
	Button _btnCompare   = null;
	Group  _groupMatchInfo     = null;
	Label  _match        = null;
	Label  _score        = null;
	
	DeviceList 		 _deviceList 	   = null;
    DeviceDescriptor _deviceDescriptor = null;
    Scanner 		 _scanner 		   = null;
    com.biolink.biometrics2.Image _image = null;
    ImageSet 		 _imageSet 		   = null;
    ImageProcessor   _imgPrc           = null;
    Template 		 _template         = null;
    Matcher 		 _matcher 		   = null;    
    MathType 		 _math             = null;
	
    String _fileName;
    
	public void Initilization()
	{
		_display = new Display();
	    _shell = new Shell(_display, SWT.CLOSE | SWT.MIN);
	    _shell.setText("BSDK Explorer");
	    _shell.setSize(650, 500); 
	    
	    _messageBox = new MessageBox(_shell);
	    //----------------------------------------------------------------
	    Color color = new Color(_display, 180, 180, 180);	    
	    
	    //Panel Math (Step: 1)
	    _groupMaths = new Group(_shell, SWT.NONE);
	    _groupMaths.setText("Math (Step: 1)");	    
	    _groupMaths.setBounds(8, 8, 208, 67);
	    _groupMaths.setBackground(color);
	    //Label
	    Label labelMathType = new Label(_groupMaths, SWT.NONE);
	    labelMathType.setText("Math types:");
	    labelMathType.setBounds(8, 20, 62, 16);
	    labelMathType.setBackground(color);	
	    //ComboBox
	    _comboBoxMaths = new Combo(_groupMaths, SWT.READ_ONLY);	   
	    _comboBoxMaths.setBounds(8, 36, 192, 21);
	    _comboBoxMaths.add(MathType.BIOLINK.toString());
	    _comboBoxMaths.add(MathType.INCITS378.toString());
	    _comboBoxMaths.select(0);
	    //--------------------------------------------
	    
	    //Panel BioScanners (Step: 2)
	    _groupScanners = new Group(_shell, SWT.NONE);
	    _groupScanners.setText("BioScanners (Step: 2)");	    
	    _groupScanners.setBounds(8, 79, 208, 96);
	    _groupScanners.setBackground(color);
	    //Label
	    Label labelScanners = new Label(_groupScanners, SWT.NONE);
	    labelScanners.setText("Scanners:");
	    labelScanners.setBounds(8, 20, 60, 16);
	    labelScanners.setBackground(color);	    
	    //ComboBox
	    _comboBoxScanners = new Combo(_groupScanners, SWT.READ_ONLY);	   
	    _comboBoxScanners.setBounds(8, 36, 192, 21);
	    _comboBoxScanners.setEnabled(false);
	    //Button btnOpendevice
	    _btnOpenDevice = new Button(_groupScanners, SWT.PUSH);
	    _btnOpenDevice.setEnabled(false);
	    _btnOpenDevice.setText("Open device");
	    _btnOpenDevice.setBounds(8, 64, 192, 24);
	    //--------------------------------------------
	    
	    //Panel ScanDevice (Step: 3)
	    _groupScanDevice = new Group(_shell, SWT.NONE);
	    _groupScanDevice.setText("ScanDevice (Step: 3)");	    
	    _groupScanDevice.setBounds(8, 180, 208, 287);	    
	    _groupScanDevice.setBackground(color);
	    _groupScanDevice.setEnabled(false);                
	    //Button btnAcquireImage
	    _btnAcquireImage = new Button(_groupScanDevice, SWT.PUSH);	   
	    _btnAcquireImage.setText("Acquire Image");
	    _btnAcquireImage.setBounds(8, 20, 192, 24);
	    //CheckBox
	    _checkBoxLoopScan = new Button(_groupScanDevice, SWT.CHECK);	   
	    _checkBoxLoopScan.setText(" Loop scan");
	    _checkBoxLoopScan.setBounds(16, 50, 104, 16);
	    _checkBoxLoopScan.setBackground(color);
	    //Label, slider
	    Label labelBrightness = new Label(_groupScanDevice, SWT.NONE);
	    labelBrightness.setText("Brightness");
	    labelBrightness.setBounds(8, 75, 64, 23);
	    labelBrightness.setBackground(color); 	    
	    _brightness = new Slider(_groupScanDevice, SWT.HORIZONTAL);
	    _brightness.setBounds(72, 75, 124, 15);
	    _brightness.setForeground(color);
	    _brightness.setMinimum(0);
	    _brightness.setMaximum(255);
	    _brightness.setIncrement(20);
	    
	    Label labelContrast = new Label(_groupScanDevice, SWT.NONE);
	    labelContrast.setText("Contrast");
	    labelContrast.setBounds(8, 105, 48, 23);
	    labelContrast.setBackground(color);
	    _contrast = new Slider(_groupScanDevice, SWT.HORIZONTAL);
	    _contrast.setBounds(72, 105, 124, 15);
	    _contrast.setForeground(color);
	    _contrast.setMinimum(0);
	    _contrast.setMaximum(255);
	    _contrast.setIncrement(20);
	    
	    Label labelGain = new Label(_groupScanDevice, SWT.NONE);
	    labelGain.setText("Gain");
	    labelGain.setBounds(8, 132, 32, 23);
	    labelGain.setBackground(color);
	    _gain = new Slider(_groupScanDevice, SWT.HORIZONTAL);
	    _gain.setBounds(72, 132, 124, 15);
	    _gain.setForeground(color);
	    _gain.setMinimum(0);
	    _gain.setMaximum(255);
	    _gain.setIncrement(20);
	    
	    //Panel DeviceInfo
	    _groupDeviceInfo = new Group(_groupScanDevice, SWT.NONE);
	    _groupDeviceInfo.setText("DeviceInfo");	    
	    _groupDeviceInfo.setBounds(8, 160, 192, 119);	    
	    _groupDeviceInfo.setBackground(color);	    
	    //Label
	    Label labelId = new Label(_groupDeviceInfo, SWT.NONE);
	    labelId.setText("ID:");
	    labelId.setBounds(8, 16, 100, 16);
	    labelId.setBackground(color);
	    _id = new Label(_groupDeviceInfo, SWT.NONE);
	    _id.setBounds(112, 16, 72, 13);
	    _id.setBackground(color);
	    _id.setAlignment(SWT.RIGHT);
	    
	    Label labelVendor = new Label(_groupDeviceInfo, SWT.NONE);
	    labelVendor.setText("Vendor:");
	    labelVendor.setBounds(8, 32, 100, 16);
	    labelVendor.setBackground(color);
	    _vendor = new Label(_groupDeviceInfo, SWT.NONE);
	    _vendor.setBounds(112, 32, 72, 13);
	    _vendor.setBackground(color);
	    _vendor.setAlignment(SWT.RIGHT);
	    
	    Label labelManufactureDate = new Label(_groupDeviceInfo, SWT.NONE);
	    labelManufactureDate.setText("ManufactureDate:");
	    labelManufactureDate.setBounds(8, 48, 100, 16);
	    labelManufactureDate.setBackground(color);
	    _manufactureDate = new Label(_groupDeviceInfo, SWT.NONE);
	    _manufactureDate.setBounds(112, 48, 72, 13);
	    _manufactureDate.setBackground(color);
	    _manufactureDate.setAlignment(SWT.RIGHT);
	    
	    Label labelDeviceVersion = new Label(_groupDeviceInfo, SWT.NONE);
	    labelDeviceVersion.setText("DeviceVersion:");
	    labelDeviceVersion.setBounds(8, 64, 100, 16);
	    labelDeviceVersion.setBackground(color);	    
	    _deviceVersion = new Label(_groupDeviceInfo, SWT.NONE);
	    _deviceVersion.setBounds(112, 64, 72, 13);
	    _deviceVersion.setBackground(color);
	    _deviceVersion.setAlignment(SWT.RIGHT);
	    
	    Label labelEmbeddedSoftwareVersion = new Label(_groupDeviceInfo, SWT.NONE);
	    labelEmbeddedSoftwareVersion.setText("EmbeddedSoftwareVersion:");
	    labelEmbeddedSoftwareVersion.setBounds(8, 80, 144, 16);
	    labelEmbeddedSoftwareVersion.setBackground(color);
	    _embeddedSoftwareVersion = new Label(_groupDeviceInfo, SWT.NONE);
	    _embeddedSoftwareVersion.setBounds(14, 80, 72, 13);
	    _embeddedSoftwareVersion.setBackground(color);
	    _embeddedSoftwareVersion.setAlignment(SWT.RIGHT);
	    
	    Label labelDeviceType = new Label(_groupDeviceInfo, SWT.NONE);
	    labelDeviceType.setText("DeviceType:");
	    labelDeviceType.setBounds(8, 96, 65, 13);
	    labelDeviceType.setBackground(color);
	    _deviceType = new Label(_groupDeviceInfo, SWT.NONE);
	    _deviceType.setBounds(100, 96, 84, 13);
	    _deviceType.setBackground(color);
	    _deviceType.setAlignment(SWT.RIGHT);
	    //--------------------------------------------
	    
	    //Panel Image
	    _groupImage = new Group(_shell, SWT.NONE);
	    _groupImage.setText("Image");	    
	    _groupImage.setBounds(224, 8, 176, 272);
	    //Label
	    Label labelWidth = new Label(_groupImage, SWT.NONE);
	    labelWidth.setText("Width");
	    labelWidth.setBounds(8, 24, 40, 16);	   
	    _widthImage = new Label(_groupImage, SWT.NONE);
	    _widthImage.setBounds(48, 24, 32, 13);	   
	    _widthImage.setAlignment(SWT.RIGHT);  
	    
	    Label labelHeight = new Label(_groupImage, SWT.NONE);
	    labelHeight.setText("Height");
	    labelHeight.setBounds(8, 40, 40, 16);	   
	    _heightImage = new Label(_groupImage, SWT.NONE);
	    _heightImage.setBounds(48, 40, 32, 13);	   
	    _heightImage.setAlignment(SWT.RIGHT);  
	    
	    Label labelbpp = new Label(_groupImage, SWT.NONE);
	    labelbpp.setText("bpp");
	    labelbpp.setBounds(8, 56, 40, 16);	   
	    _bppImage = new Label(_groupImage, SWT.NONE);
	    _bppImage.setBounds(48, 56, 32, 13);	   
	    _bppImage.setAlignment(SWT.RIGHT);  
	    
	    Label labelhDpi = new Label(_groupImage, SWT.NONE);
	    labelhDpi.setText("h_dpi");
	    labelhDpi.setBounds(88, 24, 40, 16);	   
	    _hDpiImage = new Label(_groupImage, SWT.NONE);
	    _hDpiImage.setBounds(136, 24, 32, 13);	   
	    _hDpiImage.setAlignment(SWT.RIGHT);  
	    
	    Label labelvDpi = new Label(_groupImage, SWT.NONE);
	    labelvDpi.setText("v_dpi");
	    labelvDpi.setBounds(88, 40, 40, 16);	   
	    _vDpiImage = new Label(_groupImage, SWT.NONE);
	    _vDpiImage.setBounds(136, 40, 32, 13);	   
	    _vDpiImage.setAlignment(SWT.RIGHT);  
	    
	    Label labelLineSize = new Label(_groupImage, SWT.NONE);
	    labelLineSize.setText("LineSize");
	    labelLineSize.setBounds(88, 56, 40, 16);	   
	    _lineSizeImage = new Label(_groupImage, SWT.NONE);
	    _lineSizeImage.setBounds(136, 56, 32, 13);	   
	    _lineSizeImage.setAlignment(SWT.RIGHT);
	    
	    //Canvas
	    Composite composite = new Composite(_groupImage, SWT.BORDER);
	    composite.setBounds(12, 84, 152, 158);	     
	    _canvas = new Canvas(composite, SWT.NONE);
	    _canvas.setSize(152, 148);
	    //Link Save
	    _linkSave = new Link(_groupImage, SWT.NONE);	    
	    _linkSave.setText("<a>Save</a>");	    
	    _linkSave.setBounds(24, 250, 40, 16);
	    _linkSave.setEnabled(false);
	    //Link Load
	    _linkLoad = new Link(_groupImage, SWT.NONE);	    
	    _linkLoad.setText("<a>Load</a>");	    
	    _linkLoad.setBounds(74, 250, 40, 16);
	    //Link Zoom
	    _linkZoom = new Link(_groupImage, SWT.NONE);	    
	    _linkZoom.setText("<a>Zoom</a>");	    
	    _linkZoom.setBounds(126, 250, 40, 16);
	    _linkZoom.setEnabled(false);
	    //--------------------------------------------
	    
	    //Panel ImageProcessor (Step: 4)
	    _groupImageProcessor = new Group(_shell, SWT.NONE);
	    _groupImageProcessor.setText("ImageProcessor (Step: 4)");	    
	    _groupImageProcessor.setBounds(224, 286, 176, 181);
	    _groupImageProcessor.setBackground(color);
	    _groupImageProcessor.setEnabled(false);
	    //Label
	    Label labelExpressQuality = new Label(_groupImageProcessor, SWT.NONE);
	    labelExpressQuality.setText("Express Quality:");
	    labelExpressQuality.setBounds(20, 21, 88, 16);
	    labelExpressQuality.setBackground(color);
	    _expressQuality = new Label(_groupImageProcessor, SWT.NONE);
	    _expressQuality.setBounds(116, 21, 40, 16); 
	    _expressQuality.setBackground(color);
	    //Button btnCreateTemplate
	    _btnCreateTemplate = new Button(_groupImageProcessor, SWT.PUSH);	   
	    _btnCreateTemplate.setText("Create Template");
	    _btnCreateTemplate.setBounds(12, 46, 160, 23);
	    //Panel ImageDrawer
	    _groupImageDrawer = new Group(_groupImageProcessor, SWT.NONE);
	    _groupImageDrawer.setText("ImageDrawer");	    
	    _groupImageDrawer.setBounds(12, 74, 156, 99);
	    _groupImageDrawer.setBackground(color);
	    //CheckBox
	    _checkBoxDrawQualityEx = new Button(_groupImageDrawer, SWT.CHECK);	   
	    _checkBoxDrawQualityEx.setText(" DrawQualityEx");
	    _checkBoxDrawQualityEx.setBounds(8, 16, 112, 24);
	    _checkBoxDrawQualityEx.setBackground(color);
	    
	    _checkBoxDrawMinutiae = new Button(_groupImageDrawer, SWT.CHECK);	   
	    _checkBoxDrawMinutiae.setText(" DrawMinutiae");
	    _checkBoxDrawMinutiae.setBounds(8, 36, 112, 24);
	    _checkBoxDrawMinutiae.setBackground(color);
	    
	    _checkBoxDrawDirectionField  = new Button(_groupImageDrawer, SWT.CHECK);	   
	    _checkBoxDrawDirectionField.setText(" DrawDirectionField");
	    _checkBoxDrawDirectionField.setBounds(8, 56, 140, 24);
	    _checkBoxDrawDirectionField.setBackground(color);
	    //--------------------------------------------
	    
	    //Panel Template
	    _groupTemplate = new Group(_shell, SWT.NONE);
	    _groupTemplate.setText("Template");	    
	    _groupTemplate.setBounds(408, 8, 224, 183);
	    //Label
	    Label labelFigerCode = new Label(_groupTemplate, SWT.NONE);
	    labelFigerCode.setText("Figer code");
	    labelFigerCode.setBounds(8, 20, 100, 16);
	    _fingerCode = new Label(_groupTemplate, SWT.NONE);
	    _fingerCode.setBounds(136, 20, 72, 13);	   
	    _fingerCode.setAlignment(SWT.RIGHT);  
	    
	    Label labelMinutiaeCount = new Label(_groupTemplate, SWT.NONE);
	    labelMinutiaeCount.setText("Minutiae count");
	    labelMinutiaeCount.setBounds(8, 36, 100, 16);
	    _minutiaeCount = new Label(_groupTemplate, SWT.NONE);
	    _minutiaeCount.setBounds(136, 36, 72, 13);	   
	    _minutiaeCount.setAlignment(SWT.RIGHT);  
	    
	    Label labelQuality = new Label(_groupTemplate, SWT.NONE);
	    labelQuality.setText("Quality");
	    labelQuality.setBounds(10, 59, 48, 16);	
	    _quality = new Label(_groupTemplate, SWT.NONE);
	    _quality.setBounds(66, 59, 32, 13);	   
	    _quality.setAlignment(SWT.RIGHT);  
	    
	    Label labelArea = new Label(_groupTemplate, SWT.NONE);
	    labelArea.setText("Area");
	    labelArea.setBounds(10, 75, 29, 13);
	    _area = new Label(_groupTemplate, SWT.NONE);
	    _area.setBounds(66, 75, 32, 13);	   
	    _area.setAlignment(SWT.RIGHT);  
	    
	    Label labelLocation = new Label(_groupTemplate, SWT.NONE);
	    labelLocation.setText("Location");
	    labelLocation.setBounds(10, 91, 48, 13);
	    _location = new Label(_groupTemplate, SWT.NONE);
	    _location.setBounds(66, 91, 32, 13);	   
	    _location.setAlignment(SWT.RIGHT);  
	    
	    Label labelDeltaCent = new Label(_groupTemplate, SWT.NONE);
	    labelDeltaCent.setText("DeltaCent");
	    labelDeltaCent.setBounds(10, 112, 54, 13);
	    _deltaCent = new Label(_groupTemplate, SWT.NONE);
	    _deltaCent.setBounds(107, 112, 45, 13);	   
	    _deltaCent.setAlignment(SWT.RIGHT);  
	
	    Label labelImageTransform = new Label(_groupTemplate, SWT.NONE);
	    labelImageTransform.setText("Image transform");
	    labelImageTransform.setBounds(10, 128, 88, 16);
	    _imageTransform = new Label(_groupTemplate, SWT.NONE);
	    _imageTransform.setBounds(107, 128, 101, 13);	   
	    _imageTransform.setAlignment(SWT.RIGHT);  
	  
	    Label labelAsimmetry = new Label(_groupTemplate, SWT.NONE);
	    labelAsimmetry.setText("Asimmetry");
	    labelAsimmetry.setBounds(110, 59, 60, 13);
	    _asimmetry = new Label(_groupTemplate, SWT.NONE);
	    _asimmetry.setBounds(176, 59, 32, 13);	   
	    _asimmetry.setAlignment(SWT.RIGHT);  
	    
	    Label labelDeformation = new Label(_groupTemplate, SWT.NONE);
	    labelDeformation.setText("Deformation");
	    labelDeformation.setBounds(110, 74, 70, 13);
	    _deformation = new Label(_groupTemplate, SWT.NONE);
	    _deformation.setBounds(176, 74, 32, 13);	   
	    _deformation.setAlignment(SWT.RIGHT); 
	    
	    //Link SaveTemplete
	    _linkSaveTemplate = new Link(_groupTemplate, SWT.NONE);	    
	    _linkSaveTemplate.setText("<a>Save template</a>");	    
	    _linkSaveTemplate.setBounds(16, 159, 88, 16);
	    _linkSaveTemplate.setEnabled(false);
	    //Link LoadTemplate
	    _linkLoadTemplate = new Link(_groupTemplate, SWT.NONE);	    
	    _linkLoadTemplate.setText("<a>Load template</a>");	    
	    _linkLoadTemplate.setBounds(120, 159, 88, 16);	    
	    //--------------------------------------------
	    
	    //Panel Templates list (Step: 5)
	    _groupTemplateList = new Group(_shell, SWT.NONE);
	    _groupTemplateList.setText("Templates list (Step: 5)");	    
	    _groupTemplateList.setBounds(408, 197, 224, 110);
	    _groupTemplateList.setBackground(color);
	    _groupTemplateList.setEnabled(false);
	    //Table
	    _table = new Table(_groupTemplateList, SWT.CHECK | SWT.V_SCROLL);
	    _table.setBounds(11, 21, 197, 49);
	     //Button btnRemoveTemplate
	    _btnRemoveTemplate = new Button(_groupTemplateList, SWT.PUSH);	   
	    _btnRemoveTemplate.setText("Remove");
	    _btnRemoveTemplate.setBounds(21, 79, 75, 24);
	    _btnRemoveTemplate.setBackground(color);	    
	    //Button btnAddTemplate
	    _btnAddTemplate = new Button(_groupTemplateList, SWT.PUSH);	   
	    _btnAddTemplate.setText("Add current");
	    _btnAddTemplate.setBounds(123, 79, 75, 24);
	    _btnAddTemplate.setBackground(color);	  
	    //--------------------------------------------
	    
	    //Panel Matcher (Step: 6)
	    _groupMatcher = new Group(_shell, SWT.NONE);
	    _groupMatcher.setText("Matcher (Step: 6)");	    
	    _groupMatcher.setBounds(408, 313, 224, 153);
	    _groupMatcher.setBackground(color);
	    _groupMatcher.setEnabled(false);
	    //Label
	    Label labelSpeed = new Label(_groupMatcher, SWT.NONE);
	    labelSpeed.setText("Speed");
	    labelSpeed.setBounds(11, 20, 48, 16);
	    labelSpeed.setBackground(color);
	    
	    Label labelSecurityLevel = new Label(_groupMatcher, SWT.NONE);
	    labelSecurityLevel.setText("Security level");
	    labelSecurityLevel.setBounds(120, 20, 80, 13);
	    labelSecurityLevel.setBackground(color);
	    //ComboBox
	    _comboBoxSpeed = new Combo(_groupMatcher, SWT.READ_ONLY);	   
	    _comboBoxSpeed.setBounds(11, 40, 96, 21);	    
	    _comboBoxSpeed.add("Normal");
	    _comboBoxSpeed.add("Slow");
	    
	    _comboBoxSecurityLevel = new Combo(_groupMatcher, SWT.READ_ONLY);	   
	    _comboBoxSecurityLevel.setBounds(120, 40, 96, 21);
	    _comboBoxSecurityLevel.add("Low");
	    _comboBoxSecurityLevel.add("Normal");
	    _comboBoxSecurityLevel.add("High");
	    //Button btnCompare
	    _btnCompare = new Button(_groupMatcher, SWT.PUSH);	   
	    _btnCompare.setText("Compare");
	    _btnCompare.setBounds(8, 68, 208, 24);
	    _btnCompare.setBackground(color);
	    //Panel MatchInfo 
	    _groupMatchInfo = new Group(_groupMatcher, SWT.NONE);
	    _groupMatchInfo.setText("MatchInfo");	    
	    _groupMatchInfo.setBounds(8, 103, 208, 40);
	    _groupMatchInfo.setBackground(color);
	    //Label
	    _match = new Label(_groupMatchInfo, SWT.NONE);
	    _match.setBounds(16, 16, 72, 16); 
	    _match.setBackground(color);
	    Label labelScore = new Label(_groupMatchInfo, SWT.NONE);
	    labelScore.setText("Score");
	    labelScore.setBounds(96, 16, 48, 16);
	    labelScore.setBackground(color);
	    _score = new Label(_groupMatchInfo, SWT.NONE);
	    _score.setBounds(144, 16, 56, 13); 
	    _score.setBackground(color);
	    _score.setAlignment(SWT.RIGHT); 
	    //---------------------------------------------------------------- 
	    
	    CreateDeviceList();
	    btnOpenDevice_Click();
	    btnAcquireImage_Click();
	    linkLoad_Click();
	    linkZoom_Click();
	    linkSave_Click();
	    btnCreateTemplate_Click();
	    linkSaveTemplate_Click();
	    linkLoadTemplate_Click();
	    btnAddTemplate_Click();
	    btnRemoveTemplate_Click();
	    checked();
	    btnCompare_Click();
	}
	
	private void CreateDeviceList()
	{	
		try
	    {
	    	_deviceList = new DeviceList(DeviceType.AnyDevice);
	    	
	    	if (_deviceList.getSize() > 0)
	    	{
	    		_btnOpenDevice.setEnabled(true);
	    		_comboBoxScanners.setEnabled(true);
	    		for (int i = 0; i < _deviceList.getSize(); i++)
	    		{
	    			_deviceDescriptor = _deviceList.getDeviceDescriptor(i);
	    			_comboBoxScanners.add(_deviceDescriptor.getDeviceType() + " " + i);
	    		}
	    		_comboBoxScanners.select(0);
	    	}  		
	    }
	    catch (Exception ex)
	    {
	    	_messageBox.setMessage("Can't create device list. " + ex.getMessage());
			_messageBox.setText("Error");
			_messageBox.open();
	    } 
	}

	private void btnOpenDevice_Click()
    {
        _btnOpenDevice.addSelectionListener (new SelectionListener()
        {		
        	public void widgetSelected(SelectionEvent event) 
        	{
        		if (_scanner != null)
	            {
	                _scanner.dispose();
	                _scanner = null;

	                _comboBoxScanners.setEnabled(true);
	                _btnOpenDevice.setText("Open device");
	                _groupScanDevice.setEnabled(false);
	                _id.setText("");
	                _vendor.setText("");
	                _manufactureDate.setText("");
	                _deviceVersion.setText("");
	                _embeddedSoftwareVersion.setText("");
	                _deviceType.setText("");	
	            }
        		else 
	            {         				
        			_comboBoxScanners.setEnabled(false);
        			_btnOpenDevice.setText("Close device");
            			
            		try
            		{
            			_scanner = new Scanner(_deviceList.getDeviceDescriptor(_comboBoxScanners.getSelectionIndex()));
            			
            			_groupScanDevice.setEnabled(true);            			
            			
            			_id.setText(_scanner.getDeviceInfo().getId());
            			_vendor.setText(_scanner.getDeviceInfo().getVendor());
            			_manufactureDate.setText(_scanner.getDeviceInfo().getManufactureDate());
            			_deviceVersion.setText(_scanner.getDeviceInfo().getDeviceVersion());
            			_embeddedSoftwareVersion.setText(_scanner.getDeviceInfo().getEmbeddedSoftwareVersion());
            			_deviceType.setText(_scanner.getDeviceInfo().getDeviceType().toString());
	                       
	                }
	                catch (Exception ex)
	                {
	                    _id.setText("");
	                    _vendor.setText("");
	                    _manufactureDate.setText("");
	                    _deviceVersion.setText("");
	                    _embeddedSoftwareVersion.setText("");
	                    _deviceType.setText("");	                       
	                        
            			_messageBox.setMessage("Can't get scanner info. " + ex.getMessage());
            			_messageBox.setText("Error");
            			_messageBox.open();		                        	                        
	                }	                 
	            } 
        	}
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        });
    }

	private void btnAcquireImage_Click()
 	{
 		_btnAcquireImage.addSelectionListener (new SelectionListener()
        {		
        	public void widgetSelected(SelectionEvent event) 
        	{
        		 try
        		 {
        			 _image = _scanner.acquireImage();         			 
        			         			 
        			 if (_image != null)
     					_expressQuality.setText(String.valueOf(_image.getExpressQuality(8)));
        		      		 
        			 if (_paintListener != null)
	            		_canvas.removePaintListener(_paintListener);
	            	
        			 _canvas.redraw(); 
        		 
        			 _paintListener = new PaintListener() {public void paintControl(PaintEvent e) 
        			 {
        				 try
        				 {
        					 byte[] buffer = _image.save();        				 
        					 InputStream stream = new ByteArrayInputStream(buffer);
        				 
        					 ImageData imageData = new ImageData(stream);
        					 org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(_display, imageData);
        				 
        					 e.gc.drawImage(image,
        							 		0,
        							 		0,
        							 		imageData.width,
        							 		imageData.height,
        							 		imageData.x,
        							 		imageData.y,
        							 		152,
        							 		148); 
        					 image.dispose(); 
        				 }
        				 catch (Exception ex)
                		 {
                			 _messageBox.setMessage("Can't display image. " + ex.getMessage());
             				 _messageBox.setText("Error");
             				 _messageBox.open();
                		 }
        				 
        			 }};
        			 _linkSave.setEnabled(true);
         	         _linkZoom.setEnabled(true);
         	         _groupImageProcessor.setEnabled(true);
         	         
         	        _canvas.addPaintListener(_paintListener);
        		 }
        		 catch (Exception ex)
        		 {
        			 _messageBox.setMessage("Can't acquire image. " + ex.getMessage());
     				 _messageBox.setText("Error");
     				 _messageBox.open();
        		 } 
            }
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        }); 
 	}

	private void linkLoad_Click()
	{
		_linkLoad.addListener(SWT.Selection, new Listener() 
		{
	        public void handleEvent(Event event) 
	        {
	        	FileDialog dlg = new FileDialog(_shell, SWT.OPEN);
	        	dlg.setFilterNames(new String[] {"Bitmap Files (*.bmp)",
	        	        	            		 "All Files (*.*)" });
	        	dlg.setFilterExtensions(new String[] { "*.bmp", "*.*" });
	            final String fileName = dlg.open();
	            if (fileName != null) 
	            {
	            	_fileName = fileName;	            		            	
	            	
	            	if (_paintListener != null)
	            		_canvas.removePaintListener(_paintListener);
	            	
	            	_canvas.redraw(); 
	            	
	            	_paintListener = new PaintListener() {public void paintControl(PaintEvent e) 
	            	{
	            		try
            	        {
            				org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(_display, _fileName);
  	            				
            	        	ImageData imageData = new ImageData(fileName);
            	        	      	
            	        	e.gc.drawImage(image,
	            	                  0,
	            	                  0,
	            	                  imageData.width,
	            	                  imageData.height,
	            	                  imageData.x,
	            	                  imageData.y,
	            	                  152,
	            	                  148); 		            	        
	            	        image.dispose();
	            	        
	            	        try
	    	            	{
	    	            		File file = new File(_fileName);
	    	        			FileInputStream fbmp = new FileInputStream(file);

	    	        			byte[] buffer = new byte[(int) file.length()];
	    	        			fbmp.read(buffer);
	    	        			fbmp.close();
	    	        			
	    	        			try
	    	        			{
	    	        				_image = new com.biolink.biometrics2.Image(buffer);
	    	        				if (_image != null)
	    	        					_expressQuality.setText(String.valueOf(_image.getExpressQuality(8)));
	    	        			}
	    	        			catch (Exception ex)
	    	        		    {
	    	        		    	_messageBox.setMessage("Can't create image. " + ex.getMessage());
	    	        				_messageBox.setText("Error");
	    	        				_messageBox.open();
	    	        		    } 
	    	            	}
	    	            	catch (FileNotFoundException ex)
	    	        		{
	    	        			System.out.println(ex.getMessage());
	    	        		} 
	    	            	catch (IOException ex)
	    	        		{
	    	        			System.out.println(ex.getMessage());
	    	        		}
	            	        
	            	        _linkSave.setEnabled(true);
	            	        _linkZoom.setEnabled(true);
	            	        _groupImageProcessor.setEnabled(true);
            	        }
            	        catch (Exception ex)
	                    { 	
            	        	if (_image != null)
            	        		_image.dispose();
            				
            	        	_messageBox.setMessage("Can't load image. " + ex.getMessage());
            				_messageBox.setText("Error");
            				_messageBox.open();
            				
            				_linkSave.setEnabled(false);
	            	        _linkZoom.setEnabled(false);
            				_groupImageProcessor.setEnabled(false);
	                    }
            	    }};	
            	    
	            	_canvas.addPaintListener(_paintListener);
	            }
	        }
	     }); 
	}

	private void linkZoom_Click()
	{
		_linkZoom.addListener(SWT.Selection, new Listener()
		{
	        public void handleEvent(Event event)
	        {        	
	        	Shell zoomForm = new Shell(_display, SWT.CLOSE | SWT.MIN);
	    	    zoomForm.setText("ZoomForm");
	    	    zoomForm.setSize(292, 273);	    	    
	    	    
	    	    Composite compositeZoom = new Composite(zoomForm, SWT.BORDER);
	    	    compositeZoom.setBounds(0, 0, 286, 241);	     
	    	    Canvas canvasZoom = new Canvas(compositeZoom, SWT.NONE);
	    	    canvasZoom.setSize(286, 241);
	    	    
	    	    canvasZoom.redraw();	    		
	    	    canvasZoom.addPaintListener(new PaintListener()
	    	    {
            	    public void paintControl(PaintEvent e)
            	    {            	    	
            	    	byte[] buffer = _image.save();        				 
   					 	InputStream stream = new ByteArrayInputStream(buffer);
   				 
   					 	ImageData imageData = new ImageData(stream);
   					 	org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(_display, imageData);
        	        	      	
            	        e.gc.drawImage(image,
            	                  	   0,
            	                  	   0,
            	                  	   imageData.width,
            	                  	   imageData.height,
            	                  	   imageData.x,
            	                  	   imageData.y,
            	                  	   286,
            	                  	   241); 		            	        
            	        image.dispose();           	    	
            	    } 
            	}); 
	    	    
	    	    zoomForm.open();
	        }
	    }); 
	}

	private void linkSave_Click()
	{
		_linkSave.addListener(SWT.Selection, new Listener() 
		{
	        public void handleEvent(Event event) 
	        {
	        	FileDialog dlg = new FileDialog(_shell, SWT.SAVE);
	        	dlg.setFilterNames(new String[] {"Bitmap Files (*.bmp)",
	        	        	            		 "All Files (*.*)" });
	        	dlg.setFilterExtensions(new String[] { "*.bmp", "*.*" });
	            final String fileName = dlg.open();
	            if (fileName != null) 
	            {
	            	try
	            	{
	            		_image.save(fileName);
	            	}
	            	catch (Exception ex)
	        		{
	        			_messageBox.setMessage("Can't save image. " + ex.getMessage());
	     				_messageBox.setText("Error");
	     				_messageBox.open();
	        		} 
	            }
	        }
	     }); 
	}
	
	private void btnCreateTemplate_Click() 
	{
		_btnCreateTemplate.addSelectionListener (new SelectionListener()
        {		
        	public void widgetSelected(SelectionEvent event) 
        	{
        		try 
        		{
        			_imageSet = new ImageSet();  
        			_imageSet.addImage(_image, FingerCode.Unknown);
        			
        			if (_comboBoxMaths.getSelectionIndex() == 0)
       					_math = MathType.BIOLINK;
       			 	if (_comboBoxMaths.getSelectionIndex() == 1)
       					_math = MathType.INCITS378;
       			 	
        			_imgPrc = new ImageProcessor(_math);        			
        			
        			try
        			{
        				_template = _imgPrc.createTemplate(_imageSet);
        				
        				_quality.setText(String.valueOf(_template.getQuality()));
        				
        				_linkSaveTemplate.setEnabled(true);
        				_groupTemplateList.setEnabled(true);
        			}
        			catch (Exception ex)
        			{  
        				_template = null;
        				
        				_messageBox.setMessage("Can't create template. " + ex.getMessage());
        				_messageBox.setText("Error");
        				_messageBox.open();
        				
        				_linkSaveTemplate.setEnabled(false);
        				_groupTemplateList.setEnabled(false);
        			}  
        		}
        		finally
        		{
        			if (_imgPrc != null)
        		    	_imgPrc.dispose();
        		    if (_imageSet != null)
        		    	_imageSet.dispose();
        		}
        	}
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        }); 
	}
	
	public void Open()
	{
		_shell.open();
	}
	
	private void linkSaveTemplate_Click()
	{
		_linkSaveTemplate.addListener(SWT.Selection, new Listener()
		{
	        public void handleEvent(Event event)
	        {        	
	        	FileDialog dlg = new FileDialog(_shell, SWT.SAVE);
	        	dlg.setFilterNames(new String[] {"Template Files (*.dat)",
	        	        	            		 "All Files (*.*)" });
	        	dlg.setFilterExtensions(new String[] { "*.dat", "*.*" });
	            final String fileName = dlg.open();
	            if (fileName != null) 
	            {
	            	try 
	            	{
	            		byte[] buffer = new byte[_template.getSize()];
		            	
		            	buffer = _template.toArray();
		            	
		            	try
		            	{
		            		File file = new File(fileName);
		        			FileOutputStream fdat = new FileOutputStream(file);
		        			
		        			fdat.write(buffer);
		        			fdat.close(); 	
		            	}
		            	catch (FileNotFoundException ex)
		        		{
		        			System.out.println(ex.getMessage());
		        		} catch (IOException ex)
		        		{
		        			System.out.println(ex.getMessage());
		        		}
	            	}
	            	catch (Exception ex)
        			{         				
        				_messageBox.setMessage("Can't template save. " + ex.getMessage());
        				_messageBox.setText("Error");
        				_messageBox.open();
        			} 
	            }
	        }
	    }); 
	}
	
	private void linkLoadTemplate_Click()
	{
		_linkLoadTemplate.addListener(SWT.Selection, new Listener()
		{
	        public void handleEvent(Event event)
	        {        	
	        	FileDialog dlg = new FileDialog(_shell, SWT.OPEN);
	        	dlg.setFilterNames(new String[] {"Template Files (*.dat)",
	        	        	            		 "All Files (*.*)" });
	        	dlg.setFilterExtensions(new String[] { "*.dat", "*.*" });
	            final String fileName = dlg.open();
	            if (fileName != null)
	            {
	            	try
	        		{
	        			File datfile = new File(fileName);
	        			FileInputStream fdat = new FileInputStream(datfile);

	        			byte[] buffer = new byte[(int) datfile.length()];
	        			fdat.read(buffer);
	        			fdat.close();			
	        		
	        			try
	        			{	
	        				if (_comboBoxMaths.getSelectionIndex() == 0)
	           					_math = MathType.BIOLINK;
	           			 	if (_comboBoxMaths.getSelectionIndex() == 1)
	           					_math = MathType.INCITS378;
	           			 
	        				_template = new Template(_math);
	        				_template.load(buffer);	
	        				
	        				_quality.setText(String.valueOf(_template.getQuality()));
	        				
	        				_groupTemplateList.setEnabled(true);
	        				_linkSaveTemplate.setEnabled(true);
	        			}
	        			catch (Exception ex)
	        			{
	        				if (_template != null)
	        				{
	        					_template.dispose();
	        					_template = null;
	        				}
	        				
	        				_messageBox.setMessage("Can't load template. " + ex.getMessage());
            				_messageBox.setText("Error");
            				_messageBox.open();	
	        				
	        				_groupTemplateList.setEnabled(false);
	        				_linkSaveTemplate.setEnabled(false);
	        			}	        			
	        		}
	        		catch (FileNotFoundException e)
	        		{
	        			System.out.println(e.getMessage());
	        		} catch (IOException e)
	        		{
	        			System.out.println(e.getMessage());
	        		}
	            }
	        }
	    });
	}
	
	private void btnAddTemplate_Click() //��������� ���� ������ �������
	{
		_btnAddTemplate.addSelectionListener (new SelectionListener()
        {		
        	public void widgetSelected(SelectionEvent event) 
        	{
        		 TableItem item = new TableItem(_table, SWT.NONE);        		 
        		 item.setData(_template);
        		 item.setText(String.valueOf("Template quality " + _template.getQuality() +
        				 " size " + _template.getSize()));
        	}
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        }); 
	}
	
	private void checked()
	{
		_table.addListener(SWT.Selection, new Listener()
		 {			 
			public void handleEvent(Event event)
		      {
		    	  if (event.detail == SWT.CHECK)
		    	  {
		    	  	 
		    		 _table.setSelection(_table.indexOf(((TableItem)event.item)));		    		 		    		  
		    			    		  
		    		 int i = 0;		    		 
		    		 for (int j = 0; j < _table.getItemCount(); j++)
		    		 {
		    			 if (_table.getItem(j).getChecked() == true)
		    				 i++;
		    		 } 
		    		 if (i > 2)
		    		 {
		    		 	 ((TableItem)event.item).setChecked(false);
		    		 	 i--;
		    		 }
		    		 
		    		 if (i == 2)
		    			 _groupMatcher.setEnabled(true);
		    		 else 
		    			 _groupMatcher.setEnabled(false);
		    	  }		    	
		      }
		 });
	}
	
	private void btnRemoveTemplate_Click()
	{
		_btnRemoveTemplate.addSelectionListener (new SelectionListener()
        {	
        	public void widgetSelected(SelectionEvent event) 
        	{
        		 _table.remove(_table.getSelectionIndices ());
        	}
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        });
	}
	
	private void btnCompare_Click()
	{
		_btnCompare.addSelectionListener (new SelectionListener()
        {	
        	public void widgetSelected(SelectionEvent event) 
        	{        				    		 
        		 int i1 = -1, i2 = -1;
        		 for (int j = 0; j < _table.getItemCount(); j++)
	    		 {
	    			if (_table.getItem(j).getChecked() == true)
	    			{
	    				if (i1 == -1) 
	    					i1 = j;
	    				if (i1 != -1)
	    					i2 = j;
	    			}	    			 
	    		 }
        		 Template templ1 = (Template)_table.getItem(i1).getData(); 
        		 Template templ2 = (Template)_table.getItem(i2).getData();
        		 
        		 try 
        		 {
        			 if (_comboBoxMaths.getSelectionIndex() == 0)
        				 _math = MathType.BIOLINK;
        			 if (_comboBoxMaths.getSelectionIndex() == 1)
        				 _math = MathType.INCITS378;
        			 
        			_matcher = new Matcher(_math);
        			
        			int score = _matcher.compare(templ1, templ2);
        			if (score >= 600)
        			{
        				_match.setText("MATCH");
               		    Color color = new Color(_display, 0, 255, 0);
               		    _match.setForeground(color);
               		    _score.setText(String.valueOf(score));
        			}
        			else
        			{
        				_match.setText("MISMATCH");
               		    Color color = new Color(_display, 255, 0, 0);
               		    _match.setForeground(color);
               		    _score.setText(String.valueOf(score));
        			}
        		 }
        		 catch (Exception ex)
        		 { 
        			 _messageBox.setMessage("Can't compare templates. " + ex.getMessage());
     				 _messageBox.setText("Error");
     				 _messageBox.open();	
        		 }
        		 finally
        		 {
        			 if (_matcher != null)
        				 _matcher.dispose();
        		 }      		
        	}
        	public void widgetDefaultSelected(SelectionEvent event){}	        
        });
	}
	
	
	public void Dispose()
	{
		while (!_shell.isDisposed()) {
		      if (!_display.readAndDispatch()) {
		        _display.sleep();
		      }
		    }		

		if (_matcher != null)
			_matcher.dispose();
	    if (_template != null)
	    	_template.dispose();
	    if (_imgPrc != null)
	    	_imgPrc.dispose();
	    if (_imageSet != null)
	    	_imageSet.dispose();
		if (_image != null)
			_image.dispose();
		if (_scanner != null)
			_scanner.dispose();
		if (_deviceDescriptor != null)
    		_deviceDescriptor.dispose();
    	if (_deviceList != null)
			_deviceList.dispose();      	
    	
    	if (_score != null)
    		_score.dispose();
    	if (_match != null)
    		_match.dispose();
    	if (_groupMatchInfo != null)
    		_groupMatchInfo.dispose();
    	if (_btnCompare != null)
    		_btnCompare.dispose();    	
    	if (_comboBoxSecurityLevel != null)
    		_comboBoxSecurityLevel.dispose();
    	if (_comboBoxSpeed != null)
    		_comboBoxSpeed.dispose();
    	if (_groupMatcher != null)
    		_groupMatcher.dispose();
    	if (_btnAddTemplate != null)
    		_btnAddTemplate.dispose();
    	if (_btnRemoveTemplate != null)
    		_btnRemoveTemplate.dispose();
    	if (_table != null)
    		_table.dispose();
    	if (_groupTemplateList != null)
    		_groupTemplateList.dispose();
    	if (_linkLoadTemplate != null)
    		_linkLoadTemplate.dispose();
    	if (_linkSaveTemplate != null)
    		_linkSaveTemplate.dispose();
    	if (_deformation != null)
    		_deformation.dispose();
    	if (_asimmetry != null)
    		_asimmetry.dispose();
    	if (_imageTransform != null)
    		_imageTransform.dispose();
    	if (_deltaCent != null)
    		_deltaCent.dispose();
    	if (_location != null)
    		_location.dispose();
    	if (_area != null)
    		_area.dispose();
    	if (_quality != null)
    		_quality.dispose();
    	if (_minutiaeCount != null)
    		_minutiaeCount.dispose();
    	if (_fingerCode != null)
    		_fingerCode.dispose();
    	if (_groupTemplate != null)
    		_groupTemplate.dispose();
    	if (_lineSizeImage != null)
    		_lineSizeImage.dispose();
    	if (_vDpiImage != null)
    		_vDpiImage.dispose();
    	if (_hDpiImage != null)
    		_hDpiImage.dispose();
    	if (_bppImage != null)
    		_bppImage.dispose();
    	if (_heightImage != null)
    		_heightImage.dispose();
    	if (_widthImage != null)
    		_widthImage.dispose();
    	if (_checkBoxDrawDirectionField != null)
    		_checkBoxDrawDirectionField.dispose();
    	if (_checkBoxDrawMinutiae != null)
    		_checkBoxDrawMinutiae.dispose();
    	if (_checkBoxDrawQualityEx != null)
    		_checkBoxDrawQualityEx.dispose();
    	if (_groupImageDrawer != null)
    		_groupImageDrawer.dispose();
    	if (_btnCreateTemplate != null)
    		_btnCreateTemplate.dispose();
    	if (_expressQuality != null)
    		_expressQuality.dispose();
    	if (_groupImageProcessor != null)
    		_groupImageProcessor.dispose();
    	if (_linkZoom != null)
    		_linkZoom.dispose();
    	if (_linkLoad != null)
    		_linkLoad.dispose();
    	if (_linkSave != null)
    		_linkSave.dispose();
    	if (_canvas != null)
    		_canvas.dispose();
    	if (_groupImage != null)
    		_groupImage.dispose();
		if (_deviceType != null)
			_deviceType.dispose();
		if (_embeddedSoftwareVersion != null)
			_embeddedSoftwareVersion.dispose();
		if (_deviceVersion != null)
			_deviceVersion.dispose();
		if (_manufactureDate != null)
			_manufactureDate.dispose();
		if (_vendor != null)
			_vendor.dispose();
		if (_id != null)
			_id.dispose();
		if (_groupDeviceInfo != null)
			_groupDeviceInfo.dispose();
		if (_gain != null)
			_gain.dispose();
		if (_contrast != null)
			_contrast.dispose();
		if (_brightness != null)
			_brightness.dispose();
		if (_checkBoxLoopScan != null)
			_checkBoxLoopScan.dispose();
		if (_btnAcquireImage != null)
			_btnAcquireImage.dispose();
		if (_groupScanDevice != null)
			_groupScanDevice.dispose();
		if (_btnOpenDevice != null)
			_btnOpenDevice.dispose();
		if (_comboBoxScanners != null)
			_comboBoxScanners.dispose();
		if (_groupScanners != null)
			_groupScanners.dispose();		
		if (_comboBoxMaths != null)
			_comboBoxMaths.dispose();
		if (_groupMaths != null)
			_groupMaths.dispose();		
		if (_shell != null)
			_shell.dispose();
		if (_display != null)
			_display.dispose();
	}
*/
}

