package de.slag.root.base;

public interface DatabaseConfig extends Comparable<DatabaseConfig> {

	String getDriverClass();

	String getUrl();

	String getUsername();

	String getPassword();

	String getDialect();

	@Override
	// FIXME
	default int compareTo(DatabaseConfig arg0) {		
		return getUrl().compareTo(arg0.getUrl());
	}
}