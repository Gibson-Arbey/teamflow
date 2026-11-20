package co.api.shared.converter;

import co.model.shared.FileResource;
import org.springframework.web.multipart.MultipartFile;

public class FileResourceConverter {

    public static FileResource toFileResource(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                return null;
            }


            return new FileResource(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
