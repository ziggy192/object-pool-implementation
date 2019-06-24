package com.ziggy192.apacheObjectPoolExample;

public interface Parser<E,T> {
	public void parse(E elementToBeParsed, T result) throws Exception;

	public boolean isValid();


	public void reset();
}
