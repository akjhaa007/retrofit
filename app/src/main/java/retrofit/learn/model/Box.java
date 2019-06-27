package retrofit.learn.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Box {

    @SerializedName("faceId")
    @Expose
    private String faceId;
    @SerializedName("boundingBox")
    @Expose
    private BoundingBox boundingBox;
    @SerializedName("imageId")
    @Expose
    private String imageId;
    @SerializedName("externalImageId")
    @Expose
    private String externalImageId;
    @SerializedName("confidence")
    @Expose
    private Double confidence;

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getExternalImageId() {
        return externalImageId;
    }

    public void setExternalImageId(String externalImageId) {
        this.externalImageId = externalImageId;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

}