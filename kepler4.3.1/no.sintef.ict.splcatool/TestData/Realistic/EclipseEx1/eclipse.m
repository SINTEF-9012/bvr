EclipseIDE : RCP_Platform :: _EclipseIDE ;

RCP_Platform : [JDT] [EMF] [GEF] [CDT] [CVS] [WebTools] [LinuxTools] [JavaEETools] [XMLTools] [MDT] [Mylyn] [PTP] [Jubula] [RAP] [EGit] [RSE] [EclipseLink] [WindowBuilder] :: _RCP_Platform ;

JDT : [PDE] [Maven] :: _JDT ;

PDE : [Scout] :: _PDE ;

EMF : [GMF] [Datatools] :: _EMF ;

Datatools : [BIRT] :: _Datatools ;

%%

GMF implies GEF ;
Maven implies EMF ;
BIRT implies GEF and JDT and PDE ;

