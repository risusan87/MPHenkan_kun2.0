package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds float
 * 
 * @author risusan87
 */
public class FloatTag extends Tag {

	private float f;
	
	/**
	 * Creates new tag of float.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setbyte - float to be set
	 */
	public FloatTag(@Nullable String par1name, @Nonnull float par2setfloat) {
		super(par1name);
		this.f = par2setfloat;
	}

	@Override
	public tagID setType() {
		return tagID.FLOAT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null)
				nbt.put(tag.getTagID())
				.put(StringTag.toNBTByteTag(tag.Tag_name));
			nbt.putFloat((float)tag.tagComponent());
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Float tagComponent() {
		return this.f;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x05;
	}

}
