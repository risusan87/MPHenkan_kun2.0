package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * One of nbt tags that holds ByteArray
 * @author risusan87
 */
public class ByteArrayTag extends Tag implements Tag.TagArray {

	private List<Byte> barray;
	
	public ByteArrayTag(String par1name, byte[] par1b) {
		super(par1name);
		this.barray = new ArrayList<Byte>();
		for (byte b : par1b)
			this.barray.add(b);
	}

	@Override
	protected type setType() {
		return type.BYTE_ARRAY;
	}
	
	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x07)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.putInt(barray.size());
			byte[] b = new byte[barray.size()];
			for (int i = 0; i < barray.size(); i++)
				b[i] = barray.get(i);
			nbt.put(b);
			return nbt.array();
		};
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public synchronized List<Byte> tagComponent() {
		return this.barray;
	}

	@Override
	public int arraySize() {
		return this.barray.size();
	}

	@Override
	public int primitiveSize() {
		return 1;
	}
	
}
