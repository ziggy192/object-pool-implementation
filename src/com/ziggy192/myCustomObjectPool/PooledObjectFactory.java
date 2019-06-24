package com.ziggy192.myCustomObjectPool;

public interface PooledObjectFactory<T> {
	PooledObject<T> makeObject() throws Exception;

	/**
	 * Destroys an instance no longer needed by the pool.
	 * <p>
	 * It is important for implementations of this method to be aware that there
	 * is no guarantee about what state <code>obj</code> will be in and the
	 * implementation should be prepared to handle unexpected errors.
	 * </p>
	 * <p>
	 * Also, an implementation must take in to consideration that instances lost
	 * to the garbage collector may never be destroyed.
	 * </p>
	 *
	 * @param p a {@code PooledObject} wrapping the instance to be destroyed
	 *
	 * @throws Exception should be avoided as it may be swallowed by
	 *    the pool implementation.
	 *
	 * @see #validateObject
	 * @see ObjectPool#invalidateObject
	 */
	void destroyObject(PooledObject<T> p) throws Exception;

	/**
	 * Ensures that the instance is safe to be returned by the pool.
	 *
	 * @param p a {@code PooledObject} wrapping the instance to be validated
	 *
	 * @return <code>false</code> if <code>obj</code> is not valid and should
	 *         be dropped from the pool, <code>true</code> otherwise.
	 */
	boolean validateObject(PooledObject<T> p);

	/**
	 * Reinitializes an instance to be returned by the pool.
	 *
	 * @param p a {@code PooledObject} wrapping the instance to be activated
	 *
	 * @throws Exception if there is a problem activating <code>obj</code>,
	 *    this exception may be swallowed by the pool.
	 *
	 * @see #destroyObject
	 */
	void activateObject(PooledObject<T> p) throws Exception;

	/**
	 * Uninitializes an instance to be returned to the idle object pool.
	 *
	 * @param p a {@code PooledObject} wrapping the instance to be passivated
	 *
	 * @throws Exception if there is a problem passivating <code>obj</code>,
	 *    this exception may be swallowed by the pool.
	 *
	 * @see #destroyObject
	 */
	void passivateObject(PooledObject<T> p) throws Exception;
}
