// Define a grammar called BCL
// This grammar might be possible to evaluate using a SAT solver.
grammar BCL;

constraint : ('context' vspec 'inv' ':')? expLog;

// exps
expLog : expLog opLog expRel
	| expLog opLog expLogPart
	| expRel (opLog expRel)?
	| expLogPart;

expLogPart : opUnLog? '(' (expLog | expRel) ')'
	| (opUnLog | opDef)? vspec;
	
expRel : expMulDiv opRel expMulDiv;

expMulDiv : expMulDiv opAriMulDiv expPlusMin
	| expPlusMin;

expPlusMin : expPlusMin opAriPlusMinus expAriUnary
	| expAriUnary;

expAriUnary : opUnAri? expterm;

expterm : vspec | literalexp | '(' expMulDiv ')';

// Operators
opUnLog : 'not';
opDef : 'isDefined' | 'isUndefined';
opUnAri : '-';
opLog : 'and' | 'or' | 'implies' | 'xor' | 'iff';
opRel : '=' | '<=' | '>=' | '<' | '>';
opAriMulDiv : '*' | '/';
opAriPlusMinus : '+' | '-';

// Terminals
vspec : ID
	| ID '.' vspec;

literalexp : NUMBER
	| StringLiteral
	| 'true' | 'false';

// VSpec names are composed of letters, digits, and underscores. Name cannot start with a digit.
ID : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

// <Number> must be real number, unlimited natural, or integer number
NUMBER : [0-9]+ ('.' [0-9]+)?;

// String: Using Java's standard
StringLiteral : '"' ( EscapeSequence | ~('\\'|'"') )* '"';
fragment EscapeSequence : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
	| UnicodeEscape
	| OctalEscape;

fragment OctalEscape : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
	| '\\' ('0'..'7') ('0'..'7')
	| '\\' ('0'..'7');

fragment UnicodeEscape : '\\' 'u' HexDigit HexDigit HexDigit HexDigit;

fragment HexDigit : ('0'..'9'|'a'..'f'|'A'..'F');

// skip spaces, tabs, newlines
WS : [ \r\t\u000C\n]+ -> channel(HIDDEN);
