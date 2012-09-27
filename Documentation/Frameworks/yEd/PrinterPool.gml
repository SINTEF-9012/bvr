Creator	"yFiles"
Version	"2.9"
graph
[
	hierarchic	1
	label	""
	directed	1
	node
	[
		id	0
		label	"PrinterPool [0..*]"
		graphics
		[
			x	93.0
			y	-72.0
			w	127.0
			h	30.0
			type	"rectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"PrinterPool [0..*]"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	1
		label	"Printer->max(resolution) <= 
Scanner->max(resolution)"
		graphics
		[
			x	339.5
			y	-37.0
			w	193.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"Printer->max(resolution) <= 
Scanner->max(resolution)"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	2
		label	"Printer[1..*]"
		graphics
		[
			x	4.0
			y	7.0
			w	100.0
			h	50.0
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"Printer[1..*]"
			fontSize	13
			fontStyle	"bold"
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	3
		label	"Scanner[0..*]"
		graphics
		[
			x	175.0
			y	7.5
			w	100.0
			h	49.0
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"Scanner[0..*]"
			fontSize	13
			fontStyle	"bold"
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	4
		label	"1..1"
		graphics
		[
			x	4.0
			y	44.5
			w	30.0
			h	25.0
			type	"triangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"1..1"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	5
		label	"1..1"
		graphics
		[
			x	175.0
			y	45.0
			w	30.0
			h	25.0
			type	"triangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"1..1"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	6
		label	"x300dpi"
		graphics
		[
			x	-105.0
			y	102.5
			w	76.0
			h	30.0
			type	"roundrectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"x300dpi"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	7
		label	"x600dpi"
		graphics
		[
			x	-6.0
			y	102.5
			w	76.0
			h	30.0
			type	"roundrectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"x600dpi"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	8
		label	"x1000dpi"
		graphics
		[
			x	93.0
			y	102.5
			w	76.0
			h	30.0
			type	"roundrectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"x1000dpi"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	9
		label	"x1000dpi"
		graphics
		[
			x	305.0
			y	102.5
			w	76.0
			h	30.0
			type	"roundrectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"x1000dpi"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	10
		label	"x300dpi"
		graphics
		[
			x	199.0
			y	102.5
			w	76.0
			h	30.0
			type	"roundrectangle"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"x300dpi"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	11
		label	"resolution = 300"
		graphics
		[
			x	-130.0
			y	169.5
			w	112.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"resolution = 300"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	12
		label	"resolution = 300"
		graphics
		[
			x	-6.0
			y	169.5
			w	112.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"resolution = 300"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	13
		label	"resolution = 300"
		graphics
		[
			x	118.0
			y	169.5
			w	112.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"resolution = 300"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	14
		label	"resolution = 300"
		graphics
		[
			x	252.0
			y	169.5
			w	112.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"resolution = 300"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	node
	[
		id	15
		label	"resolution = 1000"
		graphics
		[
			x	380.0
			y	169.5
			w	112.0
			h	30.0
			type	"parallelogram"
			fill	"#FFFFFF"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"resolution = 1000"
			fontSize	12
			fontName	"Dialog"
			model	"null"
		]
	]
	edge
	[
		source	0
		target	2
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	0
		target	1
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	0
		target	3
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	6
		target	4
		graphics
		[
			style	"dotted"
			fill	"#000000"
		]
	]
	edge
	[
		source	4
		target	7
		graphics
		[
			style	"dotted"
			fill	"#000000"
		]
	]
	edge
	[
		source	4
		target	8
		graphics
		[
			style	"dotted"
			fill	"#000000"
		]
	]
	edge
	[
		source	5
		target	10
		graphics
		[
			style	"dotted"
			fill	"#000000"
		]
	]
	edge
	[
		source	5
		target	9
		graphics
		[
			style	"dotted"
			fill	"#000000"
		]
	]
	edge
	[
		source	6
		target	11
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	7
		target	12
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	8
		target	13
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	10
		target	14
		graphics
		[
			fill	"#000000"
		]
	]
	edge
	[
		source	9
		target	15
		graphics
		[
			fill	"#000000"
		]
	]
]
