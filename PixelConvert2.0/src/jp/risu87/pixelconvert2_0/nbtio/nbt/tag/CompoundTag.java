package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds multiple different types of nbt tag
 * 
 * @author risusan87
 */
public class CompoundTag extends Tag implements Tag.TagCompound {
	
	private final List<Tag> tags;
	
	/**
	 * Creates new tag of compound.
	 * Compound tag acts like folders that contains multiple different kinds of tag.
	 * This tag can not be put in a ListTag
	 * 
	 * @param par1name - tag name
	 */
	public CompoundTag(@Nullable String par1name) {
		super(par1name);
		if (this.Tag_name == null || this.Tag_name.equals(""))
			this.Tag_name = "(unnamed)";
		this.tags = new ArrayList<Tag>();
	}
	
	@Override
	public tagID setType() {
		return tagID.COMPOUND;
	}
	
	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer bb = ByteBuffer.allocate(tag.getAllocatedByteSize());
			bb.put(tag.getTagID())
			.put(StringTag.toNBTByteTag(tag.Tag_name));
			for (Tag t : ((CompoundTag)tag).tags)
				bb.put(t.toByteArray());
			bb.put(new EndTag().toByteArray());
			return bb.array();
		};
	}

	@Override
	public int getElementCount() {
		return this.tags.size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized List<Tag> tagComponent() {
		return this.tags;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x0A;
	}
	
}
