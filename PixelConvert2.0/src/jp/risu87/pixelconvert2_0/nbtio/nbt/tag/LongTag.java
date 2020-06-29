package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.function.Function;

/**
 * 
 * tagID:02
 * @author risusan87
 */
public class LongTag extends Tag {

	public LongTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.LONG;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected byte getTagID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T tagComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
