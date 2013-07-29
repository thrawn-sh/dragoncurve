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

	private final JSlider slider;

	private final DragenCanvas canvas;

	public GoAction(final JSlider slider, final DragenCanvas canvas) {
		super("Go");
		this.slider = slider;
		this.canvas = canvas;

		putValue(Action.SHORT_DESCRIPTION, "Paint the Dragon");
	}

	public void actionPerformed(final ActionEvent e) {
		final int dimension = slider.getValue();

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JComponent source = (JComponent) e.getSource();
				slider.setEnabled(false);
				source.setEnabled(false);
				final Iterator<Direction> it = DragonIterator.getIteratorForDimension(dimension);
				canvas.init(400, 400);
				canvas.revalidate();
				while (it.hasNext()) {
					canvas.setDirection(it.next());
					canvas.repaint();
				}
				slider.setEnabled(true);
				source.setEnabled(true);
			}});


	}
}
