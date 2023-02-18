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
        Image image = new Image();
        Blog blog = blogRepository2.findById(blogId).get();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        imageRepository2.save(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        Image image=imageRepository2.findById(id).get();
        imageRepository2.delete(image);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) throws Exception {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = imageRepository2.findById(id).get();
        String dimensions = image.getDimensions();

        int i = 0;
        for(;i<screenDimensions.length();i++){
            if(screenDimensions.charAt(i)=='X'){
                break;
            }
        }

        int j = 0;
        for(;j<dimensions.length();j++){
            if(dimensions.charAt(j)=='X'){
                break;
            }
        }

        int lenBigImg = Integer.parseInt(screenDimensions.substring(0,i));
        int widBigImg = Integer.parseInt(screenDimensions.substring(i+1));
        int lenSmallImg = Integer.parseInt(dimensions.substring(0,j));
        int widSmallImg = Integer.parseInt(dimensions.substring(j+1));

        int dim1 = lenBigImg/lenSmallImg;
        int dim2 = widBigImg/widSmallImg;

        return dim1*dim2;

    }

}
