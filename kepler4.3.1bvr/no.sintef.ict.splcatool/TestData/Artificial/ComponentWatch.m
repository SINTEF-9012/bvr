WatchAPI : WatchSimulator WatchApplication+ :: _WatchAPI ;

WatchApplication : Edit
	| Stopwatch
	| Simple ;

Edit : EditableApplication+ :: _Edit ;

EditableApplication : Time
	| Timer
	| Alarmclock
	| Worldtime ;

Time : Time_v1 | Time_v2;
