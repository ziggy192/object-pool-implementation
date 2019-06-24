package com.ziggy192.apacheObjectPoolExample;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxIdle(1);
		config.setMaxTotal(1);

		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);

		ParserPool<String, String> pool = new ParserPool<String, String>(new ParserFactory<>(), config);

		ExecutorService executorService = Executors.newFixedThreadPool(10);


		int useTime = 10;

		for (int i = 0; i < useTime; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					Parser<String, String> parser = null;
					try {
						parser = pool.borrowObject();
						parser.parse(null, null);
					} catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						if (parser != null) {
							pool.returnObject(parser);
						}
					}


				}
			};
			executorService.execute(runnable);

		}
		executorService.shutdown();

		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Pool Stats:\n Created:[%s], Borrowed:[%s]", pool.getCreatedCount(), pool.getBorrowedCount()));
		// write your code here
    }
}
