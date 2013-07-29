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
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
		putValue(Action.ACCELERATOR_KEY,keyStroke);

	}

	public void actionPerformed(final ActionEvent e) {
		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
	}
}