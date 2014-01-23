EclipseSPL : WindowingSystem OS_ Hardware Team EclipseFileSystem :: _EclipseSPL ;

WindowingSystem : Win32
	| GTK
	| Motif
	| Carbon
	| Cocoa ;

OS_ : OS :: _OS_ ;

OS : OS_Win32
	| Linux
	| MacOSX
	| Solaris
	| AIX
	| hpux ;

Hardware : x86
	| x86_64
	| SPARC
	| PPC
	| PPC64
	| ia64_32
	| s390
	| s390x ;

Team : [CVS] [SVN] [GIT] :: _Team ;

CVS : [CVS_Over_SSH] :: _CVS ;

CVS_Over_SSH : [CVS_Over_SSH2] :: _CVS_Over_SSH ;

SVN : Subversive
	| Subclipse ;

Subclipse : Subclipse_1_4_x
	| Subclipse_1_6_x ;

EclipseFileSystem : Local [Zip] :: _EclipseFileSystem ;

%%

Carbon and MacOSX and x86 or Cocoa and MacOSX and (x86 or x86_64) or GTK and Linux and PPC or GTK and Linux and PPC64 or GTK and Linux and s390 or GTK and Linux and s390x or GTK and Linux and x86 or GTK and Linux and x86_64 or GTK and Solaris and SPARC or GTK and Solaris and x86 or Motif and AIX and PPC or Motif and hpux and ia64_32 or Motif and Linux and x86 or Win32 and OS_Win32 and x86 or Win32 and OS_Win32 and x86_64 ;

