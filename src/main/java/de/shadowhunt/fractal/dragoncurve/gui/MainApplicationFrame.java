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
package de.shadowhunt.fractal.dragoncurve.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import de.shadowhunt.fractal.dragoncurve.gui.action.ExportMenu;
import de.shadowhunt.fractal.dragoncurve.gui.action.GoAction;
import de.shadowhunt.fractal.dragoncurve.gui.action.ShowAboutDialogAction;
import de.shadowhunt.fractal.dragoncurve.gui.action.TerminateGuiAction;

public class MainApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainApplicationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(generateContentPane());
		setJMenuBar(generateMenuBar());
		setTitle("Dragon Curve");

		// default: center the frame on the screen
		setLocationRelativeTo(null);
	}

	private JSlider createDimensionSlider() {
		final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 1, 36, 1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		final Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
		labels.put(1, new JLabel(Integer.toString(1)));
		for (int i = 5; i <= 35; i += 5) {
			labels.put(i, new JLabel(Integer.toString(i)));
		}
		slider.setLabelTable(labels);
		return slider;
	}

	private JPanel generateContentPane() {
		final JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		pane.add(generateToolBar(), BorderLayout.NORTH);
		pane.add(generateMainPane(), BorderLayout.CENTER);

		return pane;
	}

	private JComponent generateDimensionPane(final DragonPane pane) {
		final JPanel panel = new JPanel(new BorderLayout());

		final JSlider slider = createDimensionSlider();
		final JLabel label = new JLabel("Dimension: ");
		label.setLabelFor(slider);
		final JButton button = new JButton(new GoAction(slider, pane));

		panel.add(label, BorderLayout.WEST);
		panel.add(slider, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);

		return panel;
	}

	private JMenu generateExportSubMenu() {
		final JMenu menu = new JMenu(new ExportMenu());

		return menu;
	}

	private JMenu generateFileMenu() {
		final JMenu menu = new JMenu();
		menu.setText("File");
		menu.setMnemonic(KeyEvent.VK_F);

		menu.add(generateExportSubMenu());
		menu.addSeparator();
		menu.add(new TerminateGuiAction(this));

		return menu;
	}

	private JMenu generateHelpMenu() {
		final JMenu menu = new JMenu();
		menu.setText("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		menu.add(new ShowAboutDialogAction(menu));

		return menu;
	}

	private JComponent generateMainPane() {
		final JPanel panel = new JPanel(new BorderLayout());

		final DragonPane pane = new DragonPane();
		panel.add(generateDimensionPane(pane), BorderLayout.NORTH);

		final JScrollPane scrollPane = new JScrollPane(pane);
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}

	private JMenuBar generateMenuBar() {
		final JMenuBar menubar = new JMenuBar();
		menubar.add(generateFileMenu());
		menubar.add(generateHelpMenu());
		return menubar;
	}

	private JToolBar generateToolBar() {
		final JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		return toolbar;
	}
}
