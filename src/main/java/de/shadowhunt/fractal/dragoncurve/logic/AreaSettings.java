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

public class AreaSettings {

	private final int hight;

	private final int startX;

	private final int startY;

	private final int width;

	public AreaSettings(final int width, final int hight, final int startX, final int startY) {
		this.width = width;
		this.hight = hight;
		this.startX = startX;
		this.startY = startY;
	}

	public int getHight(final int scale) {
		return hight * scale;
	}

	public int getStartX(final int scale) {
		return startX * scale;
	}

	public int getStartY(final int scale) {
		return startY * scale;
	}

	public int getWidth(final int scale) {
		return width * scale;
	}
}
