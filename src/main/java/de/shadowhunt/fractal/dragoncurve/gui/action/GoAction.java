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
package de.shadowhunt.fractal.dragoncurve.gui.action;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import de.shadowhunt.fractal.dragoncurve.gui.DragenCanvas;
import de.shadowhunt.fractal.dragoncurve.logic.Direction;
import de.shadowhunt.fractal.dragoncurve.logic.DragonIterator;

public class GoAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private final DragenCanvas canvas;

	private final JSlider slider;

	public GoAction(final JSlider slider, final DragenCanvas canvas) {
		super("Go");
		this.slider = slider;
		this.canvas = canvas;

		putValue(Action.SHORT_DESCRIPTION, "Paint the Dragon");
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dimension = slider.getValue();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final JComponent source = (JComponent) e.getSource();
				slider.setEnabled(false);
				source.setEnabled(false);
				final Iterator<Direction> it = DragonIterator.getIteratorForDimension(dimension);
				canvas.init(400, 400);
				canvas.revalidate();
				while (it.hasNext()) {
					canvas.paintStep(it.next());
					canvas.repaint();
				}
				//				slider.setEnabled(true);
				//				source.setEnabled(true);
			}
		});

	}
}
