package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds long array
 * 
 * @author risusan87
 */
public class LongArrayTag extends Tag implements Tag.TagArray {
	
	private final List<Long> larray;
	
	/**
	 * Creates new tag of long array.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setlarray - long array to be set
	 */
	public LongArrayTag(@Nullable String par1name, long[] par2setlarray) {
		super(par1name);
		this.larray = new ArrayList<Long>();
		if (par2setlarray != null)
			for (long l : par2setlarray)
				this.larray.add(l);
		else
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.LONG_ARRAY;
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
			List<Long> l = ((LongArrayTag)tag).tagComponent();
			int size = ((Tag.TagArray)tag).arraySize();
			nbt.putInt(size);
			if (size != 0)
				for (long lo : l)
					nbt.putLong(lo);
			else
				nbt.put(new EndTag().toByteArray());
			return nbt.array();
		};
	}

	@Override
	protected byte getTagID() {
		return (byte)0x0C;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> tagComponent() {
		return this.larray;
	}

	@Override
	public int arraySize() {
		return this.larray.size();
	}

	@Override
	public int primitiveSize() {
		return 8;
	}

}
