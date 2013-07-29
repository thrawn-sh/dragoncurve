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
package de.shadowhunt.fractal.dragoncurve.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

import de.shadowhunt.fractal.dragoncurve.logic.Direction;

public class DragenCanvas extends JLabel {

	private static final int MIN_SIZE = 400;

	private static final long serialVersionUID = 1L;

	private static final int SIZE = 5;

	public static final int X_AXIS = 1;

	public static final int Y_AXIS = -1;

	protected int axis = X_AXIS;

	private Graphics dbGraphics;

	private Image dbImage;

	private Direction direction = null;

	protected int factor = 1;

	private int x = MIN_SIZE;

	private int y = MIN_SIZE;

	public DragenCanvas() {
		Dimension dimension = new Dimension(MIN_SIZE, MIN_SIZE);
		setMinimumSize(dimension);
		setPreferredSize(dimension);
	}

	public final void init(final int width, final int height) {
		dbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		dbGraphics = dbImage.getGraphics();

		x = width/2;
		y = height/2;

		dbGraphics.setColor(getForeground());
		dbGraphics.drawLine(x, y+SIZE, x, y);

		factor = 1;
		direction = null;
		axis = X_AXIS;
	}

	@Override
	public void paint(final Graphics g) {
//		super.paint(g); // don't reset g
		if (dbGraphics != null) {
			paint0(dbGraphics);
			g.drawImage(dbImage, 0, 0, this);
		}
	}

	protected void paint0(final Graphics g) {
		g.setColor(getForeground());

		final int d = (direction == Direction.RIGHT) ? factor : -factor;
		final int delta = d * SIZE;

		if (axis == X_AXIS) {
			g.drawLine(x, y, x + delta, y);
			x += delta;
		} else {
			g.drawLine(x, y, x, y + delta);
			y += delta;
		}
		factor = axis * d;
		axis = -axis; // toggle axis
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
