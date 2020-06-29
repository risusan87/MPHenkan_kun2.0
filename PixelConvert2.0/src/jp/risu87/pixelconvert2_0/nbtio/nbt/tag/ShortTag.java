package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds short
 * 
 * @author risusan87
 */
public class ShortTag extends Tag {
	
	private short s;
	/**
	 * Creates new tag of short.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setshort - short to be set
	 */
	public ShortTag(@Nullable String par1name, @Nonnull short par2setshort) {
		super(par1name);
		this.s = par2setshort;
	}

	@Override
	public tagID setType() {
		return tagID.SHORT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null)
				nbt.put(tag.getTagID())
				.put(StringTag.toNBTByteTag(tag.Tag_name));
			nbt.putShort((short)tag.tagComponent());
			return nbt.array();
		};
	}

	@Override
	protected byte getTagID() {
		return (byte)0x02;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Short tagComponent() {
		return this.s;
	}

}
