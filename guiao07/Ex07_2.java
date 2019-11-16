package guiao07;

public class Ex07_2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		String DIR = "src/guiao07/";
		String figura = DIR + "Figura.bmp";
		String figuraRaw = DIR + "FiguraRaw";
		String copyFile = DIR + "FiguraCopy.bmp";
		String flipHorizontal = DIR + "Horizontal.bmp";
		String flipVertical = DIR + "Vertical.bmp";
		String clone = DIR + "clone.bmp";
		String adjustSizeFile = DIR + "adjustSize.bmp";
		String initialImage = DIR + "initial.bmp";
		
		Bitmap bm = new Bitmap(figura);
		System.out.println(bm.toString());
		
		Bitmap a = bm.clone();
		
		bm.saveRawFile(figuraRaw);
		bm.makeCopy(copyFile);		
		
		bm.invertImageHorizontally();
		bm.save(flipHorizontal);
		
		bm.invertImageVertically();
		bm.save(flipVertical);
		
		bm.getInitialImage();
		bm.save(initialImage);
		
		a.save(clone);
		
		bm.adjustSize(0.5);
		bm.save(adjustSizeFile);		
	}

}
