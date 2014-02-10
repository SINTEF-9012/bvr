package no.sintef.cvl.tool.ui.editor;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class RestrictedJFileChooser extends JFileChooser {

	private static final long serialVersionUID = -4565310034642740530L;
	
	public RestrictedJFileChooser(String path){
		File dir = new File(path);
		RestrictedFileSystemView rfs = new RestrictedFileSystemView(dir);
		setFileSystemView(rfs);
		setCurrentDirectory(rfs.getDefaultDirectory());
	}

	class RestrictedFileSystemView extends FileSystemView{

		private final File[] rootDirectories;
		private final String defaultFolderName = "New Folder";

		public RestrictedFileSystemView(File rootDirectory){
			rootDirectories = new File[] {rootDirectory};
		}
			
		@Override
		public File getHomeDirectory() {
			return rootDirectories[0];
		}
		
		@Override
		public File getDefaultDirectory() {
			return rootDirectories[0];
		}
		
	    @Override
	    public File[] getRoots()
	    {
	        return rootDirectories;
	    }

	    @Override
	    public boolean isRoot(File file)
	    {
	        for (File root : rootDirectories) {
	            if (root.equals(file)) {
	                return true;
	            }
	        }
	        return false;
	    }
		
		@Override
		public File createNewFolder(File containingDir) throws IOException {
			String folderName = getDirectoryName(containingDir, 0);
			File newFolder = new File(containingDir + File.separator + folderName);
			newFolder.mkdir();
			return newFolder;
		}
		
		private String getDirectoryName(File containingDir, Integer attempt){
			String newFolderName = (attempt == 0) ? new String(defaultFolderName) : new String(defaultFolderName) + " (" + attempt + ")";
			File newFolder = new File(containingDir + File.separator + newFolderName);
			if(newFolder.exists()){
				newFolderName = getDirectoryName(containingDir, ++attempt);
			}
			return newFolderName;
		}
	}
}
