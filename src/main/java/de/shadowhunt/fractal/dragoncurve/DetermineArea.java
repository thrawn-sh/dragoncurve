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
package de.shadowhunt.fractal.dragoncurve;

import java.util.Iterator;

import de.shadowhunt.fractal.dragoncurve.logic.Direction;
import de.shadowhunt.fractal.dragoncurve.logic.DragonIterator;

public class DetermineArea {

	private int factor = 1;

	public static final int X_AXIS = 1;

	public static final int Y_AXIS = -1;

	private int axis = X_AXIS;

	private int x = 0;

	private int y = 0;

	private int minX = 0, maxX = 0;

	private int minY = 0, maxY = 0;

	public static void main(final String[] args) {
		for (int i = 1; i <= 40; i++) {
			new DetermineArea().paintStep(i);
		}
	}

	public void paintStep(final int dimension) {
		final Iterator<Direction> it = DragonIterator.getIteratorForDimension(dimension);
		while (it.hasNext()) {
			final Direction direction = it.next();
			final int d = (direction == Direction.RIGHT) ? factor : -factor;
			if (axis == X_AXIS) {
				x += d;
			} else {
				y += d;
			}
			factor = axis * d;
			axis = -axis; // toggle axis

			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}

		System.out.print("areaSettings[");
		System.out.print(dimension);
		System.out.print("] = new AreaSettings(");
		System.out.print(Math.abs(minX) + Math.abs(maxX));
		System.out.print(", ");
		System.out.print(Math.abs(minY) + Math.abs(maxY));
		System.out.print(", ");
		System.out.print(Math.abs(minX));
		System.out.print(", ");
		System.out.print(Math.abs(minY));
		System.out.println(");");
	}
}
