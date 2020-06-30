package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

public class ListTag<T extends Tag> extends Tag {

	private List<T> list;
	
	public ListTag(@Nullable String par1name) {
		super(par1name);
		this.list = new ArrayList<T>();
	}

	@Override
	public tagID setType() {
		return tagID.LIST;
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
			List<? extends Tag> listoflist = ((ListTag<?>)tag).tagComponent();
			int size = listoflist.size();
			nbt.put(listoflist.get(0).getTagID())
			.putInt(size);
			if (size != 0)
				for (Tag t : listoflist)
					nbt.put(t.toByteArray());
			else
				nbt.put(new EndTag().toByteArray());
			return nbt.array();
		};
	}

	@Override
	protected byte getTagID() {
		return (byte)0x09;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> tagComponent() {
		return this.list;
	}


}
