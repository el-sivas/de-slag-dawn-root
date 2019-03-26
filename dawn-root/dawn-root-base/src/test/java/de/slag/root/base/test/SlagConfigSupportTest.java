package de.slag.root.base.test;

import org.junit.Assert;
import org.junit.Test;

import de.slag.root.base.DatabaseConfig;
import de.slag.root.base.SlagConfigSupport;

public class SlagConfigSupportTest {
	
	@Test
	public void test() {
		Assert.assertNotNull(SlagConfigSupport.getDefault(DatabaseConfig.class));
	}

}
