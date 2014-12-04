/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.constraints.bcl;
// Generated from TestData/BCL.g4 by ANTLR 4.0

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class BCLBaseListener implements BCLListener {
	@Override public void enterExpPlusMin(BCLParser.ExpPlusMinContext ctx) { }
	@Override public void exitExpPlusMin(BCLParser.ExpPlusMinContext ctx) { }

	@Override public void enterLiteralexp(BCLParser.LiteralexpContext ctx) { }
	@Override public void exitLiteralexp(BCLParser.LiteralexpContext ctx) { }

	@Override public void enterConstraint(BCLParser.ConstraintContext ctx) { }
	@Override public void exitConstraint(BCLParser.ConstraintContext ctx) { }

	@Override public void enterExpMulDiv(BCLParser.ExpMulDivContext ctx) { }
	@Override public void exitExpMulDiv(BCLParser.ExpMulDivContext ctx) { }

	@Override public void enterExpLogImplies(BCLParser.ExpLogImpliesContext ctx) { }
	@Override public void exitExpLogImplies(BCLParser.ExpLogImpliesContext ctx) { }

	@Override public void enterExpLogOr(BCLParser.ExpLogOrContext ctx) { }
	@Override public void exitExpLogOr(BCLParser.ExpLogOrContext ctx) { }

	@Override public void enterExpterm(BCLParser.ExptermContext ctx) { }
	@Override public void exitExpterm(BCLParser.ExptermContext ctx) { }

	@Override public void enterExpLogIff(BCLParser.ExpLogIffContext ctx) { }
	@Override public void exitExpLogIff(BCLParser.ExpLogIffContext ctx) { }

	@Override public void enterExpRel(BCLParser.ExpRelContext ctx) { }
	@Override public void exitExpRel(BCLParser.ExpRelContext ctx) { }

	@Override public void enterExpLogUn(BCLParser.ExpLogUnContext ctx) { }
	@Override public void exitExpLogUn(BCLParser.ExpLogUnContext ctx) { }

	@Override public void enterExpLogAnd(BCLParser.ExpLogAndContext ctx) { }
	@Override public void exitExpLogAnd(BCLParser.ExpLogAndContext ctx) { }

	@Override public void enterVspec(BCLParser.VspecContext ctx) { }
	@Override public void exitVspec(BCLParser.VspecContext ctx) { }

	@Override public void enterExpAriUnary(BCLParser.ExpAriUnaryContext ctx) { }
	@Override public void exitExpAriUnary(BCLParser.ExpAriUnaryContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
