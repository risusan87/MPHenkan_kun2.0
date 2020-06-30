package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds Byte
 * 
 * @author risusan87
 */
public class ByteTag extends Tag {

	private byte b;

	/**
	 * Creates new tag of byte.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setbyte - byte to be set
	 */
	public ByteTag(@Nullable String par1name, byte par2setbyte) {
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
				nbt.put(tag.getTagID())
				.put(StringTag.toNBTByteTag(tag.Tag_name));
			nbt.put(b);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Byte tagComponent() {
		return b;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x01;
	}
	
}