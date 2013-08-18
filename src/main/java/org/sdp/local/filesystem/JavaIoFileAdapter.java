package org.sdp.local.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sdp.spi.FileObject;
import org.sdp.spi.PolledDirectory;

public class JavaIoFileAdapter extends FileObject implements PolledDirectory{
	private final File file;

	public JavaIoFileAdapter(File file) {
		this.file = file;
	}

	@Override
	public long lastModified() throws IOException {
		return file.lastModified();
	}

	@Override
	public boolean isDirectory() {
		return file.isDirectory();
	}

	@Override
	public String getName() {
		return file.getName();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaIoFileAdapter other = (JavaIoFileAdapter) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}

	@Override
	public List<FileObject> listFiles() throws IOException {
		List<FileObject> result = new ArrayList<FileObject>();
		for(File f : file.listFiles()){
			result.add(new JavaIoFileAdapter(f));
		}
		return result;
	}
	
	@Override
	public String toString() {
		return file.toString();
	}

}
