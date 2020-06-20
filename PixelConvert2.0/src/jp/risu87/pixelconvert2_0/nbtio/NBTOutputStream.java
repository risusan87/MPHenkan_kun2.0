package jp.risu87.pixelconvert2_0.nbtio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import jp.risu87.pixelconvert2_0.nbtio.tag.NBT;

public class NBTOutputStream extends ByteArrayOutputStream {
	/**
	 * The preferred method to write NBT tag onto stream
	 * @param par1nbt
	 */
	public void writeNBT(NBT par1nbt) {
		try (
			GZIPOutputStream zout = new GZIPOutputStream(this)
		){
			byte[] nbt = par1nbt.toByteArray();
			zout.write(nbt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}