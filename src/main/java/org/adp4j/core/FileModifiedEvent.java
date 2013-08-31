package org.adp4j.core;

import org.adp4j.spi.FileElement;
import org.adp4j.spi.PolledDirectory;

/**
 * An event that represents a modified file in the {@link PolledDirectory}.
 *
 */
public final class FileModifiedEvent extends AbstractFileEvent {

	FileModifiedEvent(DirectoryPoller directoryPoller, PolledDirectory directory, FileElement file) {
		super(directoryPoller, directory, file);
	}

}
