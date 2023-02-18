package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();


        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        blog.getImageList().add(image);
        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
        Image image=imageRepository2.findById(id).get();
        imageRepository2.delete(image);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();
        String imageDimension = image.getDimensions();
        String first[] = imageDimension.split("X");
        String second[] = screenDimensions.split("X");
        return Integer.parseInt(second[0])*Integer.parseInt(second[1])/(Integer.parseInt(first[0])*Integer.parseInt(first[1]));

    }
    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }
}
