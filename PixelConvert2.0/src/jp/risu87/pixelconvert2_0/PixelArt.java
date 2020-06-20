package jp.risu87.pixelconvert2_0;

import java.io.File;

/**
 * Reads schematic file as Pixel art, for this program.
 * <p>Date created: 2020/06/15
 * @author risu
 *
 */
public class PixelArt extends Schematic {
	public static final int m_multiplier = 128;
	
	//how many maps be used
	private int m_width = 1;
	private int m_height = 1;
		
	//resolution of an image: 1 pixel = 1 block
	private int r_width = m_multiplier;
	private int r_heihgt = m_multiplier;
	
	public PixelArt (File par1pixelartchematic) {
		super(par1pixelartchematic, ".pixart");
	}
}
