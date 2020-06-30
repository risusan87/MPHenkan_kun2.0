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
		if (this.Tag_name.equals(""))
			this.Tag_name = "(unnamed)";
		else if (this.Tag_name == null) {
			this.Tag_name = "";
			this.isNull = true;
		}
		this.tags = new ArrayList<Tag>();
	}
	
	@Override
	public tagID setType() {
		return tagID.COMPOUND;
	}
	
	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put(tag.getTagID());
			if (tag.Tag_name.equals(""))
				nbt.putInt(0x00)
				.put(new EndTag().toByteArray());
			else
				nbt.put(StringTag.toNBTByteTag(tag.Tag_name));
			for (Tag t : ((CompoundTag)tag).tags)
				nbt.put(t.toByteArray());
			nbt.put(new EndTag().toByteArray());
			return nbt.array();
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
