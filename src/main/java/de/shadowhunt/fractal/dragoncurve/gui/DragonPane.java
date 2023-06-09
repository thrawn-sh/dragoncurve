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
package de.shadowhunt.fractal.dragoncurve.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import de.shadowhunt.fractal.dragoncurve.logic.AreaSettings;
import de.shadowhunt.fractal.dragoncurve.logic.Direction;

public class DragonPane extends JComponent {

	private static final int MIN_SIZE = 400;

	private static final long serialVersionUID = 1L;

	public static final int SIZE = 5;

	public static final int X_AXIS = 1;

	public static final int Y_AXIS = -1;

	private int axis = X_AXIS;

	private Graphics dbGraphics;

	private Image dbImage;

	private int factor = 1;

	private int x = MIN_SIZE;

	private int y = MIN_SIZE;

	public DragonPane() {
		setPreferredSize(new Dimension(MIN_SIZE, MIN_SIZE));
	}

	public void init(final AreaSettings settings) {
		final int border = 10 * SIZE;
		final int width = settings.getWidth(SIZE) + (2 * border);
		final int height = settings.getHight(SIZE) + (2 * border);
		dbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		dbGraphics = dbImage.getGraphics();

		x = settings.getStartX(SIZE) + border;
		y = settings.getStartY(SIZE) + border;

		dbGraphics.setColor(getForeground());
		dbGraphics.drawLine(x, y + SIZE, x, y);

		factor = 1;
		axis = X_AXIS;

		setPreferredSize(new Dimension(width, height));
		revalidate();
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		if (dbImage != null) {
			g.drawImage(dbImage, 0, 0, this);
		}
	}

	public void paintStep(final Direction direction) {
		dbGraphics.setColor(getForeground());

		final int d = (direction == Direction.RIGHT) ? factor : -factor;
		final int delta = d * SIZE;

		if (axis == X_AXIS) {
			dbGraphics.drawLine(x, y, x + delta, y);
			x += delta;
		} else {
			dbGraphics.drawLine(x, y, x, y + delta);
			y += delta;
		}
		factor = axis * d;
		axis = -axis; // toggle axis
	}
}
