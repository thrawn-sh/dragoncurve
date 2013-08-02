package de.shadowhunt.fractal.dragoncurve.logic;

public class AreaSettings {

	private final int hight;

	private final int startX;

	private final int startY;

	private final int width;

	public AreaSettings(final int width, final int hight, final int startX, final int startY) {
		this.width = width;
		this.hight = hight;
		this.startX = startX;
		this.startY = startY;
	}

	public int getHight(final int scale) {
		return hight * scale;
	}

	public int getStartX(final int scale) {
		return startX * scale;
	}

	public int getStartY(final int scale) {
		return startY * scale;
	}

	public int getWidth(final int scale) {
		return width * scale;
	}
}
