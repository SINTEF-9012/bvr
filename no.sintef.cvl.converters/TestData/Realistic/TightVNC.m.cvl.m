VncViewer : Type Base :: VncViewerMain ;

Type : VncViewerType ;

VncViewerType : Opt* :: _VncViewerType ;

Opt : MOpt* OptionsFeat :: OptionsMenuFeatures
	| ButtonFeature
	| ClipboardFeat
	| RecordingFeat ;

MOpt : OpEncodingFeat
	| OpCompressionFeat
	| OpJPEGqualityFeat
	| OpCursorShapeFeat
	| OpCopyRectFeat
	| OpRestrictedColorsFeat
	| OpMouse23Feat
	| OpViewFeat
	| OpShareFeat ;

ButtonFeature : BOpt* :: _ButtonFeature ;

BOpt : AboutButtonFeat
	| AltTabButtonFeat
	| RefreshButtonFeat
	| CtrlAltDelButtonFeat
	| RecordButtonFeat
	| ClipboardButtonFeat
	| OptionsButtonFeat
	| DisconnectButtonFeat ;

%%

RecordButtonFeat implies RecordingFeat ;
OptionsButtonFeat implies OptionsFeat ;
ClipboardButtonFeat implies ClipboardFeat ;

