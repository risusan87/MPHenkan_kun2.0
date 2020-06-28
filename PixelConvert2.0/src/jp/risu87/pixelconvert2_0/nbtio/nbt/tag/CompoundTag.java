package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * One of nbt tags. Holds multiple different types of nbt tag
 * @author risusan87
 */
public class CompoundTag extends Tag implements Tag.TagCompound {
	
	private final List<Tag> tags;
	
	public CompoundTag(String par1name) {
		super(par1name);
		this.tags = new ArrayList<Tag>();
	}
	
	@Override
	public type setType() {
		return type.COMPOUND;
	}
	
	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer bb = ByteBuffer.allocate(tag.getAllocatedByteSize());
			bb.put((byte)0x0a)
			.put(StringTag.toNBTByteTag(this.Tag_name));
			for (Tag t : ((CompoundTag)tag).tags)
				bb.put(t.toByteArray());
			bb.put((byte)0x00);
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
	
}
