package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 * One of nbt tags. Holds Byte
 * @author risusan87
 */
public class ByteTag extends Tag {

	private byte b;
	
	/**
	 * 
	 * @param par1name
	 * @param par2setbyte
	 */
	public ByteTag(String par1name, byte par2setbyte) {
		super(par1name);
		this.b = par2setbyte;
	}

	@Override
	public tagID setType() {
		return tagID.BYTE;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null)
				nbt.put(this.getTagID())
				.put(StringTag.toNBTByteTag(tag.Tag_name));
			nbt.put(b);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized Byte tagComponent() {
		return b;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x01;
	}
	
}