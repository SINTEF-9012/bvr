/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2015  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */
package org.prop4j;

import java.util.List;

/**
 * A constraint that is true iff both children have the same boolean value.
 * 
 * @author Thomas Thuem
 */
public class Equals extends Node {
	
	public Equals(Object leftChild, Object rightChild) {
		setChildren(leftChild, rightChild);
	}
	
	@Override
	protected Node eliminate(List<Class<? extends Node>> list) {
		super.eliminate(list);
		if (list.contains(getClass()))
			return new And(new Or(new Not(children[0].clone()), children[1]),
					new Or(new Not(children[1].clone()), children[0]));
		return this;
	}
	
	@Override
	public Node clone() {
		return new Equals(children[0].clone(), children[1].clone());
	}
	
}
