package se331.assignment.controller;

import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import se331.assignment.entity.Product;
import se331.assignment.services.ProductService;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
@Controller
@Path("/product")
@ConfigurationProperties(prefix = "image")
public class ProductController {
    @Autowired
    ProductService productService;

    String imageServerDirectory;

    public void setImageServerDirectory(String imageServerDirectory) {
        this.imageServerDirectory = imageServerDirectory;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct() {
        return Response.ok(productService.getAllProduct()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") long id) {
        Product product = productService.getProductById(id);
        if(product != null)
            return Response.ok(product).build();
        else
            return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        productService.addProduct(product);
        return Response.ok().entity(product).build();
    }

    @POST
    @Path("/image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadImage(@FormDataParam("file") InputStream fileInputStream,
                                @FormDataParam("file") FormDataContentDisposition cdh) throws Exception {
        try {
            BufferedImage img = ImageIO.read(fileInputStream);
            String oldFilename = cdh.getFileName();
            String ext = FilenameUtils.getExtension(oldFilename);
            String newFilename = Integer.toString(LocalTime.now().hashCode(), 16) + Integer.toString(oldFilename.hashCode(), 16) + "."+ext;
            File targetFle = Files.createFile(Paths.get(imageServerDirectory + newFilename)).toFile();
            ImageIO.write(img, ext, targetFle);

            return Response.ok(newFilename).build();
        }catch (NullPointerException e){
            return Response.status(202).build();
        }
    }

    @GET
    @Path("/image/{fileName}")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response getProductImage(@PathParam("fileName") String filename) {
        System.out.printf(imageServerDirectory + filename);
        File file = Paths.get(imageServerDirectory + filename).toFile();
        if (file.exists()) {
            Response.ResponseBuilder responseBuilder = Response.ok((Object) file);
            responseBuilder.header("Content-Disposition", "attachment; filename=" + filename);
            return responseBuilder.build();
        }else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }


}
