package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListTag<T extends Tag> extends Tag {

	private List<T> list;
	
	public ListTag(String par1name) {
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
