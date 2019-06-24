package com.ziggy192.apacheObjectPoolExample;

public class XmlParser<E,T> implements Parser<E,T> {


	private Exception exception;

	@Override
	public void parse(E elementToBeParsed, T result)  throws Exception{
		try {
			System.out.println(String.format("[%s]: Parser Instance:%s", Thread.currentThread().getName(), this));

			//doing some real stuff
			Thread.sleep(1000);
		} catch (Exception e) {
			exception = e;
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public boolean isValid() {

		return exception == null;
	}

	@Override
	public void reset() {
		exception = null;
	}
}
