package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * One of nbt tags. Holds Int array
 * @author risusan87
 */
public class IntArrayTag extends Tag implements Tag.TagArray {
	
	private List<Integer> iarray;
	
	public IntArrayTag(String par1name, int[] par2array) {
		super(par1name);
		this.iarray = new ArrayList<Integer>();
		for (int i : par2array)
			this.iarray.add(i);
	}

	@Override
	public type setType() {
		return type.INT_ARRAY;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x0B)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.putInt(iarray.size());
			for (int i : this.iarray)
				nbt.putInt(i);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized List<Integer> tagComponent() {
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

}
