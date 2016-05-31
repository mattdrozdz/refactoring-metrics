package refactoring.catalog.others.bank.before.domain;

public class Image {

    private final String imageId;
    private final byte[] data;

    public Image(String imageId, byte[] data) {
        this.imageId = imageId;
        this.data = data;
    }

    public String getImageId() {
        return imageId;
    }

    public byte[] getData() {
        return data;
    }
}
