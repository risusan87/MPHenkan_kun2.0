package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.function.Function;

/**
 * One of nbt tags. Holds 0 as end sign of compound tags
 * @author risusan87
 */
public class EndTag extends Tag {
	
	public EndTag() {
		super(null);
	}

	@Override
	public type setType() {
		return type.END;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			return new byte[] {0};
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Byte tagComponent() {
		return (byte)0x00;
	}

	@Override
	protected byte getTagID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}