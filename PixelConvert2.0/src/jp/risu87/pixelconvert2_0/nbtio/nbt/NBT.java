package jp.risu87.pixelconvert2_0.nbtio.nbt;

import java.util.ArrayList;
import java.util.List;

import jp.risu87.pixelconvert2_0.nbtio.nbt.tag.CompoundTag;

public class NBT extends CompoundTag {
	private String format = null;
	
	public NBT(String par1name) {
		super(par1name);
	}
	
	public byte[] toByteArray() {
		return null;
	}
	
	public void setFormatProtocol(String par1format) {
		this.format = par1format;
	}
	
	public String getFormatProtocol() {
		return this.format;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
}
