/*
 * #%L
 * Shadowhunt Fractal
 * %%
 * Copyright (C) 2013 shadowhunt
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package de.shadowhunt.fractal.dragoncurve.logic;

import java.util.Iterator;

public class DragonIterator implements Iterator<Direction> {

	public static Iterator<Direction> getIteratorForDimension(final int dimension) {
		long max = Double.valueOf(Math.pow(2.0, dimension)).longValue() - 1;
		return new DragonIterator(max);
	}
	
	private final long max;

	private long n = 1;

	DragonIterator(final long max) {
		this.max = max;
	}
	
	@Override
	public boolean hasNext() {
		return n <= max;
	}

	@Override
	public Direction next() {
		Direction d = Direction.RIGHT;
		if ((((n & -n) << 1) & n) != 0L) {
			d = Direction.LEFT;
		}
		n++;
		return d;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("can't delete from " + DragonIterator.class.getSimpleName());	
	}
}