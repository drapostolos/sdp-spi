package org.adp4j.core;

import org.adp4j.spi.PolledDirectory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class DirectoryPollerTest {

	@Rule public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldThrowExceptionWhenDirectoryNotSet() {
		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage(String.format("Unable to build the '%s'", DirectoryPoller.class.getSimpleName()));
		expectedEx.expectMessage(String.format("%s.addDirectory(PolledDirectory)", DirectoryPollerBuilder.class.getSimpleName()));
		DirectoryPoller.newBuilder().start();
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowExceptionWhenAddingDirectoryThatIsNull() {
		// given
		PolledDirectory directoryMock = Mockito.mock(PolledDirectory.class);
		DirectoryPoller dp = DirectoryPoller.newBuilder()
				.addDirectory(directoryMock)
				.start();
		
		// when
		dp.addDirectory(null);
	}

	@Test(expected = NullPointerException.class)
	public void removeNullDirectory() {
		// given
		PolledDirectory directoryMock = Mockito.mock(PolledDirectory.class);
		DirectoryPoller dp = DirectoryPoller.newBuilder()
				.addDirectory(directoryMock)
				.start();
		
		// when
		dp.removeDirectory(null);
	}

	@Test(expected = NullPointerException.class)
	public void addNullListener() {
		// given
		PolledDirectory directoryMock = Mockito.mock(PolledDirectory.class);
		DirectoryPoller dp = DirectoryPoller.newBuilder()
				.addDirectory(directoryMock)
				.start();
		
		// when
		dp.addListener(null);
	}

	@Test(expected = NullPointerException.class)
	public void removeNullListener() {
		// given
		PolledDirectory directoryMock = Mockito.mock(PolledDirectory.class);
		DirectoryPoller dp = DirectoryPoller.newBuilder()
				.addDirectory(directoryMock)
				.start();
		
		// when
		dp.removeListener(null);
	}

}
