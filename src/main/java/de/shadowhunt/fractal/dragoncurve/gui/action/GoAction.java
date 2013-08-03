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
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import de.shadowhunt.fractal.dragoncurve.gui.DragonPane;
import de.shadowhunt.fractal.dragoncurve.logic.AreaSettings;
import de.shadowhunt.fractal.dragoncurve.logic.Direction;
import de.shadowhunt.fractal.dragoncurve.logic.DragonIterator;

public class GoAction extends AbstractAction {

	private static final class DragonWorker implements Runnable {

		private final JButton button;

		private final DragonPane pane;

		private final int dimension;

		private final AreaSettings settings;

		private final JSlider slider;

		protected DragonWorker(final int dimension, final AreaSettings settings, final DragonPane pane, final JSlider slider, final JButton button) {
			this.dimension = dimension;
			this.settings = settings;
			this.pane = pane;
			this.slider = slider;
			this.button = button;
		}

		@Override
		public void run() {
			slider.setEnabled(false);
			button.setEnabled(false);
			final Iterator<Direction> it = DragonIterator.getIteratorForDimension(dimension);
			pane.init(settings);
			pane.revalidate();
			while (it.hasNext()) {
				pane.paintStep(it.next());
				pane.repaint();
			}
			slider.setEnabled(true);
			button.setEnabled(true);
		}
	}

	private static final long serialVersionUID = 1L;

	private static final AreaSettings[] areaSettings = new AreaSettings[40];

	static {
		areaSettings[0] = new AreaSettings(0, 0, 0, 0);
		areaSettings[1] = new AreaSettings(1, 0, 0, 0);
		areaSettings[2] = new AreaSettings(2, 1, 0, 0);
		areaSettings[3] = new AreaSettings(2, 3, 0, 0);
		areaSettings[4] = new AreaSettings(3, 5, 1, 0);
		areaSettings[5] = new AreaSettings(7, 6, 5, 0);
		areaSettings[6] = new AreaSettings(11, 7, 9, 1);
		areaSettings[7] = new AreaSettings(12, 15, 10, 9);
		areaSettings[8] = new AreaSettings(15, 23, 10, 17);
		areaSettings[9] = new AreaSettings(31, 26, 10, 20);
		areaSettings[10] = new AreaSettings(47, 31, 10, 20);
		areaSettings[11] = new AreaSettings(52, 63, 10, 20);
		areaSettings[12] = new AreaSettings(63, 95, 21, 20);
		areaSettings[13] = new AreaSettings(127, 106, 85, 20);
		areaSettings[14] = new AreaSettings(191, 127, 149, 41);
		areaSettings[15] = new AreaSettings(212, 255, 170, 169);
		areaSettings[16] = new AreaSettings(255, 383, 170, 297);
		areaSettings[17] = new AreaSettings(511, 426, 170, 340);
		areaSettings[18] = new AreaSettings(767, 511, 170, 340);
		areaSettings[19] = new AreaSettings(852, 1023, 170, 340);
		areaSettings[20] = new AreaSettings(1023, 1535, 341, 340);
		areaSettings[21] = new AreaSettings(2047, 1706, 1365, 340);
		areaSettings[22] = new AreaSettings(3071, 2047, 2389, 681);
		areaSettings[23] = new AreaSettings(3412, 4095, 2730, 2729);
		areaSettings[24] = new AreaSettings(4095, 6143, 2730, 4777);
		areaSettings[25] = new AreaSettings(8191, 6826, 2730, 5460);
		areaSettings[26] = new AreaSettings(12287, 8191, 2730, 5460);
		areaSettings[27] = new AreaSettings(13652, 16383, 2730, 5460);
		areaSettings[28] = new AreaSettings(16383, 24575, 5461, 5460);
		areaSettings[29] = new AreaSettings(32767, 27306, 21845, 5460);
		areaSettings[30] = new AreaSettings(49151, 32767, 38229, 10921);
		areaSettings[31] = new AreaSettings(54612, 65535, 43690, 43689);
		areaSettings[32] = new AreaSettings(65535, 98303, 43690, 76457);
		areaSettings[33] = new AreaSettings(131071, 109226, 43690, 87380);
		areaSettings[34] = new AreaSettings(196607, 131071, 43690, 87380);
		areaSettings[35] = new AreaSettings(218452, 262143, 43690, 87380);
		areaSettings[36] = new AreaSettings(262143, 393215, 87381, 87380);
	}

	private final DragonPane pane;

	private final JSlider slider;

	public GoAction(final JSlider slider, final DragonPane pane) {
		super("Go");
		this.slider = slider;
		this.pane = pane;

		putValue(Action.SHORT_DESCRIPTION, "Paint the Dragon");
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dimension = slider.getValue();
		SwingUtilities.invokeLater(new DragonWorker(dimension, getAreaSettings(dimension), pane, slider, (JButton) e.getSource()));
	}

	protected AreaSettings getAreaSettings(final int dimension) {
		return areaSettings[dimension];
	}
}
