package com.ziggy192.apacheObjectPoolExample;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ParserFactory<E,T> extends BasePooledObjectFactory<Parser<E,T>> {


	@Override
	public Parser<E, T> create() throws Exception {
		return new XmlParser<E,T>();
	}

	@Override
	public PooledObject<Parser<E, T>> wrap(Parser<E, T> obj) {
		return new DefaultPooledObject<>(obj);
	}

	@Override
	public void passivateObject(PooledObject<Parser<E, T>> p) throws Exception {
		p.getObject().reset();
	}

	@Override
	public boolean validateObject(PooledObject<Parser<E, T>> p) {
		return p.getObject().isValid();
	}
}
