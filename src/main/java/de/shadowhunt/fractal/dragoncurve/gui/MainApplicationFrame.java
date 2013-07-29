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
package de.shadowhunt.fractal.dragoncurve.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

import de.shadowhunt.fractal.dragoncurve.gui.action.ExportMenu;
import de.shadowhunt.fractal.dragoncurve.gui.action.GoAction;
import de.shadowhunt.fractal.dragoncurve.gui.action.ShowAboutDialogAction;
import de.shadowhunt.fractal.dragoncurve.gui.action.TerminateGuiAction;


public class MainApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	protected final JPanel contentPanel = new JPanel(new CardLayout());

	public MainApplicationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(generateContentPane());
		setJMenuBar(generateMenuBar());
		setTitle("Dragon Curve");

		// default: center the frame on the screen
		setLocationRelativeTo(null);
	}

	private JPanel generateContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		//		pane.setBorder(ComponentFactory.EMPTY_BORDER);

		pane.add(generateToolBar(), BorderLayout.NORTH);
		pane.add(generateMainPane(), BorderLayout.CENTER);

		return pane;
	}

	private JMenu generateExportSubMenu() {
		JMenu menu = new JMenu(new ExportMenu());

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
		JPanel panel = new JPanel(new BorderLayout());

		DragenCanvas canvas = new DragenCanvas();
		panel.add(generateDimensionPane(canvas), BorderLayout.NORTH);
		panel.add(canvas, BorderLayout.CENTER);

		return panel;
	}

	private JComponent generateDimensionPane(final DragenCanvas canvas) {
		JPanel panel = new JPanel(new BorderLayout());

		JSlider slider = createDimensionSlider();
		JLabel label = new JLabel("Dimension: ");
		label.setLabelFor(slider);
		JButton button = new JButton(new GoAction(slider, canvas));
		
		panel.add(label, BorderLayout.WEST);
		panel.add(slider, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);
		
		return panel;
	}

	private JSlider createDimensionSlider() {
		JSlider dimensionSlider =  new JSlider(JSlider.HORIZONTAL, 1, 20, 1);
		dimensionSlider.setMajorTickSpacing(4);
		dimensionSlider.setPaintTicks(true);
		dimensionSlider.setPaintLabels(true);
		return dimensionSlider;
	}

	private JMenuBar generateMenuBar() {
		JMenuBar menubar = new JMenuBar();
		menubar.add(generateFileMenu());
		menubar.add(generateHelpMenu());
		return menubar;
	}

	private JToolBar generateToolBar() {
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		return toolbar;
	}
}