package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds float
 * 
 * @author risusan87
 */
public class FloatTag extends Tag {

	private Float f = null;
	
	/**
	 * Creates new tag of float.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setfloat - float to be set
	 */
	public FloatTag(@Nullable String par1name, Float par2setfloat) {
		super(par1name);
		if (par2setfloat != null)
			this.f = par2setfloat;
		else
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.FLOAT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null) {
				nbt.put(tag.getTagID());
				if (tag.Tag_name.equals(""))
					nbt.putInt(0x00)
					.put(new EndTag().toByteArray());
				else
					nbt.put(StringTag.toNBTByteTag(tag.Tag_name));
			}
			if (!tag.isNull)
				nbt.putFloat((float)tag.tagComponent());
			else
				nbt.put(new EndTag().toByteArray());
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
