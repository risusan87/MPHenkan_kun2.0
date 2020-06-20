package jp.risu87.pixelconvert2_0;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

import jp.risu87.pixelconvert2_0.nbtio.tag.NBT;

/**
 * Class {@code Schematic} provides reading and writing NBT tags of schematic format.
 *  
 * <p>Date created: 2020/06/15
 * @author risusan87
 */
public class Schematic extends NBT {
	
	public Schematic() {
		super("schematic");
		
	}
	
}
