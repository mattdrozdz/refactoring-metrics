package refactoring.catalog.others.bank.after.controller;

import refactoring.catalog.others.bank.after.domain.Image;
import refactoring.catalog.others.bank.after.service.ImageService;

public class ImageController {

    private static final long ACCOUNT_REOPEN_FEE_CENTS = 2000;

    private ImageService imageService = new ImageService();

    public Image fetchImage(String id) {
        return imageService.fetch(id);
    }

    public Image uploadImage(String id, byte[] data){
        Image image = new Image(id, data);
        imageService.add(image);
        return image;
    }
}
