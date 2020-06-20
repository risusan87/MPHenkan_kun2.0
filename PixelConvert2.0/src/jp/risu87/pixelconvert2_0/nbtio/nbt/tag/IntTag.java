package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

/**
 * 
 * tagID:03
 * @author risusan87
 */
public class IntTag extends Tag {
	
	public IntTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.INT;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}
	
}
