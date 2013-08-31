package org.adp4j.core;

import org.adp4j.spi.PolledDirectory;

abstract class AbstractDirectoryEvent extends Event{
	private final PolledDirectory directory;

	AbstractDirectoryEvent(DirectoryPoller directoryPoller, PolledDirectory directory) {
		super(directoryPoller);
		this.directory = directory;
	}
	
	/**
	 * Return The {@link PolledDirectory} instance, where this event occurred. 
	 */
	public PolledDirectory getDirectory() {
		return directory;
	}

}
