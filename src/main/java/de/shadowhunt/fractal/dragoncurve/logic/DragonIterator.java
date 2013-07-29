/*
 * #%L
 * Shadowhunt Fractal
 * %%
 * Copyright (C) 2013 shadowhunt
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
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
