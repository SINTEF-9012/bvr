RVM : [CrateUnit] BottleUnit Product_group :: _RVM ;

CrateUnit : [CRS2_ColorDetector] [CRS2_CrateScale] :: CRS2
	| [CRS3_ColorDetector] [CRS3_CrateScale] :: CRS3
	| [ColorCamera] [LogoCamera] [CamCrate_CrateScale] :: CamCrate ;

BottleUnit : Display [Scale] [Metal] [Barcode] [BMS] [SecurityMarkReader] Printer :: _BottleUnit ;

Display : Display2line
	| DisplayBW
	| DisplayColor
	| DisplayTouch ;

SecurityMarkReader : SMR1
	| SMR2 ;

Printer : Printer1 :: _Printer ;

Product_group : Machine_type_frontend Backroom :: FrontEnd
	| Machine_type_inpack LowerCabinet :: InPack ;

Machine_type_frontend : 
	RVM1
	| RVM2
	| RVM3
	| RVM4
	| RVM5;

Backroom : [SortingIntersection] Backroom_details :: _Backroom ;

Backroom_details : MasterPack
	| SoftDrop
	| [HSG] [SCC_L] [SCC_R] Termination :: Logistima
	| RaiserBord ;

MasterPack : LeftTurn
	| LeftStraight
	| RightTurn
	| RightStraight ;

HSG : [HSG_ekstra] :: _HSG ;

SCC_L : [SCC_L_ekstra] :: _SCC_L ;

SCC_R : [SCC_R_ekstra] :: _SCC_R ;

Termination : EBR_L
	| EBR_R
	| Logistima_SoftDrop ;

Machine_type_inpack : 
	MTI1
	| MTI2
	| MTI3
	| MTI4
	| MTI5
	| MTI6 ;

MTI5 : MTI5_SoftDrop :: _MTI5 ;

LowerCabinet : Single
	| Dual ;

%%

SecurityMarkReader implies Barcode ;
ColorCamera iff LogoCamera ;
RVM1 implies DisplayBW ;
RVM1 and CrateUnit implies CRS2 ;
RVM2 implies DisplayColor ;
RVM2 and CrateUnit implies CRS2 ;
RVM3 implies DisplayColor or DisplayTouch ;
RVM3 and CrateUnit implies CamCrate ;
RVM4 implies Display2line ;
RVM4 and CrateUnit implies CRS3 ;
MTI1 implies DisplayBW ;
MTI2 implies DisplayColor ;
MTI3 implies DisplayBW ;
MTI5 implies DisplayColor ;
MTI6 implies DisplayColor ;
MTI6 implies not SoftDrop and Single ;

