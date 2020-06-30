package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds long
 * 
 * @author risusan87
 */
public class LongTag extends Tag {

	private Long l = null;
	
	/**
	 * Creates new tag of long.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setln - long to be set
	 */
	public LongTag(@Nullable String par1name, Long par2setln) {
		super(par1name);
		if (par2setln != null)
			this.l = par2setln;
		else
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.LONG;
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
				nbt.putLong((long)tag.tagComponent());
			else
				nbt.put(new EndTag().toByteArray());
			return nbt.array();
		};
	}

	@Override
	protected byte getTagID() {
		return (byte)0x04;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long tagComponent() {
		return this.l;
	}

}
