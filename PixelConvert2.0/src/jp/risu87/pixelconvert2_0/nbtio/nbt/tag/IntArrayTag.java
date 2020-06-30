package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds Int array
 * 
 * @author risusan87
 */
public class IntArrayTag extends Tag implements Tag.TagArray {
	
	private List<Integer> iarray;
	
	/**
	 * Creates new tag of int array.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setbyte - int array to be set
	 */
	public IntArrayTag(@Nullable String par1name, int[] par2array) {
		super(par1name);
		this.iarray = new ArrayList<Integer>();
		//possibly this if condition is the problem if anything goes wrong in this class
		if (par2array != null)
			for (int i : par2array)
				this.iarray.add(i);
		else
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.INT_ARRAY;
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
			int size = ((Tag.TagArray)tag).arraySize();
			nbt.putInt(size);
			if (size != 0)
				for (int i : ((IntArrayTag)tag).tagComponent())
					nbt.putInt(i);
			else
				nbt.put(new EndTag().toByteArray());
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> tagComponent() {
		return this.iarray;
	}

	@Override
	public int arraySize() {
		return this.iarray.size();
	}

	@Override
	public int primitiveSize() {
		return 4;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x0B;
	}

}
