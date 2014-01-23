// Define a grammar called BCL
// This grammar might be possible to evaluate using a SAT solver.
grammar BCL;

constraint : ('context' vspec 'inv' ':')? expLogIff;

// exps
expLogIff : expLogIff 'iff' expLogImplies
	| expLogImplies;

expLogImplies : expLogImplies 'implies' expLogOr
	| expLogOr;

expLogOr : expLogOr ('or' | 'xor') expLogAnd
	| expLogAnd;

expLogAnd : expLogAnd 'and' expLogUn
	| expLogUn;

expLogUn : 'not'? '(' (expLogIff | expRel) ')'
	| ('not' | 'isDefined' | 'isUndefined')? vspec
	| expRel;
	
expRel : expPlusMin ('=' | '<=' | '>=' | '<' | '>') expPlusMin;

expPlusMin : expPlusMin ('+' | '-') expMulDiv
	| expMulDiv;

expMulDiv : expMulDiv ('*' | '/') expAriUnary
	| expAriUnary;

expAriUnary : '-'? expterm;

expterm : vspec | literalexp | '(' expPlusMin ')';

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
