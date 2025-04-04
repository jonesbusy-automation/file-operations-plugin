package sp.sd.fileoperations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.jvnet.hudson.test.WithoutJenkins;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;

public class FileOperationTest {

    @Test
    @WithoutJenkins
    public void testAbstractFileOperation() {
        // Create a concrete implementation of the abstract class for testing
        FileOperation operation = new FileOperation() {
            @Override
            public boolean runOperation(Run<?, ?> run, FilePath buildWorkspace, Launcher launcher, TaskListener listener) {
                // Test implementation that returns true
                return true;
            }
        };
        
        // Create a second implementation that returns false
        FileOperation operationFalse = new FileOperation() {
            @Override
            public boolean runOperation(Run<?, ?> run, FilePath buildWorkspace, Launcher launcher, TaskListener listener) {
                // Test implementation that returns false
                return false;
            }
        };
        
        // Test that the operation methods work as expected
        assertTrue(operation.runOperation(null, null, null, null));
        assertFalse(operationFalse.runOperation(null, null, null, null));
    }
} 