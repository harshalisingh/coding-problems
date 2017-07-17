package leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/articles/design-in-memory-file-system/
 */
public class InMemoryFileSystem {
}
class FileSystem {
    class File {
        boolean isfile = false;
        HashMap < String, File > files = new HashMap < > ();
        String content = "";
    }
    File root;
    public FileSystem() {
        root = new File();
    }

    /* Time Complexity: O(m+n+klog(k)).
     * m = length of input string, n = depth of last directory level, k = no of entries(files+subdirectories) in last level.
     * We need to sort these names giving a factor of klog(k)
     */
    public List < String > ls(String path) {
        File t = root;
        List < String > files = new ArrayList < > ();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isfile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List < String > res_files = new ArrayList < > (t.files.keySet());
        Collections.sort(res_files);
        return res_files;
    }

    /* O(m + n). m = length of input string, n = depth of the file name in the current input.  */
    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i]))
                t.files.put(d[i], new File());
            t = t.files.get(d[i]);
        }
    }

    /* O(m + n). m = length of input string, n = depth of the file name in the current input.  */
    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        if (!t.files.containsKey(d[d.length - 1]))
            t.files.put(d[d.length - 1], new File());
        t = t.files.get(d[d.length - 1]);
        t.isfile = true;
        t.content = t.content + content;
    }

    /* O(m + n). m = length of input string, n = depth of the file name in the current input.  */
    public String readContentFromFile(String filePath) {
        File t = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
