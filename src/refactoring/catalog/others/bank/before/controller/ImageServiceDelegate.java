package refactoring.catalog.others.bank.before.controller;


import refactoring.catalog.others.bank.before.domain.Image;
import refactoring.catalog.others.bank.before.service.ImageService;

public class ImageServiceDelegate {

   private ImageService imageService = new ImageService();

    public Image fetch(String id) {
        return imageService.fetch(id);
    }

    public int count() {
        return imageService.count();
    }

    public void add(Image image) {
        imageService.add(image);
    }
}
