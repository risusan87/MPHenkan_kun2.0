package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

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

}
