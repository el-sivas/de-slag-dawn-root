package de.slag.root.base;

public final class SlagConfigSupport {

	public static <T extends DatabaseConfig> T getDefault(final Class<T> configType) {
		
		if (configType == DatabaseConfig.class) {
			return configType.cast(defaultDatabase());
		}
		throw new BaseException("Not supported: " + configType);

	}

	private static DatabaseConfig defaultDatabase() {
		return new DatabaseConfig() {
			
			@Override
			public String getUsername() {
				return "test";
			}
			
			@Override
			public String getUrl() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDriverClass() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDialect() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
