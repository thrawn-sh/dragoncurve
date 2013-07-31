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

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public final class TerminateGuiAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	protected final JFrame frame;

	public TerminateGuiAction(final JFrame frame) {
		super("Exit");

		assert (frame != null) : "frame == null";
		this.frame = frame;

		putValue(Action.SHORT_DESCRIPTION, "exit application");
		final KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
		putValue(Action.ACCELERATOR_KEY, keyStroke);

	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
	}
}
