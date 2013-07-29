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
package de.shadowhunt.fractal.dragoncurve;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.shadowhunt.fractal.dragoncurve.gui.MainApplicationFrame;

public class Main {
	
	static {
		try {
			// set up native look and feel for SWING
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// ignore exception
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				final JFrame frame = new MainApplicationFrame();
				frame.pack();
				frame.validate();
				// prevent frame from collapsing
				Dimension size = frame.getPreferredSize();
				frame.setMinimumSize(size);
				frame.setVisible(true);
			}});
	}		
}
