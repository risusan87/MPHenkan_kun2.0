package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds short
 * 
 * @author risusan87
 */
public class ShortTag extends Tag {
	
	private Short s;
	/**
	 * Creates new tag of short.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setshort - short to be set
	 */
	public ShortTag(@Nullable String par1name, Short par2setshort) {
		super(par1name);
		if (par2setshort != null)
			this.s = par2setshort;
		else 
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.SHORT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null) {
				nbt.put(tag.getTagID());
				if (tag.Tag_name.equals(""))
					nbt.putInt(0x00)
					.put(new EndTag().toByteArray());
				else
					nbt.put(StringTag.toNBTByteTag(tag.Tag_name));
			}
			if (!tag.isNull)
				nbt.putShort((short)tag.tagComponent());
			else
				nbt.put(new EndTag().toByteArray());
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
