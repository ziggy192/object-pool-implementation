package com.ziggy192.apacheObjectPoolExample;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ParserPool<E,T> extends GenericObjectPool<Parser<E , T >> {
	public ParserPool(PooledObjectFactory<Parser<E, T>> factory) {
		super(factory);
	}

	public ParserPool(PooledObjectFactory<Parser<E, T>> factory, GenericObjectPoolConfig<Parser<E, T>> config) {
		super(factory, config);
	}

	public ParserPool(PooledObjectFactory<Parser<E, T>> factory, GenericObjectPoolConfig<Parser<E, T>> config, AbandonedConfig abandonedConfig) {
		super(factory, config, abandonedConfig);
	}
}
