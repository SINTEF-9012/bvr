EclipseIDE : RCP_Platform :: _EclipseIDE ;

RCP_Platform : [JDT] [EMF] [GEF] [CDT] [CVS] [WebTools] [SVN] [Mylyn] [PTP] [Jubula] [RAP] [EGit] [RSE] [EclipseLink] [WindowBuilder] :: _RCP_Platform ;

JDT : [PDE] [Maven] :: _JDT ;

PDE : [Scout] :: _PDE ;

EMF : [GMF] [Datatools] :: _EMF ;

Datatools : [BIRT] :: _Datatools ;

SVN : SVN15
	| SVN16 ;

%%

GMF implies GEF ;
Maven implies EMF ;
BIRT implies GEF and JDT and PDE ;

