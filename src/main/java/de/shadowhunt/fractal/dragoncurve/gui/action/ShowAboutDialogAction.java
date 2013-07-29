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

	public void actionPerformed(final ActionEvent e) {
		JFrame root = (JFrame) SwingUtilities.getRoot(component);
		JDialog dialog = new JDialog(root);
		dialog.setLocationRelativeTo(root);
		dialog.setTitle("About");

		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<center>");
		sb.append("<p><b>&copy Alexander Dreweke</b></p>");
		sb.append("<a href=\"mailto:alexander@dreweke.net\">alexander@dreweke.net</a>");

		sb.append("<p>2013");
		Calendar rightNow = Calendar.getInstance();
		if (rightNow.get(Calendar.YEAR) > 2013) {
			sb.append(" - ");
			sb.append(rightNow.get(Calendar.YEAR));
		}
		sb.append("</p>");

		sb.append("</center>");
		sb.append("</html>");

		JEditorPane pane = new JEditorPane("text/html", sb.toString());

		dialog.setContentPane(pane);

		dialog.setResizable(false);
		dialog.pack();
		dialog.setVisible(true);
	}
}