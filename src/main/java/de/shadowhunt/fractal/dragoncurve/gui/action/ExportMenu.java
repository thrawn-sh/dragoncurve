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

import javax.swing.AbstractAction;
import javax.swing.Action;

public final class ExportMenu extends AbstractAction {

	//	public static final String ICON = "de.shadowhunt.addressbook.swing.action.export";

	private static final long serialVersionUID = 1L;

	public ExportMenu() {
		super("Export");

		putValue(Action.SHORT_DESCRIPTION, "export addressbook to other formats");
		//		putValue(Action.SMALL_ICON, Icons.getIcon(ICON));
		//		putValue(Action.LARGE_ICON_KEY, Icons.getIcon(ICON));
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// nothing to do
	}
}
