import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable; 
import java.lang.*;
import java.net.URLDecoder;  


public class UnSafelink { 
        public static void main(String args[]){ 
         Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null); 
            try{ 
                if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    String text = (String)t.getTransferData(DataFlavor.stringFlavor); 
                    String link = URLDecoder.decode(text, "UTF-8");
                    String delimiters = "url=|&data";
                    String[] unsafed = link.split(delimiters);
                    String endText = (unsafed[1]);
                    StringSelection ss = new StringSelection(endText); 
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
                } 
            } catch (Exception e) { 
            } 
        } 
} 