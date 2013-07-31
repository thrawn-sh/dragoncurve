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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class ShowAboutDialogAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	protected final Component component;

	public ShowAboutDialogAction(final Component component) {
		super("About");
		this.component = component;

		putValue(Action.SHORT_DESCRIPTION, "show about dialog");
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final JFrame root = (JFrame) SwingUtilities.getRoot(component);
		final JDialog dialog = new JDialog(root);
		dialog.setLocationRelativeTo(root);
		dialog.setTitle("About");

		final StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<center>");
		sb.append("<p><b>&copy Alexander Dreweke</b></p>");
		sb.append("<a href=\"mailto:alexander@dreweke.net\">alexander@dreweke.net</a>");

		sb.append("<p>2013");
		final Calendar rightNow = Calendar.getInstance();
		if (rightNow.get(Calendar.YEAR) > 2013) {
			sb.append(" - ");
			sb.append(rightNow.get(Calendar.YEAR));
		}
		sb.append("</p>");

		sb.append("</center>");
		sb.append("</html>");

		final JEditorPane pane = new JEditorPane("text/html", sb.toString());

		dialog.setContentPane(pane);

		dialog.setResizable(false);
		dialog.pack();
		dialog.setVisible(true);
	}
}
