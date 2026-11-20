package co.model.shared;

public record FileResource(
        String filename,
        String contentType,
        byte[] content
) {
    public FileResource {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename is required");
        }

        if (content == null || content.length == 0) {
            throw new IllegalArgumentException("File content is required");
        }

        if (contentType == null || contentType.isBlank()) {
            throw new IllegalArgumentException("Content type is required");
        }

        content = content.clone();
    }

    @Override
    public byte[] content() {
        return content.clone();
    }
}
