package de.slag.root.base;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public final class SlagConfigSupport {

	public static <T extends DatabaseConfig> T getDefault(final Class<T> configType) {

		if (configType == DatabaseConfig.class) {
			return configType.cast(defaultDatabase());
		}
		throw new BaseException("Not supported: " + configType);
	}

	private static DatabaseConfig defaultDatabase() {
		final String defaultDbConfigProperty = "DefaultDatabaseConfig";
		final Optional<String> defaultDatabaseConfig = SystemUtils.getSystemProperty(defaultDbConfigProperty);
		if (!defaultDatabaseConfig.isPresent()) {
			throw new BaseException("Property not set: '" + defaultDbConfigProperty + "'");
		}
		final Properties properties = PropertyUtils.fromFile(defaultDatabaseConfig.get());

		final String username = (String) Objects.requireNonNull(properties.get("username"), "'username' not found");
		final String url = (String) Objects.requireNonNull(properties.get("url"), "'url' not found");
		final String password = (String) Objects.requireNonNull(properties.get("password"), "'password' not found");
		final String driverClass = (String) Objects.requireNonNull(properties.get("driverClass"),
				"'driverClass' not found");
		final String dialect = (String) Objects.requireNonNull(properties.get("dialect"), "'dialect' not found");

		return new DatabaseConfig() {

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public String getUrl() {
				return url;
			}

			@Override
			public String getPassword() {
				return password;
			}

			@Override
			public String getDriverClass() {
				return driverClass;
			}

			@Override
			public String getDialect() {
				return dialect;
			}
		};
	}

}
