package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags that holds ByteArray
 * 
 * @author risusan87
 */
public class ByteArrayTag extends Tag implements Tag.TagArray {

	private List<Byte> barray;
	
	/**
	 * Creates new tag of byte array.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par1b - initial data to be contained
	 */
	public ByteArrayTag(@Nullable String par1name, byte[] par1b) {
		super(par1name);
		this.barray = new ArrayList<Byte>();
		if (par1b != null)
			for (byte b : par1b)
				this.barray.add(b);
	}

	@Override
	protected tagID setType() {
		return tagID.BYTE_ARRAY;
	}
	
	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null)
				nbt.put(tag.getTagID())
				.put(StringTag.toNBTByteTag(tag.Tag_name));
			List<Byte> l = ((ByteArrayTag)tag).tagComponent();
			nbt.putInt(l.size());
			if (l.size() == 0)
				nbt.put(new EndTag().toByteArray());
			else
				for (byte b : l)
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
		return 0x01;
	}

	@Override
	protected byte getTagID() {
		return (byte)0x07;
	}
	
}
