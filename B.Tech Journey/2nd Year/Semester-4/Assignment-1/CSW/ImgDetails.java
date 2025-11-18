class Image {
    private double imageWidth;
    private double imageHeight;
    private String colorCode;

    Image() {
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.colorCode = "Unknown";
    }

    Image(double imageWidth, double imageHeight, String colorCode) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.colorCode = colorCode;
    }

    void setImageWidth(double imageWidth) {
        this.imageWidth = imageWidth;
    }

    void setImageHeight(double imageHeight) {
        this.imageHeight = imageHeight;
    }

    void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    double getImageWidth() {
        return imageWidth;
    }

    double getImageHeight() {
        return imageHeight;
    }

    String getColorCode() {
        return colorCode;
    }

    @Override
    public String toString() {
        return "Image Width: " + imageWidth + ", Image Height: " + imageHeight + ", Color Code: " + colorCode;
    }
}

class ImgDetails {
    public static void main(String args[]) {
        Image defaultImg = new Image();
        System.out.println("\nDefault Constructor: " + defaultImg.toString());
        Image paramImg = new Image(45.5, 91, "RGBA");
        System.out.println("\nParameterized Constructor: " + paramImg.toString());
        paramImg.setImageWidth(50);
        paramImg.setImageHeight(100);
        paramImg.setColorCode("RGB");
        System.out.println("\nAfter Setting New Values: " + paramImg.toString());
    }
}
