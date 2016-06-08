
public class Adapter{
	public static void main(String[] args){
		VectorGraphicsInterface g = new VectorAdapterFromRaster();
		g.drawLine();
		g.drawSquare();

		VectorGraphicsInterface g1 = new VectorAdapterFromRaster1();
		g1.drawLine();
		g1.drawSquare();


		VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
		g2.drawLine();
		g2.drawSquare();
	}
}

interface VectorGraphicsInterface{
	void drawLine();
	void drawSquare();
}

class RasterGraphics{
	void drawRasterLine(){
		System.out.println("Draw line");
	}
	void drawRasterSquare(){
		System.out.println("Draw square");
	}
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
	public void drawLine(){
		drawRasterLine();
	}
	public void drawSquare(){
		drawRasterSquare();
	}
}

class VectorAdapterFromRaster1 implements VectorGraphicsInterface {
	RasterGraphics raster = new RasterGraphics();
	public void drawLine(){
		raster.drawRasterLine();
	}
	public void drawSquare(){
		raster.drawRasterSquare();
	}
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
	RasterGraphics raster = null;
	VectorAdapterFromRaster2(RasterGraphics raster){
		this.raster = raster;
	}
	public void drawLine(){
		raster.drawRasterLine();
	}
	public void drawSquare(){
		raster.drawRasterSquare();
	}
}